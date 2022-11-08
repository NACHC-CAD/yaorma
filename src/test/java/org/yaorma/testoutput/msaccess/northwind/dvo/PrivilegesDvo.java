//
// Data Value Object (DVO) for Privileges
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class PrivilegesDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Privileges";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "PRIVILEGE ID",
        "PRIVILEGE NAME"
    };
    
    //
    // primaryKeyColumnNames
    //
    
    public static final String[] PRIMARY_KEY_COLUMN_NAMES = {
    };
    
    //
    // javaNames
    //
    
    public static final String[] JAVA_NAMES = {
        "privilege_SPACE_id",
        "privilege_SPACE_name"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Privilege_SPACE_id",
        "Privilege_SPACE_name"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private Integer privilege_SPACE_id;
    
    private String privilege_SPACE_name;
    
    //
    // trivial getters and setters
    //
    
    // privilege_SPACE_id
    
    public void setPrivilege_SPACE_id(Integer val) {
        this.privilege_SPACE_id = val;
    }
    
    public Integer getPrivilege_SPACE_id() {
        return this.privilege_SPACE_id;
    }
    
    // privilege_SPACE_name
    
    public void setPrivilege_SPACE_name(String val) {
        this.privilege_SPACE_name = val;
    }
    
    public String getPrivilege_SPACE_name() {
        return this.privilege_SPACE_name;
    }
    
    //
    // implementation of Dvo
    //
    
    public String getTableName() {
        return TABLE_NAME;
    };
    
    public String getSchemaName() {
        return SCHEMA_NAME;
    };
    
    public String[] getColumnNames() {
        return COLUMN_NAMES;
    };
    
    public String[] getPrimaryKeyColumnNames() {
        return PRIMARY_KEY_COLUMN_NAMES;
    };
    
    public String[] getJavaNames() {
        return JAVA_NAMES;
    };
    
    public String[] getJavaNamesProper() {
        return JAVA_NAMES_PROPER;
    };
    
    public void setDescriptions(HashMap<String, String> descriptions) {
        this.descriptions = descriptions;
    }
    
    public HashMap<String, String> getDescriptions() {
        return this.descriptions;
    }
    
    public void addDescription(String javaName, String value) {
        this.descriptions.put(javaName, value);
    }
    
    public String getDescription(String javaName) {
        return this.descriptions.get(javaName);
    }
    
    public String[] getPrimaryKeyValues() {
        String[] rtn = new String[] {
        };
        return rtn;
    }
}
