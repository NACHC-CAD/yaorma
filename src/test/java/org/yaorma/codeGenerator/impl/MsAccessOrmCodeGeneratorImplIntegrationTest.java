package org.yaorma.codeGenerator.impl;

import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Test;
import org.yaorma.database.Data;
import org.yaorma.database.Database;
import org.yaorma.database.Row;
import org.yaorma.testutil.database.MsAccessConnectionUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsAccessOrmCodeGeneratorImplIntegrationTest {

	@Test
	public void testGetTablesQuery() {
		log.info("Starting test...");
		Connection conn = MsAccessConnectionUtil.getNorthWind();
		try {
			String sqlString = "";
			sqlString += "SELECT MSysObjects.Name AS table_name \n";
			sqlString += "FROM sys.MSysObjects \n";
			sqlString += "WHERE (((Left([Name],1))<>\"~\")  \n";
			sqlString += "        AND ((Left([Name],4))<>\"MSys\")  \n";
			sqlString += "        AND ((MSysObjects.Type) In (1,4,6)) \n";
			sqlString += "        AND ((MSysObjects.Flags)=0)) \n";
			sqlString += "order by MSysObjects.Name \n";
			Data data = Database.query(sqlString, conn);
			log.info("Got " + data.size() + " rows:");
			for(Row row : data) {
				log.info("\t" + row.get("name"));
			}
		} finally {
			Database.closeConnection(conn);
		}
		log.info("Done.");
	}
	
	@Test
	public void testGetColumnsQuery() {
		Connection conn = MsAccessConnectionUtil.getNorthWind();
		try {
			String sqlString = "";
			sqlString += "select column_name, data_type from information_schema.columns  \n";
			sqlString += "where lower(table_name) = \"employee privileges\" \n"; 
			sqlString += "and table_schema=\"PUBLIC\" \n";
			sqlString += "order by table_schema, table_name \n";
			ResultSet rs = Database.executeQuery(sqlString, conn);
			int cnt = rs.getMetaData().getColumnCount();
			log.info("Got " + cnt + " columns.");
			for(int i=0;i<cnt;i++) {
				log.info("\t" + rs.getMetaData().getColumnName((i+1)));
			}
			log.info("--------------------------");
			log.info("Result set: ");
			while(rs.next()) {
				String colName = rs.getString("COLUMN_NAME");
				String dataType = rs.getString("DATA_TYPE");
				log.info("\t" + colName + "\t" + dataType);
			}
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		} finally {
			Database.close(conn);
		}
	}
	
}
