package org.yaorma.codeGenerator.dvo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.util.HashMap;

import org.yaorma.codeGenerator.OrmCodeGenerator;
import org.yaorma.util.string.DbToJavaNamingConverter;

public class DvoGenerator extends OrmCodeGenerator {

	public DvoGenerator(String tableName, String schemaName, Connection conn)
			throws Exception {
		super(tableName, schemaName, conn);
	}

	public void createDvo(File destDir, String packageName) throws Exception {

		this.tab = "";
		String name = DbToJavaNamingConverter.toJavaName(this.tableName);
		String propName = DbToJavaNamingConverter.toJavaProperName(this.tableName);
		String className = propName + "Dvo";
		String fileName = className + ".java";
		File file = new File(destDir, fileName);

		System.out.println(file.getCanonicalPath());
		this.writer = new BufferedWriter(new FileWriter(file));
		writeln("//");
		writeln("// Data Value Object (DVO) for " + tableName);
		writeln("//");
		writeln("");
		writeln("package " + packageName + ";");
		// imports
		writeln("");
		writeln("import java.util.ArrayList;");
		writeln("import java.util.HashMap;");
		writeln("");
		writeln("import org.yaorma.dvo.Dvo;");
		writeln("");
		writeln("public class " + className + " implements Dvo {");
		writeln("");
		incTab();

		// table names
		writeln("//");
		writeln("// tableName");
		writeln("//");
		writeln("");
		writeln("public static final String TABLE_NAME = \"" + this.tableName
				+ "\";");
		writeln("");

		// column names
		writeln("//");
		writeln("// columnNames");
		writeln("//");
		writeln("");
		writeln("public static final String[] COLUMN_NAMES = {");
		incTab();
		for (int i = 0; i < this.columnNames.size(); i++) {
			String str = columnNames.get(i);
			str = "\"" + str + "\"";
			if (i < this.columnNames.size() - 1) {
				str += ",";
			}
			writeln(str);
		}
		decTab();
		writeln("};");
		writeln("");

		// primary key columnNames
		writeln("//");
		writeln("// primaryKeyColumnNames");
		writeln("//");
		writeln("");
		writeln("public static final String[] PRIMARY_KEY_COLUMN_NAMES = {");
		incTab();
		for (int i = 0; i < this.primaryKeyColumnNames.size(); i++) {
			String str = primaryKeyColumnNames.get(i);
			str = "\"" + str + "\"";
			if (i < this.primaryKeyColumnNames.size() - 1) {
				str += ",";
			}
			writeln(str);
		}
		decTab();
		writeln("};");
		writeln("");

		// java names
		writeln("//");
		writeln("// javaNames");
		writeln("//");
		writeln("");
		writeln("public static final String[] JAVA_NAMES = {");
		incTab();
		for (int i = 0; i < this.columnNames.size(); i++) {
			String str = columnNames.get(i);
			str = DbToJavaNamingConverter.toJavaName(str);
			str = "\"" + str + "\"";
			if (i < this.columnNames.size() - 1) {
				str += ",";
			}
			writeln(str);
		}
		decTab();
		writeln("};");
		writeln("");

		// java names proper
		writeln("//");
		writeln("// javaNamesProper");
		writeln("//");
		writeln("");
		writeln("public static final String[] JAVA_NAMES_PROPER = {");
		incTab();
		for (int i = 0; i < this.columnNames.size(); i++) {
			String str = columnNames.get(i);
			str = DbToJavaNamingConverter.toJavaProperName(str);
			str = "\"" + str + "\"";
			if (i < this.columnNames.size() - 1) {
				str += ",";
			}
			writeln(str);
		}
		decTab();
		writeln("};");
		writeln("");

		// member variables
		writeln("");
		writeln("//");
		writeln("// member variables");
		writeln("//");
		writeln("");
		
		writeln("private HashMap<String, String> descriptions = new HashMap<String, String>();");
		writeln("");
		
		for (int i = 0; i < columnNames.size(); i++) {
			String columnName = columnNames.get(i);
			String javaName = DbToJavaNamingConverter.toJavaName(columnName);
			writeln("private String " + javaName + ";");
			writeln("");
		}

		// lookup table member variables
		for (int i = 0; i < this.lookUpColumns.size(); i++) {
			String tableName = lookUpColumns.get(i).get("tableName");
			String columnName = lookUpColumns.get(i).get("columnName");
			String dvoName = DbToJavaNamingConverter.toJavaProperName(tableName) + "Dvo";
			columnName = DbToJavaNamingConverter.removeTrailing(columnName, "_id");
			columnName = DbToJavaNamingConverter.removeTrailing(columnName, "_code");
			String varName = DbToJavaNamingConverter.toJavaName(columnName) + "Dvo";
			writeln("private " + dvoName + " " + varName + ";");
			writeln("");
		}

		// list member variables
		for (int i = 0; i < this.childTables.size(); i++) {
			String tableName = childTables.get(i).get("tableName");
			String columnName = childTables.get(i).get("columnName");
			String dvoName = DbToJavaNamingConverter.toJavaProperName(tableName) + "Dvo";
			String varName = columnName;
			varName = varName.toLowerCase();
			varName = DbToJavaNamingConverter.removeTrailing(varName, "_id");
			varName = DbToJavaNamingConverter.removeTrailing(varName, "_code");
			varName = DbToJavaNamingConverter.toJavaProperName(varName) + "List";
			varName = DbToJavaNamingConverter.toJavaName(tableName) + varName;
			writeln("private ArrayList<" + dvoName + "> " + varName
					+ " = new ArrayList<" + dvoName + ">();");
			writeln("");
		}

		// trivial getters and setters for member variables
		writeln("//");
		writeln("// trivial getters and setters");
		writeln("//");
		writeln("");
		for (int i = 0; i < columnNames.size(); i++) {
			String columnName = columnNames.get(i);
			String javaName = DbToJavaNamingConverter.toJavaName(columnName);
			String javaNameProper = DbToJavaNamingConverter.toJavaProperName(columnName);
			writeln("// " + javaName);
			writeln("");
			writeln("public void set" + javaNameProper + "(String str) {");
			incTab();
			writeln("this." + javaName + " = str;");
			decTab();
			writeln("}");
			writeln("");
			writeln("public String get" + javaNameProper + "() {");
			incTab();
			writeln("return this." + javaName + ";");
			decTab();
			writeln("}");
			writeln("");
		}

		// lookup table getters and setters
		for (int i = 0; i < this.lookUpColumns.size(); i++) {
			String tableName = lookUpColumns.get(i).get("tableName");
			String columnName = lookUpColumns.get(i).get("columnName");
			columnName = DbToJavaNamingConverter.removeTrailing(columnName, "_id");
			columnName = DbToJavaNamingConverter.removeTrailing(columnName, "_code");
			String dvoName = DbToJavaNamingConverter.toJavaProperName(tableName) + "Dvo";
			String varName = DbToJavaNamingConverter.toJavaName(columnName) + "Dvo";
			String varNameProper = DbToJavaNamingConverter.toJavaProperName(columnName);
			varNameProper += "Dvo";
			writeln("// " + varName);
			writeln("");
			writeln("public void set" + varNameProper + "(" + dvoName
					+ " dvo) {");
			incTab();
			writeln("this." + varName + " = dvo;");
			decTab();
			writeln("}");
			writeln("");
			writeln("public " + dvoName + " get" + varNameProper + "() {");
			incTab();
			writeln("return this." + varName + ";");
			decTab();
			writeln("}");
			writeln("");
		}

		// list getters and setters
		for (int i = 0; i < this.childTables.size(); i++) {
			String tableName = childTables.get(i).get("tableName");
			String columnName = childTables.get(i).get("columnName");
			String dvoName = DbToJavaNamingConverter.toJavaProperName(tableName) + "Dvo";
			String varName = columnName;
			varName = varName.toLowerCase();
			varName = DbToJavaNamingConverter.removeTrailing(varName, "_id");
			varName = DbToJavaNamingConverter.removeTrailing(varName, "_code");
			varName = DbToJavaNamingConverter.toJavaProperName(varName) + "List";
			String methodSuffix = DbToJavaNamingConverter.toJavaProperName(tableName)
					+ varName;
			writeln("public ArrayList<" + dvoName + "> get" + methodSuffix
					+ "() {");
			incTab();
			varName = DbToJavaNamingConverter.toJavaName(tableName) + varName;
			writeln("return " + varName + ";");
			decTab();
			writeln("}");
			writeln("");
			writeln("public void set" + methodSuffix + "(ArrayList<" + dvoName
					+ "> list) {");
			incTab();
			writeln("this." + varName + " = list;");
			decTab();
			writeln("}");
			writeln("");
		}

		// implementation of Dvo
		writeln("//");
		writeln("// implementation of Dvo");
		writeln("//");
		writeln("");
		writeln("public String getTableName() {");
		incTab();
		writeln("return TABLE_NAME;");
		decTab();
		writeln("};");
		writeln("");
		writeln("public String[] getColumnNames() {");
		incTab();
		writeln("return COLUMN_NAMES;");
		decTab();
		writeln("};");
		writeln("");
		writeln("public String[] getPrimaryKeyColumnNames() {");
		incTab();
		writeln("return PRIMARY_KEY_COLUMN_NAMES;");
		decTab();
		writeln("};");
		writeln("");
		writeln("public String[] getJavaNames() {");
		incTab();
		writeln("return JAVA_NAMES;");
		decTab();
		writeln("};");
		writeln("");
		writeln("public String[] getJavaNamesProper() {");
		incTab();
		writeln("return JAVA_NAMES_PROPER;");
		decTab();
		writeln("};");
		writeln("");

		//
		// description methods
		//
		
		writeln("public void setDescriptions(HashMap<String, String> descriptions) {");
		incTab();
		writeln("this.descriptions = descriptions;");
		decTab();
		writeln("}");
		writeln("");
		
		writeln("public HashMap<String, String> getDescriptions() {");
		incTab();
		writeln("return this.descriptions;");
		decTab();
		writeln("}");
		writeln("");
		
		writeln("public void addDescription(String javaName, String value) {");
		incTab();
		writeln("this.descriptions.put(javaName, value);");
		decTab();
		writeln("}");
		writeln("");

		writeln("public String getDescription(String javaName) {");
		incTab();
		writeln("return this.descriptions.get(javaName);");
		decTab();
		writeln("}");
		writeln("");
		
		decTab();
		writeln("}");
	}
}
