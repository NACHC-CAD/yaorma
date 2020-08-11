package org.yaorma.codeGenerator.generateOrmForSchema;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.yaorma.codeGenerator.dvo.DvoGenerator;
import org.yaorma.database.Database;

public class GenerateOrmForSchema {

	public static void execute(Connection conn, String schemaName, String packageName, File destDir) throws Exception {
		System.out.println(destDir.getCanonicalPath());
		// generate all dvo classes for schema
		String sqlString = "";
		sqlString += "select table_name \n";
		sqlString += "from information_schema.tables \n";
		sqlString += "where table_schema = ?";
		List<Map<String, String>> data = Database.query(sqlString, schemaName, conn);
		for (int i = 0; i < data.size(); i++) {
			String tableName = data.get(i).get("tableName");
			DvoGenerator dvo = new DvoGenerator(tableName, schemaName, conn);
			dvo.createDvo(destDir, packageName);
		}

	}

}
