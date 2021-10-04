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
		} finally {
			if (conn != null) {
				Database.close(conn);
			}
		}
	}

}
