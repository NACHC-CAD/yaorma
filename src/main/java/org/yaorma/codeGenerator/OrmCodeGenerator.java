package org.yaorma.codeGenerator;

import java.io.BufferedWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import org.yaorma.codeGenerator.impl.OrmCodeGeneratorImpl;
import org.yaorma.codeGenerator.impl.mysql.MySqlOrmCodeGenerator;
import org.yaorma.database.Data;
import org.yaorma.database.Database;

public class OrmCodeGenerator {

	protected BufferedWriter writer;

	protected String tableName;

	protected String schemaName;

	protected ArrayList<String[]> columnNames = new ArrayList<String[]>();

	protected ArrayList<String> primaryKeyColumnNames = new ArrayList<String>();

	protected ArrayList<HashMap<String, String>> lookUpColumns = new ArrayList<HashMap<String, String>>();

	protected ArrayList<HashMap<String, String>> childTables = new ArrayList<HashMap<String, String>>();

	protected String tab;

	private OrmCodeGeneratorImpl gen;
	
	public OrmCodeGenerator(String tableName, String schemaName, Connection conn, OrmCodeGeneratorImpl gen) throws Exception {
		this.tableName = tableName;
		this.schemaName = schemaName;
		this.gen = gen;
		this.init(conn);
	}

	private void init(Connection conn) throws Exception {
		this.columnNames = gen.initCols(conn, this.tableName, this.schemaName);
		this.primaryKeyColumnNames = gen.initPrimaryKeyCols(conn, this.tableName, this.schemaName);
		this.lookUpColumns = gen.initLookUps(conn, this.tableName, this.schemaName);
		this.childTables = gen.initChildTables(conn, this.tableName, this.schemaName);
	}

	protected void writeln(String str) throws Exception {
		this.writer.write(tab + str + "\n");
		writer.flush();
	}

	protected void incTab() {
		this.tab += "    ";
	}

	protected void decTab() {
		this.tab = this.tab.replaceFirst("    ", "");
	}

}
