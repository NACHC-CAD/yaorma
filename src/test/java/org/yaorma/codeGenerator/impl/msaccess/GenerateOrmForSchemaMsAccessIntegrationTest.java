package org.yaorma.codeGenerator.impl.msaccess;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.Connection;

import org.junit.Test;
import org.yaorma.codeGenerator.generateOrmForSchema.GenerateOrmForSchema;
import org.yaorma.database.Database;
import org.yaorma.testutil.database.MsAccessConnectionUtil;
import org.yaorma.testutil.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerateOrmForSchemaMsAccessIntegrationTest {

	private static final String SCHEMA_NAME = "northwind";

	private static final String PACKAGE_NAME = "org.yaorma.testoutput.msaccess.northwind.dvo";
 
	private static final File DEST_DIR = FileUtil.getFromProjectRoot("/src/test/java/org/yaorma/testoutput/msaccess/northwind/dvo");

	@Test
	public void shouldGenerateOrm() {
		// get a connection
		Connection conn = MsAccessConnectionUtil.getNorthWind();
		try {
			log.info("Generating DVO objects...");
			// remove the existing dvo dir
			FileUtil.rmdir(DEST_DIR);
			// check that the dest dir was deleted
			assertTrue(DEST_DIR.exists() == false);
			// generate the dvo objects for the schema
			GenerateOrmForSchema.execute(conn, SCHEMA_NAME, PACKAGE_NAME, DEST_DIR, new MsAccessOrmCodeGenerator());
		} finally {
			// close the connection
			Database.close(conn);
		}
		// done
		log.info("Done.");
	}

}
