package org.yaorma.codeGenerator;

import java.io.BufferedWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.yaorma.database.Database;

public class OrmCodeGenerator {

	protected BufferedWriter writer;

	protected String tableName;

	protected String schemaName;

	protected ArrayList<String> columnNames = new ArrayList<String>();

	protected ArrayList<String> primaryKeyColumnNames = new ArrayList<String>();

	protected ArrayList<HashMap<String, String>> lookUpColumns = new ArrayList<HashMap<String, String>>();

	protected ArrayList<HashMap<String, String>> childTables = new ArrayList<HashMap<String, String>>();

	protected String tab;

	public OrmCodeGenerator(String tableName, String schemaName, Connection conn)
			throws Exception {
		this.tableName = tableName;
		this.schemaName = schemaName;
		this.init(conn);
	}

	private void init(Connection conn) throws Exception {
		initCols(conn);
		initPrimaryKeyCols(conn);
		initLookUps(conn);
		initChildTables(conn);
	}

	private void initCols(Connection conn) throws Exception {
		String sqlString = "select column_name from information_schema.columns where table_name = ? ";
		sqlString += "and table_schema = ?";
		String[] params = { this.tableName, this.schemaName };
		List<Map<String, String>> data = Database.query(sqlString, params, conn);
		for (int i = 0; i < data.size(); i++) {
			this.columnNames.add(data.get(i).get("columnName"));
		}
	}

	private void initPrimaryKeyCols(Connection conn) throws Exception {
		String sqlString = "";
		sqlString += "select column_name \n";
		sqlString += "from information_schema.columns \n";
		sqlString += "where column_key = 'PRI' \n";
		sqlString += "and table_name = ? \n";
		sqlString += "and table_schema = ? \n";
		String[] params = { this.tableName, this.schemaName };
		List<Map<String, String>> data = Database.query(sqlString, params, conn);
		for (int i = 0; i < data.size(); i++) {
			this.primaryKeyColumnNames.add(data.get(i).get("columnName"));
		}
	}

	private void initLookUps(Connection conn) throws Exception {
		String sqlString = "";
		sqlString += "select column_name, referenced_table_name \n";
		sqlString += "from information_schema.key_column_usage \n";
		sqlString += "where table_name = ? and table_schema = ? and referenced_table_name is not null";
		String[] params = { this.tableName, this.schemaName };
		List<Map <String, String>> data = Database.query(sqlString, params, conn);
		for (int i = 0; i < data.size(); i++) {
			HashMap<String, String> row = new HashMap<String, String>();
			row.put("tableName", (data.get(i).get("referencedTableName")));
			row.put("columnName", (data.get(i).get("columnName")));
			this.lookUpColumns.add(row);
		}
	}

	private void initChildTables(Connection conn) throws Exception {
		String sqlString = "";
		sqlString += "select table_name, column_name from information_schema.key_column_usage \n";
		sqlString += "where referenced_table_name = ? and referenced_table_schema = ?";
		String[] params = { this.tableName, this.schemaName };
		List<Map <String, String>>  data = Database.query(sqlString, params, conn);
		for (int i = 0; i < data.size(); i++) {
			HashMap<String, String> row = new HashMap<String, String>();
			row.put("tableName", data.get(i).get("tableName"));
			row.put("columnName", data.get(i).get("columnName"));
			this.childTables.add(row);
		}
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
