//
// Data Value Object (DVO) for Strings
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class StringsDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Strings";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "STRING DATA",
        "STRING ID"
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
        "string_SPACE_data",
        "string_SPACE_id"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "String_SPACE_data",
        "String_SPACE_id"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String string_SPACE_data;
    
    private Integer string_SPACE_id;
    
    //
    // trivial getters and setters
    //
    
    // string_SPACE_data
    
    public void setString_SPACE_data(String val) {
        this.string_SPACE_data = val;
    }
    
    public String getString_SPACE_data() {
        return this.string_SPACE_data;
    }
    
    // string_SPACE_id
    
    public void setString_SPACE_id(Integer val) {
        this.string_SPACE_id = val;
    }
    
    public Integer getString_SPACE_id() {
        return this.string_SPACE_id;
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
