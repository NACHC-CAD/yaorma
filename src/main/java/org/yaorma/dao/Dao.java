package org.yaorma.dao;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.yaorma.database.Database;
import org.yaorma.dvo.Dvo;
import org.yaorma.dvo.DvoUtil;
import org.yaorma.util.string.DbToJavaNamingConverter;
import org.yaorma.util.time.TimeUtil;

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

	public static int insertUsingLiteral(Dvo dvo, Connection conn) {
		String sqlString = getDatabricksLiteralInsertSqlString(dvo);
		int rtn = Database.update(sqlString, conn);
		return rtn;
	}

	public static int doDatabricksInsert(Dvo dvo, Connection conn) {
		return insertUsingLiteral(dvo, conn);
	}
	
	public static int insert(Dvo dvo, Connection conn) {
		try {
			String sqlString = getInsertSqlString(dvo);
			ArrayList<Object> params = new ArrayList<Object>();
			String[] javaNames = dvo.getJavaNames();
			for (int i = 0; i < javaNames.length; i++) {
				String javaName = javaNames[i];
				Object obj = DvoUtil.getValue(dvo, javaName);
				params.add(obj);
			}
			return Database.update(sqlString, params, conn);
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static String getDatabricksLiteralInsertSqlString(Dvo dvo) {
		List<Object> params = DvoUtil.getParamValues(dvo);
		String sqlString = "insert into " + dvo.getSchemaName() + "." + dvo.getTableName() + " values (\n  ";
		for (int i = 0; i < params.size(); i++) {
			if(sqlString.endsWith("values (\n  ") == false) {
				sqlString += ",\n  ";
			}
			Object obj = params.get(i);
			if(obj instanceof Date) {
				Date date = (Date) obj;
				String dateString = TimeUtil.getDateAsYyyyMmDd(date);
				sqlString += "CAST(UNIX_TIMESTAMP('" + dateString + "', 'yyyyMMdd') AS TIMESTAMP)";
			} else if (obj instanceof Integer) {
				sqlString += obj + "";
			} else if (obj instanceof Double) {
				sqlString += obj + "";
			} else if (obj instanceof Long) {
				sqlString += obj + "";
			} else if(obj == null) {
				sqlString += "NULL";
			} else {
				sqlString += "'" + obj + "'";
			}
		}
		sqlString += "\n)\n";
		return sqlString;
	}
	
	public static String getInsertSqlString(Dvo dvo) {
		String schemaName = dvo.getSchemaName();
		String tableName = dvo.getTableName();
		String[] javaNames = dvo.getJavaNames();
		String sqlString = "";
		sqlString += "insert into " + schemaName + "." + tableName;
		sqlString += "\n";
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
			String schemaName = dvo.getSchemaName();
			String tableName = dvo.getTableName();
			String sqlString = "select * from " + schemaName + "." + tableName + " where " + key + " = ?";
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

	public static String getDeleteString(Dvo dvo) {
		String[] primaryKeys = dvo.getPrimaryKeyColumnNames();
		String sqlString = "delete from " + dvo.getSchemaName() + "." + dvo.getTableName() + " tbl where ";
		for (int i = 0; i < primaryKeys.length; i++) {
			if (sqlString.endsWith("where ") == false) {
				sqlString += " and ";
			}
			sqlString += "tbl." + primaryKeys[i] + " = ?";
		}
		return sqlString;
	}

	public static void delete(Dvo dvo, Connection conn) {
		String sqlString = getDeleteString(dvo);
		String[] params = dvo.getPrimaryKeyValues();
		if(params.length == 0) {
			throw new RuntimeException("Tried to delete without a primary key value.");
		}
		Database.update(sqlString, params, conn);
	}

	public static <T extends Dvo> List<T> findList(T dvo, String sqlString, String param, Connection conn) {
		try {
			ArrayList<T> rtn = new ArrayList<T>();
			ResultSet rs = null;
			try {
				rs = Database.executeQuery(sqlString, param, conn);
				while (rs.next()) {
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
