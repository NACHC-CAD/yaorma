package org.yaorma.dao;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import org.yaorma.database.Database;
import org.yaorma.dvo.Dvo;
import org.yaorma.dvo.DvoUtil;
import org.yaorma.util.string.DbToJavaNamingConverter;

public class Dao {

	// ------------------------------------------------------------------------
	//
	// insert methods
	//
	// ------------------------------------------------------------------------

	public static <T extends Dvo> T insert(T dvo, String key, String val, Connection conn) {
		insert(dvo, conn);
		dvo = Database.find(dvo, key, val, conn);
		return dvo;
	}
	
	public static int insert(Dvo dvo, Connection conn) {
		try {
			String sqlString = createInsertSqlString(dvo);
			ArrayList<String> params = new ArrayList<String>();
			String[] javaNames = dvo.getJavaNames();
			for (int i = 0; i < javaNames.length; i++) {
				String javaName = javaNames[i];
				String value = DvoUtil.getValue(dvo, javaName);
				params.add(value);
			}
			return Database.update(sqlString, params, conn);
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static String createInsertSqlString(Dvo dvo) throws Exception {
		String tableName = dvo.getTableName();
		String[] columnNames = dvo.getColumnNames();
		String[] javaNames = dvo.getJavaNames();
		String sqlString = "";
		sqlString += "insert into " + tableName + " (\n";
		for (int i = 0; i < columnNames.length; i++) {
			if (i > 0) {
				sqlString += ", \n";
			}
			sqlString += "  " + columnNames[i];
		}
		sqlString += "\n";
		sqlString += ")\n";
		sqlString += "values (\n";
		for (int i = 0; i < javaNames.length; i++) {
			if (i > 0) {
				sqlString += ", \n";
			}
			sqlString += "  ?";
		}
		sqlString += "\n";
		sqlString += ")\n";
		return sqlString;
	}

	// ------------------------------------------------------------------------
	//
	// internal implementation (all private past here)
	//
	// ------------------------------------------------------------------------
	
}
