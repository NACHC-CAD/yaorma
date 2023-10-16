//
// Data Value Object (DVO) for Sales Reports
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.math.BigDecimal;

import org.yaorma.dvo.Dvo;

public class Sales_SPACE_reportsDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Sales Reports";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "DEFAULT",
        "DISPLAY",
        "FILTER ROW SOURCE",
        "GROUP BY",
        "TITLE"
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
        "default",
        "display",
        "filter_SPACE_row_SPACE_source",
        "group_SPACE_by",
        "title"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Default",
        "Display",
        "Filter_SPACE_row_SPACE_source",
        "Group_SPACE_by",
        "Title"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String defaultVal;
    
    private String display;
    
    private String filter_SPACE_row_SPACE_source;
    
    private String group_SPACE_by;
    
    private String title;
    
    //
    // trivial getters and setters
    //
    
    // default
    
    public void setDefault(String val) {
        this.defaultVal = val;
    }
    
    public String getDefault() {
        return this.defaultVal;
    }
    
    // display
    
    public void setDisplay(String val) {
        this.display = val;
    }
    
    public String getDisplay() {
        return this.display;
    }
    
    // filter_SPACE_row_SPACE_source
    
    public void setFilter_SPACE_row_SPACE_source(String val) {
        this.filter_SPACE_row_SPACE_source = val;
    }
    
    public String getFilter_SPACE_row_SPACE_source() {
        return this.filter_SPACE_row_SPACE_source;
    }
    
    // group_SPACE_by
    
    public void setGroup_SPACE_by(String val) {
        this.group_SPACE_by = val;
    }
    
    public String getGroup_SPACE_by() {
        return this.group_SPACE_by;
    }
    
    // title
    
    public void setTitle(String val) {
        this.title = val;
    }
    
    public String getTitle() {
        return this.title;
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
