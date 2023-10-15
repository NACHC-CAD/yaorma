//
// Data Value Object (DVO) for Employee Privileges
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class Employee_SPACE_privilegesDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Employee Privileges";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "EMPLOYEE ID",
        "PRIVILEGE ID"
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
        "employee_SPACE_id",
        "privilege_SPACE_id"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Employee_SPACE_id",
        "Privilege_SPACE_id"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private Integer employee_SPACE_id;
    
    private Integer privilege_SPACE_id;
    
    //
    // trivial getters and setters
    //
    
    // employee_SPACE_id
    
    public void setEmployee_SPACE_id(Integer val) {
        this.employee_SPACE_id = val;
    }
    
    public Integer getEmployee_SPACE_id() {
        return this.employee_SPACE_id;
    }
    
    // privilege_SPACE_id
    
    public void setPrivilege_SPACE_id(Integer val) {
        this.privilege_SPACE_id = val;
    }
    
    public Integer getPrivilege_SPACE_id() {
        return this.privilege_SPACE_id;
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
