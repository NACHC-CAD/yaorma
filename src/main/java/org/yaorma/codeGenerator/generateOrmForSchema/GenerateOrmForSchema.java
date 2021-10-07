package org.yaorma.codeGenerator.generateOrmForSchema;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import org.yaorma.codeGenerator.dvo.DvoGenerator;
import org.yaorma.codeGenerator.impl.def.OrmCodeGeneratorImpl;
import org.yaorma.database.Data;
import org.yaorma.database.Database;

public class GenerateOrmForSchema {

	/***
	 * 
	 * This method can be used for MySql. The method that takes the Data object
	 * should be used for other databases.
	 * 
	 */
	public static void execute(Connection conn, String schemaName, String packageName, File destDir, OrmCodeGeneratorImpl gen) throws Exception {
		try {
			// generate all dvo classes for schema
			String sqlString = "";
			sqlString += "select table_name \n";
			sqlString += "from information_schema.tables \n";
			sqlString += "where table_schema = ?";
			Data data = Database.query(sqlString, schemaName, conn);
			for (int i = 0; i < data.size(); i++) {
				String tableName = data.get(i).get("tableName");
				DvoGenerator dvo = new DvoGenerator(tableName, schemaName, conn, gen);
				dvo.createDvo(destDir, packageName);
			}
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	/***
	 * 
	 * Method to generated data access objects for the given schema.  
	 * 
	 */
	public static void execute(Connection conn, List<String> tableNames, String schemaName, String packageName, File destDir, OrmCodeGeneratorImpl gen) {
		try {
			for (String tableName : tableNames) {
				DvoGenerator dvo = new DvoGenerator(tableName, schemaName, conn, gen);
				dvo.createDvo(destDir, packageName);
			}
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

}
