package org.yaorma.codeGenerator.generateOrmForSchema;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import org.junit.Test;
import org.yaorma.codeGenerator.impl.msaccess.MsAccessGetTableNames;
import org.yaorma.codeGenerator.impl.msaccess.MsAccessOrmCodeGenerator;
import org.yaorma.testutil.database.MsAccessConnectionUtil;
import org.yaorma.testutil.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerateOrmForSchemaMsAccessIntegrationTest {

	private static final String SCHEMA_NAME = "northwind";

	private static final String PACKAGE_NAME = "org.yaorma.testoutput.msaccess.northwind2.dvo";
 
	private static final File DEST_DIR = FileUtil.getFromProjectRoot("/src/test/java/org/yaorma/testoutput/msaccess/northwind2/dvo");

	@Test
	public void shouldGenerateOrm() {
		log.info("Starting test...");
		File stringsDvoFile = new File(DEST_DIR, "StringsDvo.java");
		FileUtil.rmdir(DEST_DIR);
		assertTrue(DEST_DIR.exists() == false);
		assertTrue(stringsDvoFile.exists() == false);
		Connection conn = MsAccessConnectionUtil.getNorthWind();
		List<String> tableNames = MsAccessGetTableNames.exec(conn);
		GenerateOrmForSchema.execute(conn, tableNames, SCHEMA_NAME, PACKAGE_NAME, DEST_DIR, new MsAccessOrmCodeGenerator());
		assertTrue(DEST_DIR.exists() == true);
		assertTrue(stringsDvoFile.exists() == true);
		log.info("Done.");
	}

}
