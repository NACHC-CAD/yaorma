//
// Data Value Object (DVO) for Sales Reports
//

package org.yaorma.testoutput.msaccess.northwind2.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class SalesReportsDvo implements Dvo {

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
        "filterRowSource",
        "groupBy",
        "title"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Default",
        "Display",
        "FilterRowSource",
        "GroupBy",
        "Title"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String defaultVal;
    
    private String display;
    
    private String filterRowSource;
    
    private String groupBy;
    
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
    
    // filterRowSource
    
    public void setFilterRowSource(String val) {
        this.filterRowSource = val;
    }
    
    public String getFilterRowSource() {
        return this.filterRowSource;
    }
    
    // groupBy
    
    public void setGroupBy(String val) {
        this.groupBy = val;
    }
    
    public String getGroupBy() {
        return this.groupBy;
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
