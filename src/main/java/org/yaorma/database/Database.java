package org.yaorma.database;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.yaorma.util.string.DbToJavaNamingConverter;

public class Database {

	// ------------------------------------------------------------------------
	//
	// query methods
	//
	// ------------------------------------------------------------------------

	public static Data query(String sqlString, Connection conn) {
		return query(sqlString, new ArrayList<String>(), conn);
	}

	public static Data query(String sqlString, String param, Connection conn) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(param);
		return query(sqlString, list, conn);
	}

	public static Data query(String sqlString, String[] params, Connection conn) {
		ArrayList<String> list = new ArrayList<String>();
		for (String param : params) {
			list.add(param);
		}
		return query(sqlString, list, conn);
	}

	public static Data query(String sqlString, List<String> params, Connection conn) {
		Data rtn = new Data();
		ResultSet rs = null;
		try {
			rs = executeQuery(sqlString, params, conn);
			List<String> colNames = getColumnNames(rs);
			while (rs.next()) {
				Row row = new Row();
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
		List<Object> params = new ArrayList<Object>();
		return update(sqlString, params, conn);
	}

	public static int update(String sqlString, Object param, Connection conn) {
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(param);
		return update(sqlString, params, conn);
	}

	public static int update(String sqlString, Object[] params, Connection conn) {
		ArrayList<Object> paramsArray = new ArrayList<Object>();
		Collections.addAll(paramsArray, params);
		return update(sqlString, paramsArray, conn);
	}

	public static int update(String sqlString, List<Object> params, Connection conn) {
		try {
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement(sqlString);
				for (int i = 0; i < params.size(); i++) {
					Object obj = params.get(i);
					if(obj == null) {
						st.setString((i+1), null);
					} else if(obj instanceof Date) {
						Date date = (Date) obj;
						java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						st.setDate((i+1), sqlDate);
					} else if (obj instanceof Integer) {
						st.setInt((i+1), (Integer) obj);
					} else if (obj instanceof Double) {
						st.setDouble((i+1), (Double) obj);
					} else if (obj instanceof Long) {
						st.setLong((i+1), (Long) obj);
					} else {
						st.setString(i + 1, params.get(i) + "");
					}
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
		} catch (Exception exp) {
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
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		} finally {
			if (close) {
				try {
					ps.close();
				} catch (Exception exp) {
					throw new RuntimeException(exp);
				}
			}
		}
	}

	public static boolean isClosed(PreparedStatement ps) {
		try {
			return ps.isClosed();
		} catch (Exception exp) {
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
			if(conn != null) {
				conn.close();
			}
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static void commit(Connection conn) {
		try {
			conn.setAutoCommit(false);
			conn.commit();
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static void executeSqlScript(File file, Connection conn) {
		try {
			FileInputStream fis = new FileInputStream(file);
			executeSqlScript(fis, conn);
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static void executeSqlScript(String str, Connection conn) {
		InputStream in = new ByteArrayInputStream(str.getBytes());
		executeSqlScript(in, conn);
	}
	
	public static void executeSqlScript(InputStream in, Connection conn) {
		Reader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			ScriptRunner sr = new ScriptRunner(conn);
			sr.setAutoCommit(true);
			sr.setStopOnError(true);
			sr.runScript(reader);
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception exp) {
					throw new RuntimeException(exp);
				}
			}
		}
	}

}
