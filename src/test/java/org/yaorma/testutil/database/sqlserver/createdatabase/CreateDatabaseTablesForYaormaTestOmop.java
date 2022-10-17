package org.yaorma.testutil.database.sqlserver.createdatabase;

import java.io.InputStream;
import java.sql.Connection;

import org.junit.Test;
import org.yaorma.database.Database;
import org.yaorma.testutil.database.sqlserver.conn.SqlServerConnectionFactory;
import org.yaorma.testutil.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateDatabaseTablesForYaormaTestOmop {

	private static final InputStream IS = FileUtil.getInputStream("/database/sqlserver/omop/OMOPCDM_sql_server_5.4_ddl.sql");
	
	@Test
	public void createDatabase() {
		exec();
	}
	
	public static void exec() {
		Connection conn = SqlServerConnectionFactory.getBootstrapConnection();
		try {
			log.info("Starting create database...");
			String dbName = "yaorma_omop_test";
			log.info("Database name: " + dbName);
			createDatabase(dbName, conn);
			createTables(dbName, conn);
		} finally {
			log.info("Closing connections...");
			Database.close(conn);
		}
		log.info("Done.");
	}
	
	private static void createDatabase(String databaseName, Connection conn) {
		log.info("Creating database: " + databaseName);
		Database.update("drop database if exists " + databaseName, conn);
		Database.update("create database " + databaseName, conn);
	}

	private static void createTables(String dbName, Connection conn) {
		log.info("Using: " + dbName);
		Database.update("use " + dbName, conn);
		log.info("Running script...");
		Database.executeSqlScript(IS, conn);
		log.info("Done running script.");
		log.info("Done creating database tables.");
	}
	
}
