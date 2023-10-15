package org.yaorma.codeGenerator.generateOrmForSchema;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import org.yaorma.codeGenerator.dvo.DvoGenerator;
import org.yaorma.codeGenerator.impl.OrmCodeGeneratorImpl;
import org.yaorma.codeGenerator.impl.mysql.MySqlOrmCodeGenerator;
import org.yaorma.database.Data;
import org.yaorma.database.Database;

public class GenerateOrmForSchema {

	/***
	 * 
	 * Method to generated data access objects for the given schema.  
	 * 
	 */
	public static void execute(Connection conn, String schemaName, String packageName, File destDir, OrmCodeGeneratorImpl gen) {
		List<String> tableNames = gen.getTableNames(conn);
		execute(conn, tableNames, schemaName, packageName, destDir, gen);
	}

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
