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

	public static int update(String sqlString, Connection conn) {
		ArrayList<String> params = new ArrayList<String>();
		return update(sqlString, params, conn);
	}

	public static int update(String sqlString, String param, Connection conn) {
		ArrayList<String> params = new ArrayList<String>();
		params.add(param);
		return update(sqlString, params, conn);
	}

	public static int update(String sqlString, List<String> params, Connection conn) {
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
	// batch stuff
	//
	// ------------------------------------------------------------------------

	public static PreparedStatement getPreparedStatement(String sqlString, Connection conn) {
		try {
			return conn.prepareStatement(sqlString);
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static void addToBatch(List<String> params, PreparedStatement ps) {
		try {
			for (int i = 0; i < params.size(); i++) {
				ps.setString((i + 1), params.get(i));
			}
			ps.addBatch();
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static int[] execute(PreparedStatement ps) {
		return execute(ps, true);
	}
	
	public static int[] execute(PreparedStatement ps, boolean close) {
		try {
			return ps.executeBatch();
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		} finally {
			if(close) {
				try {
					ps.close();
				} catch(Exception exp) {
					throw new RuntimeException(exp);
				}
			}
		}
	}
	
	public static boolean isClosed(PreparedStatement ps) {
		try {
			return ps.isClosed();
		} catch(Exception exp) {
			throw new RuntimeException(exp);
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

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

}
