package org.yaorma.database;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaorma.dvo.Dvo;
import org.yaorma.util.string.DbToJavaNamingConverter;

public class Database {

	// ------------------------------------------------------------------------
	//
	// query methods
	//
	// ------------------------------------------------------------------------

	public static List<Map<String, String>> query(String sqlString, String param, Connection conn) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(param);
		return query(sqlString, list, conn);
	}

	public static List<Map<String, String>> query(String sqlString, String[] params, Connection conn) {
		ArrayList<String> list = new ArrayList<String>();
		for (String param : params) {
			list.add(param);
		}
		return query(sqlString, list, conn);
	}

	public static List<Map<String, String>> query(String sqlString, List<String> params, Connection conn) {
		List<Map<String, String>> rtn = new ArrayList<Map<String, String>>();
		ResultSet rs = null;
		try {
			rs = executeQuery(sqlString, params, conn);
			List<String> colNames = getColumnNames(rs);
			while (rs.next()) {
				HashMap<String, String> row = new HashMap<String, String>();
				for (String colName : colNames) {
					String val = rs.getString(colName);
					row.put(DbToJavaNamingConverter.toJavaName(colName), val);
				}
				rtn.add(row);
			}
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		} finally {
			if (rs != null) {
				closeResultSet(rs);
			}
		}
		return rtn;
	}

	// ------------------------------------------------------------------------
	//
	// insert methods
	//
	// ------------------------------------------------------------------------

	public static int update(String sqlString, ArrayList<String> params, Connection conn) {
		try {
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement(sqlString);
				for (int i = 0; i < params.size(); i++) {
					st.setString(i + 1, params.get(i));
				}
				return st.executeUpdate();
			} finally {
				if (st != null) {
					st.close();
				}
			}
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	// ------------------------------------------------------------------------
	//
	// dvo methods
	//
	// ------------------------------------------------------------------------

	public static <T extends Dvo> T find(T dvo, String key, String val, Connection conn) {
		try {
			String tableName = dvo.getTableName();
			String sqlString = "select * from " + tableName + " where " + key + " = ?";
			ResultSet rs = null;
			try {
				rs = executeQuery(sqlString, val, conn);
				rs.next();
				load(dvo, rs);
				return dvo;
			} finally {
				closeResultSet(rs);
			}
		} catch(Exception exp) {
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

	//
	// method to execute a sql query
	//

	public static ResultSet executeQuery(String sqlString, String key, Connection conn) {
		ArrayList<String> params = new ArrayList<String>();
		params.add(key);
		return executeQuery(sqlString, params, conn);
	}

	public static ResultSet executeQuery(String sqlString, List<String> params, Connection conn) {
		try {
			PreparedStatement st = conn.prepareStatement(sqlString);
			for (int i = 0; i < params.size(); i++) {
				st.setString(i + 1, params.get(i));
			}
			ResultSet rs = st.executeQuery();
			return rs;
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	//
	// method to close a result set
	//

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				Statement st = rs.getStatement();
				rs.close();
				st.close();
			}
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	//
	// method to get column names for a result set
	//

	public static List<String> getColumnNames(ResultSet rs) {
		try {
			ArrayList<String> rtn = new ArrayList<String>();
			int cnt = rs.getMetaData().getColumnCount();
			for (int i = 1; i < cnt + 1; i++) {
				String str = rs.getMetaData().getColumnName(i);
				rtn.add(str);
			}
			return rtn;
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	// ------------------------------------------------------------------------
	//
	// internal implementation (all private past here)
	//
	// ------------------------------------------------------------------------

	//
	// dvo methods
	//
	
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
