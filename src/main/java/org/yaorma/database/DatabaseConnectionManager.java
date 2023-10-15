package org.yaorma.database;

import java.sql.Connection;

public interface DatabaseConnectionManager {

	public void resetConnections();

	public void resetConnection(String name);

	public Connection getConnection(String name);

}
