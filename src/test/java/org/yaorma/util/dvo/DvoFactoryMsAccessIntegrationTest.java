package org.yaorma.util.dvo;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.Connection;

import org.junit.Test;
import org.yaorma.enums.database.DatabaseType;
import org.yaorma.testutil.database.MsAccessConnectionUtil;
import org.yaorma.testutil.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DvoFactoryMsAccessIntegrationTest {


	private static final String SCHEMA_NAME = "northwind";

	private static final String PACKAGE_NAME = "org.yaorma.testoutput.msaccess.northwind.dvo";
 
	private static final File DEST_DIR = FileUtil.getFromProjectRoot("/src/test/java/org/yaorma/testoutput/msaccess/northwind/dvo");

	@Test
	public void shouldGenerateOrm() {
		log.info("Starting test...");
		File stringsDvoFile = new File(DEST_DIR, "StringsDvo.java");
		FileUtil.rmdir(DEST_DIR);
		assertTrue(DEST_DIR.exists() == false);
		assertTrue(stringsDvoFile.exists() == false);
		Connection conn = MsAccessConnectionUtil.getNorthWind();
		DvoFactory.generateDvosForSchema(DatabaseType.MS_ACCESS, SCHEMA_NAME, PACKAGE_NAME, DEST_DIR, conn);
		assertTrue(DEST_DIR.exists() == true);
		assertTrue(stringsDvoFile.exists() == true);
		log.info("Done.");
	}
}
