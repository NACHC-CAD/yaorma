//
// Data Value Object (DVO) for Purchase Order Details
//

package org.yaorma.testoutput.msaccess.northwind2.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class PurchaseOrderDetailsDvo implements Dvo {

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
        "dateReceived",
        "id",
        "inventoryId",
        "postedToInventory",
        "productId",
        "purchaseOrderId",
        "quantity",
        "unitCost"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "DateReceived",
        "Id",
        "InventoryId",
        "PostedToInventory",
        "ProductId",
        "PurchaseOrderId",
        "Quantity",
        "UnitCost"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String dateReceived;
    
    private String id;
    
    private String inventoryId;
    
    private String postedToInventory;
    
    private String productId;
    
    private String purchaseOrderId;
    
    private String quantity;
    
    private String unitCost;
    
    //
    // trivial getters and setters
    //
    
    // dateReceived
    
    public void setDateReceived(String val) {
        this.dateReceived = val;
    }
    
    public String getDateReceived() {
        return this.dateReceived;
    }
    
    // id
    
    public void setId(String val) {
        this.id = val;
    }
    
    public String getId() {
        return this.id;
    }
    
    // inventoryId
    
    public void setInventoryId(String val) {
        this.inventoryId = val;
    }
    
    public String getInventoryId() {
        return this.inventoryId;
    }
    
    // postedToInventory
    
    public void setPostedToInventory(String val) {
        this.postedToInventory = val;
    }
    
    public String getPostedToInventory() {
        return this.postedToInventory;
    }
    
    // productId
    
    public void setProductId(String val) {
        this.productId = val;
    }
    
    public String getProductId() {
        return this.productId;
    }
    
    // purchaseOrderId
    
    public void setPurchaseOrderId(String val) {
        this.purchaseOrderId = val;
    }
    
    public String getPurchaseOrderId() {
        return this.purchaseOrderId;
    }
    
    // quantity
    
    public void setQuantity(String val) {
        this.quantity = val;
    }
    
    public String getQuantity() {
        return this.quantity;
    }
    
    // unitCost
    
    public void setUnitCost(String val) {
        this.unitCost = val;
    }
    
    public String getUnitCost() {
        return this.unitCost;
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
