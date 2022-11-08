//
// Data Value Object (DVO) for Purchase Order Details
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class Purchase_SPACE_order_SPACE_detailsDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Purchase Order Details";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "DATE RECEIVED",
        "ID",
        "INVENTORY ID",
        "POSTED TO INVENTORY",
        "PRODUCT ID",
        "PURCHASE ORDER ID",
        "QUANTITY",
        "UNIT COST"
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
        "date_SPACE_received",
        "id",
        "inventory_SPACE_id",
        "posted_SPACE_to_SPACE_inventory",
        "product_SPACE_id",
        "purchase_SPACE_order_SPACE_id",
        "quantity",
        "unit_SPACE_cost"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Date_SPACE_received",
        "Id",
        "Inventory_SPACE_id",
        "Posted_SPACE_to_SPACE_inventory",
        "Product_SPACE_id",
        "Purchase_SPACE_order_SPACE_id",
        "Quantity",
        "Unit_SPACE_cost"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String date_SPACE_received;
    
    private Integer id;
    
    private Integer inventory_SPACE_id;
    
    private String posted_SPACE_to_SPACE_inventory;
    
    private Integer product_SPACE_id;
    
    private Integer purchase_SPACE_order_SPACE_id;
    
    private String quantity;
    
    private String unit_SPACE_cost;
    
    //
    // trivial getters and setters
    //
    
    // date_SPACE_received
    
    public void setDate_SPACE_received(String val) {
        this.date_SPACE_received = val;
    }
    
    public String getDate_SPACE_received() {
        return this.date_SPACE_received;
    }
    
    // id
    
    public void setId(Integer val) {
        this.id = val;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    // inventory_SPACE_id
    
    public void setInventory_SPACE_id(Integer val) {
        this.inventory_SPACE_id = val;
    }
    
    public Integer getInventory_SPACE_id() {
        return this.inventory_SPACE_id;
    }
    
    // posted_SPACE_to_SPACE_inventory
    
    public void setPosted_SPACE_to_SPACE_inventory(String val) {
        this.posted_SPACE_to_SPACE_inventory = val;
    }
    
    public String getPosted_SPACE_to_SPACE_inventory() {
        return this.posted_SPACE_to_SPACE_inventory;
    }
    
    // product_SPACE_id
    
    public void setProduct_SPACE_id(Integer val) {
        this.product_SPACE_id = val;
    }
    
    public Integer getProduct_SPACE_id() {
        return this.product_SPACE_id;
    }
    
    // purchase_SPACE_order_SPACE_id
    
    public void setPurchase_SPACE_order_SPACE_id(Integer val) {
        this.purchase_SPACE_order_SPACE_id = val;
    }
    
    public Integer getPurchase_SPACE_order_SPACE_id() {
        return this.purchase_SPACE_order_SPACE_id;
    }
    
    // quantity
    
    public void setQuantity(String val) {
        this.quantity = val;
    }
    
    public String getQuantity() {
        return this.quantity;
    }
    
    // unit_SPACE_cost
    
    public void setUnit_SPACE_cost(String val) {
        this.unit_SPACE_cost = val;
    }
    
    public String getUnit_SPACE_cost() {
        return this.unit_SPACE_cost;
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
