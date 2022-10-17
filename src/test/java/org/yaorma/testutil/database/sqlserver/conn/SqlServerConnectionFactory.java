package org.yaorma.testutil.database.sqlserver.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlServerConnectionFactory {

	private static final String url = "jdbc:sqlserver://localhost;databaseName=master;integratedSecurity=true;encrypt=false";

	public static Connection getBootstrapConnection() {
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (Exception exp) {
			throw (new RuntimeException(exp));
		}

	}

}
