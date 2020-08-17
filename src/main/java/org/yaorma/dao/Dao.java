package org.yaorma.dao;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.yaorma.database.Database;
import org.yaorma.dvo.Dvo;
import org.yaorma.dvo.DvoUtil;
import org.yaorma.util.string.DbToJavaNamingConverter;

public class Dao {

	// ------------------------------------------------------------------------
	//
	// insert methods
	//
	// ------------------------------------------------------------------------

	public static <T extends Dvo> T insert(T dvo, String key, String val, Connection conn) {
		insert(dvo, conn);
		dvo = find(dvo, key, val, conn);
		return dvo;
	}
	
	public static int insert(Dvo dvo, Connection conn) {
		try {
			String sqlString = createInsertSqlString(dvo);
			ArrayList<String> params = new ArrayList<String>();
			String[] javaNames = dvo.getJavaNames();
			for (int i = 0; i < javaNames.length; i++) {
				String javaName = javaNames[i];
				String value = DvoUtil.getValue(dvo, javaName);
				params.add(value);
			}
			return Database.update(sqlString, params, conn);
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static String createInsertSqlString(Dvo dvo) throws Exception {
		String tableName = dvo.getTableName();
		String[] columnNames = dvo.getColumnNames();
		String[] javaNames = dvo.getJavaNames();
		String sqlString = "";
		sqlString += "insert into " + tableName + " (\n";
		for (int i = 0; i < columnNames.length; i++) {
			if (i > 0) {
				sqlString += ", \n";
			}
			sqlString += "  " + columnNames[i];
		}
		sqlString += "\n";
		sqlString += ")\n";
		sqlString += "values (\n";
		for (int i = 0; i < javaNames.length; i++) {
			if (i > 0) {
				sqlString += ", \n";
			}
			sqlString += "  ?";
		}
		sqlString += "\n";
		sqlString += ")\n";
		return sqlString;
	}

	// ------------------------------------------------------------------------
	//
	// find methods
	//
	// ------------------------------------------------------------------------

	public static <T extends Dvo> T find(T dvo, String key, String val, Connection conn) {
		try {
			String tableName = dvo.getTableName();
			String sqlString = "select * from " + tableName + " where " + key + " = ?";
			ResultSet rs = null;
			try {
				rs = Database.executeQuery(sqlString, val, conn);
				rs.next();
				load(dvo, rs);
				return dvo;
			} finally {
				Database.closeResultSet(rs);
			}
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static <T extends Dvo> List<T> findList(T dvo, String sqlString, String param, Connection conn) {
		try {
			ArrayList<T> rtn = new ArrayList<T>();
			ResultSet rs = null;
			try {
				rs = Database.executeQuery(sqlString, param, conn);
				while(rs.next()) {
					T instance = (T) dvo.getClass().newInstance();
					load(instance, rs);
					rtn.add(instance);
				}
				return rtn;
			} finally {
				Database.closeResultSet(rs);
			}
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static void load(Dvo dvo, ResultSet rs) throws Exception {
		ArrayList<String> colNames = getCommonColumns(dvo, rs);
		for (int i = 0; i < colNames.size(); i++) {
			String colName = colNames.get(i);
			String value = rs.getString(colName);
			Method method = getSetterForName(dvo, colName);
			Object[] args = { value };
			method.invoke(dvo, args);
		}
	}

	// ------------------------------------------------------------------------
	//
	// internal implementation (all private past here)
	//
	// ------------------------------------------------------------------------
	
	private static ArrayList<String> getCommonColumns(Dvo dvo, ResultSet rs) throws Exception {
		ArrayList<String> rtn = new ArrayList<String>();
		String[] dvoColumns = dvo.getJavaNames();
		ResultSetMetaData meta = rs.getMetaData();
		int cnt = meta.getColumnCount();
		for (int i = 0; i < cnt; i++) {
			String colName = meta.getColumnName(i + 1);
			for (int d = 0; d < dvoColumns.length; d++) {
				String dvoColumnName = dvoColumns[d];
				if (dvoColumnName != null && dvoColumnName.equals(colName)) {
					rtn.add(colName);
				}
			}
		}
		return rtn;
	}

	public static Method getSetterForName(Dvo dvo, String javaName) throws Exception {
		String methodName = "set" + DbToJavaNamingConverter.toProper(javaName);
		Class[] sig = { String.class };
		Method method = dvo.getClass().getMethod(methodName, sig);
		return method;
	}

}
