package org.yaorma.codeGenerator.impl.msaccess;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.yaorma.codeGenerator.impl.OrmCodeGeneratorImpl;
import org.yaorma.database.Data;
import org.yaorma.database.Database;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsAccessOrmCodeGenerator implements OrmCodeGeneratorImpl {

	@Override
	public ArrayList<String[]> initCols(Connection conn, String tableName, String schemaName) throws Exception {
		ArrayList<String[]> columnNames = new ArrayList<String[]>();
		if(tableName == null) {
			return columnNames;
		}
		String sqlString = "";
		sqlString += "select column_name, data_type from information_schema.columns  \n";
		sqlString += "where lower(table_name) = \"" + tableName.toLowerCase() + "\" \n";
		sqlString += "and table_schema=\"PUBLIC\" \n";
		sqlString += "order by table_name, column_name \n";
		Data data = Database.query(sqlString, conn);
		for (int i = 0; i < data.size(); i++) {
			String columnName = data.get(i).get("columnName");
			String dataType = data.get(i).get("dataType");
			columnNames.add(new String[] { columnName, dataType });
		}
		return columnNames;
	}

	@Override
	public ArrayList<String> initPrimaryKeyCols(Connection conn, String tableName, String schemaName) throws Exception {
		ArrayList<String> primaryKeyColumnNames = new ArrayList<String>();
		return primaryKeyColumnNames;
	}

	@Override
	public ArrayList<HashMap<String, String>> initLookUps(Connection conn, String tableName, String schemaName) throws Exception {
		ArrayList<HashMap<String, String>> lookUpColumns = new ArrayList<HashMap<String, String>>();
		return lookUpColumns;
	}

	@Override
	public ArrayList<HashMap<String, String>> initChildTables(Connection conn, String tableName, String schemaName) throws Exception {
		ArrayList<HashMap<String, String>> childTables = new ArrayList<HashMap<String, String>>();
		return childTables;
	}

	@Override
	public List<String> getTableNames(Connection conn) {
		return MsAccessGetTableNames.exec(conn);
	}

}
