package org.yaorma.codeGenerator.generateOrmForSchema;

import java.io.File;
import java.sql.Connection;

import org.yaorma.codeGenerator.dvo.DvoGenerator;
import org.yaorma.database.Data;
import org.yaorma.database.Database;

public class GenerateOrmForSchema {

	/***
	 * 
	 * This method can be used for MySql. The method that takes the Data object
	 * should be used for other databases.
	 * 
	 */
	public static void execute(Connection conn, String schemaName, String packageName, File destDir) throws Exception {
		// generate all dvo classes for schema
		String sqlString = "";
		sqlString += "select table_name \n";
		sqlString += "from information_schema.tables \n";
		sqlString += "where table_schema = ?";
		Data data = Database.query(sqlString, schemaName, conn);
		for (int i = 0; i < data.size(); i++) {
			String tableName = data.get(i).get("tableName");
			DvoGenerator dvo = new DvoGenerator(tableName, schemaName, conn);
			dvo.createDvo(destDir, packageName);
		}
	}

	/***
	 * 
	 * Method to generated data access objects for the given schema.  
	 * 
	 */
	public static void execute(Connection conn, Data data, String dataColName, String schemaColName, String packageName, File destDir) throws Exception {
		for (int i = 0; i < data.size(); i++) {
			String tableName = data.get(i).get(dataColName);
			DvoGenerator dvo = new DvoGenerator(tableName, schemaColName, conn);
			dvo.createDvo(destDir, packageName);
		}
	}

}
