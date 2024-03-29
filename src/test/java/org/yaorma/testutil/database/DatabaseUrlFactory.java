package org.yaorma.testutil.database;

import java.io.File;

public class DatabaseUrlFactory {

	public static String getJdbcConnectionString(File file) {
		try {
			String url = "";
			String fileName = file.getCanonicalPath();
			fileName = fileName.replace("\\", "//");
			url = "jdbc:ucanaccess://" + fileName;
			url = url + ";sysSchema=true";
			return url;
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}
	
}
