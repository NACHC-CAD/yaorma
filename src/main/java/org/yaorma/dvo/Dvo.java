package org.yaorma.dvo;

public interface Dvo {

	public String[] getColumnNames();
	
	public String[] getPrimaryKeyColumnNames();
	
	public String[] getPrimaryKeyValues();
	
	public String[] getJavaNames();
	
	public String[] getJavaNamesProper();
	
	public String getSchemaName();
	
	public String getTableName();
	
	public void addDescription(String javaName, String description);
	
	public String getDescription(String javaName);
}
