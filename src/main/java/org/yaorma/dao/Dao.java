package org.yaorma.dao;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.yaorma.database.Database;
import org.yaorma.dvo.Dvo;
import org.yaorma.dvo.DvoUtil;
import org.yaorma.util.string.DbToJavaNamingConverter;
import org.yaorma.util.time.TimeUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	// TODO: (JEG) rewrite this to use prepared statement
	public static <T extends Dvo> void insert(List<T> list, Connection conn) {
		int cnt = 0;
		for (Dvo dvo : list) {
			cnt++;
			log.info("Doing insert " + cnt + " of " + list.size());
			insert(dvo, conn);
		}
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
			if (sqlString.endsWith("values (\n  ") == false) {
				sqlString += ",\n  ";
			}
			Object obj = params.get(i);
			if (obj instanceof Date) {
				Date date = (Date) obj;
				String dateString = TimeUtil.getDateAsYyyyMmDd(date);
				sqlString += "CAST(UNIX_TIMESTAMP('" + dateString + "', 'yyyyMMdd') AS TIMESTAMP)";
			} else if (obj instanceof Integer) {
				sqlString += obj + "";
			} else if (obj instanceof Double) {
				sqlString += obj + "";
			} else if (obj instanceof Long) {
				sqlString += obj + "";
			} else if (obj == null) {
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
		return find(dvo, new String[] { key }, new String[] { val }, conn);
	}

	public static <T extends Dvo> T find(T dvo, String[] keys, String[] vals, Connection conn) {
		try {
			String schemaName = dvo.getSchemaName();
			String tableName = dvo.getTableName();
			String sqlString = "select * from " + schemaName + "." + tableName + " where  1=1 \n";
			for (String key : keys) {
				sqlString += " and " + key + " = ? \n";
			}
			ResultSet rs = null;
			try {
				rs = Database.executeQuery(sqlString, vals, conn);
				if (rs.next()) {
					load(dvo, rs);
					return dvo;
				} else {
					return null;
				}
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
		if (params.length == 0) {
			throw new RuntimeException("Tried to delete without a primary key value.");
		}
		Database.update(sqlString, params, conn);
	}

	public static <T extends Dvo> List<T> findList(T dvo, String key, String val, Connection conn) {
		return findList(dvo, key, val, null, conn);
	}

	public static <T extends Dvo> List<T> findList(T dvo, String key, String val, String orderBy, Connection conn) {
		String sqlString = "";
		sqlString += "select * from " + dvo.getSchemaName() + "." + dvo.getTableName() + " where " + key + " = ?";
		if (orderBy != null) {
			sqlString += " order by " + orderBy;
		}
		return findListBySql(dvo, sqlString, val, conn);
	}

	public static <T extends Dvo> List<T> findListBySql(T dvo, String sqlString, String param, Connection conn) {
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
			String javaName = colNames.get(i);
			String colName = DbToJavaNamingConverter.toDatabaseName(javaName);
			int type = rs.getMetaData().getColumnType(i + 1);
			if (type == Types.DATE || type == Types.TIME || type == Types.TIMESTAMP) {
				Date value = rs.getDate(colName);
				Method method = getDateSetterForName(dvo, javaName);
				Object[] args = { value };
				method.invoke(dvo, args);
			} else if (type == Types.INTEGER) {
				Integer value = rs.getInt(colName);
				Method method = getIntSetterForName(dvo, javaName);
				Object[] args = { value };
				method.invoke(dvo, args);
			} else if (type == Types.BIGINT) {
				Long value = rs.getLong(colName);
				Method method = getLongSetterForName(dvo, javaName);
				Object[] args = { value };
				method.invoke(dvo, args);
			} else {
				String value = rs.getString(colName);
				Method method = getStringSetterForName(dvo, javaName);
				Object[] args = { value };
				method.invoke(dvo, args);
			}
		}
	}

	// ------------------------------------------------------------------------
	//
	// internal implementation (all private past here)
	//
	// ------------------------------------------------------------------------

	private static ArrayList<String> getCommonColumns(Dvo dvo, ResultSet rs) throws Exception {
		ArrayList<String> rtn = new ArrayList<String>();
		String[] dvoColumns = dvo.getColumnNames();
		ResultSetMetaData meta = rs.getMetaData();
		int cnt = meta.getColumnCount();
		for (int i = 0; i < cnt; i++) {
			String colName = meta.getColumnName(i + 1);
			for (int d = 0; d < dvoColumns.length; d++) {
				String dvoColumnName = dvoColumns[d];
				if (dvoColumnName != null && dvoColumnName.equals(colName)) {
					String javaName = DbToJavaNamingConverter.toJavaProperName(colName);
					rtn.add(javaName);
					continue;
				}
			}
		}
		return rtn;
	}

	public static Method getStringSetterForName(Dvo dvo, String javaName) throws Exception {
		String methodName = "set" + DbToJavaNamingConverter.toProper(javaName);
		Class[] sig = { String.class };
		Method method = dvo.getClass().getMethod(methodName, sig);
		return method;
	}

	public static Method getDateSetterForName(Dvo dvo, String javaName) throws Exception {
		String methodName = "set" + DbToJavaNamingConverter.toProper(javaName);
		Class[] sig = { Date.class };
		Method method = dvo.getClass().getMethod(methodName, sig);
		return method;
	}

	public static Method getIntSetterForName(Dvo dvo, String javaName) throws Exception {
		String methodName = "set" + DbToJavaNamingConverter.toProper(javaName);
		Class[] sig = { Integer.class };
		Method method = dvo.getClass().getMethod(methodName, sig);
		return method;
	}

	public static Method getLongSetterForName(Dvo dvo, String javaName) throws Exception {
		String methodName = "set" + DbToJavaNamingConverter.toProper(javaName);
		Class[] sig = { Long.class };
		Method method = dvo.getClass().getMethod(methodName, sig);
		return method;
	}

}
