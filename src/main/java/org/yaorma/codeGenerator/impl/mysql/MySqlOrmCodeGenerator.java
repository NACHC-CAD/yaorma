package org.yaorma.codeGenerator.impl.mysql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.yaorma.codeGenerator.impl.OrmCodeGeneratorImpl;
import org.yaorma.database.Data;
import org.yaorma.database.Database;

public class MySqlOrmCodeGenerator implements OrmCodeGeneratorImpl {

	public ArrayList<String[]> initCols(Connection conn, String tableName, String schemaName) throws Exception {
		ArrayList<String[]> columnNames = new ArrayList<String[]>();
		String sqlString = "";
		sqlString += "select column_name, data_type from information_schema.columns where table_name = ? and table_schema = ?";
		String[] params = { tableName, schemaName };
		Data data = Database.query(sqlString, params, conn);
		for (int i = 0; i < data.size(); i++) {
			String columnName = data.get(i).get("columnName");
			String dataType = data.get(i).get("dataType");
			columnNames.add(new String[] { columnName, dataType });
		}
		return columnNames;
	}

	public ArrayList<String> initPrimaryKeyCols(Connection conn, String tableName, String schemaName) throws Exception {
		ArrayList<String> primaryKeyColumnNames = new ArrayList<String>();
		String sqlString = "";
		sqlString += "select column_name \n";
		sqlString += "from information_schema.columns \n";
		sqlString += "where column_key = 'PRI' \n";
		sqlString += "and table_name = ? \n";
		sqlString += "and table_schema = ? \n";
		String[] params = { tableName, schemaName };
		Data data = Database.query(sqlString, params, conn);
		for (int i = 0; i < data.size(); i++) {
			primaryKeyColumnNames.add(data.get(i).get("columnName"));
		}
		return primaryKeyColumnNames;
	}

	public ArrayList<HashMap<String, String>> initLookUps(Connection conn, String tableName, String schemaName) throws Exception {
		ArrayList<HashMap<String, String>> lookUpColumns = new ArrayList<HashMap<String,String>>();
		String sqlString = "";
		sqlString += "select column_name, referenced_table_name \n";
		sqlString += "from information_schema.key_column_usage \n";
		sqlString += "where table_name = ? and table_schema = ? and referenced_table_name is not null";
		String[] params = { tableName, schemaName };
		Data data = Database.query(sqlString, params, conn);
		for (int i = 0; i < data.size(); i++) {
			HashMap<String, String> row = new HashMap<String, String>();
			row.put("tableName", (data.get(i).get("referencedTableName")));
			row.put("columnName", (data.get(i).get("columnName")));
			lookUpColumns.add(row);
		}
		return lookUpColumns;
	}

	public ArrayList<HashMap<String, String>> initChildTables(Connection conn, String tableName, String schemaName) throws Exception {
		ArrayList<HashMap<String, String>> childTables = new ArrayList<HashMap<String,String>>();
		String sqlString = "";
		sqlString += "select table_name, column_name from information_schema.key_column_usage \n";
		sqlString += "where referenced_table_name = ? and referenced_table_schema = ?";
		String[] params = { tableName, schemaName };
		Data data = Database.query(sqlString, params, conn);
		for (int i = 0; i < data.size(); i++) {
			HashMap<String, String> row = new HashMap<String, String>();
			row.put("tableName", data.get(i).get("tableName"));
			row.put("columnName", data.get(i).get("columnName"));
			childTables.add(row);
		}
		return childTables;
	}

	@Override
	public List<String> getTableNames(Connection conn) {
		// TODO: NEED TO IMPLEMENT THIS
		return null;
	}

}
