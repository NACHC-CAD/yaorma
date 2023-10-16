//
// Data Value Object (DVO) for Order Details Status
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.math.BigDecimal;

import org.yaorma.dvo.Dvo;

public class Order_SPACE_details_SPACE_statusDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Order Details Status";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "STATUS ID",
        "STATUS NAME"
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
        "status_SPACE_id",
        "status_SPACE_name"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Status_SPACE_id",
        "Status_SPACE_name"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private Integer status_SPACE_id;
    
    private String status_SPACE_name;
    
    //
    // trivial getters and setters
    //
    
    // status_SPACE_id
    
    public void setStatus_SPACE_id(Integer val) {
        this.status_SPACE_id = val;
    }
    
    public Integer getStatus_SPACE_id() {
        return this.status_SPACE_id;
    }
    
    // status_SPACE_name
    
    public void setStatus_SPACE_name(String val) {
        this.status_SPACE_name = val;
    }
    
    public String getStatus_SPACE_name() {
        return this.status_SPACE_name;
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
