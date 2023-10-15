package org.yaorma.codeGenerator.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface OrmCodeGeneratorImpl {

	public ArrayList<String[]> initCols(Connection conn, String tableName, String schemaName) throws Exception;

	public ArrayList<String> initPrimaryKeyCols(Connection conn, String tableName, String schemaName) throws Exception;

	public ArrayList<HashMap<String, String>> initLookUps(Connection conn, String tableName, String schemaName) throws Exception;

	public ArrayList<HashMap<String, String>> initChildTables(Connection conn, String tableName, String schemaName) throws Exception;
	
	public List<String> getTableNames(Connection conn);

}
