package org.yaorma.util.dvo;

import java.io.File;
import java.sql.Connection;

import org.yaorma.codeGenerator.generateOrmForSchema.GenerateOrmForSchema;
import org.yaorma.enums.database.DatabaseType;

public class DvoFactory {

	public static void generateDvosForSchema(DatabaseType databaseType, String schemaName, String packageName, File destDir, Connection conn) {
		try {
			GenerateOrmForSchema.execute(conn, schemaName, packageName, destDir, databaseType.getCodeGenerator());	
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

}
