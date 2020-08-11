package org.yaorma.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaorma.util.string.StringUtil;

public class Database {

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
					row.put(StringUtil.toJavaName(colName), val);
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

	// ---
	//
	// internal implementation (all private past here)
	//
	// ---

	//
	// method to execute a sql query
	//

	private static ResultSet executeQuery(String sqlString, List<String> params, Connection conn) {
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

	private static void closeResultSet(ResultSet rs) {
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

	private static List<String> getColumnNames(ResultSet rs) {
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

}
