package org.yaorma.database;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;
import org.yaorma.testutil.database.MsAccessConnectionUtil;
import org.yaorma.testutil.database.MsAccessDatabaseUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatabaseIntegrationTest {

	@Test
	public void shouldGetDbConnection() {
		Connection conn = MsAccessConnectionUtil.getNorthWind();
		try {
			List<String> tableNames = MsAccessDatabaseUtil.getTableNames(conn);
			log.info("Got " + tableNames.size() + " tables");
			for(String tableName : tableNames) {
				log.info("\t" + tableName);
			}
		} finally {
			if (conn != null) {
				Database.close(conn);
			}
		}
		log.info("Done.");
	}

}
