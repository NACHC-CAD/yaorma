package org.yaorma.codeGenerator.generateOrmForSchema;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import org.junit.Test;
import org.yaorma.codeGenerator.impl.MsAccessOrmCodeGenerator;
import org.yaorma.testutil.database.MsAccessConnectionUtil;
import org.yaorma.testutil.database.MsAccessDatabaseUtil;
import org.yaorma.testutil.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerateOrmForSchemaMsAccessIntegrationTest {

	private static final String SCHEMA_NAME = "northwind";

	private static final String PACKAGE_NAME = "org.yaorma.testutil.dvo.northwind";

	private static final File DEST_DIR = FileUtil.getFromProjectRoot("/src/test/java/org/yaorma/testutil/dvo/northwind");

	@Test
	public void shouldGenerateOrm() {
		Connection conn = MsAccessConnectionUtil.getNorthWind();
		List<String> tableNames = MsAccessDatabaseUtil.getTableNames(conn);
		GenerateOrmForSchema.execute(conn, tableNames, SCHEMA_NAME, PACKAGE_NAME, DEST_DIR, new MsAccessOrmCodeGenerator());
	}

}
