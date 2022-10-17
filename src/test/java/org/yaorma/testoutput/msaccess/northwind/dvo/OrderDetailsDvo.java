//
// Data Value Object (DVO) for Order Details
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class OrderDetailsDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Order Details";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "DATE ALLOCATED",
        "DISCOUNT",
        "ID",
        "INVENTORY ID",
        "ORDER ID",
        "PRODUCT ID",
        "PURCHASE ORDER ID",
        "QUANTITY",
        "STATUS ID",
        "UNIT PRICE"
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
        "dateAllocated",
        "discount",
        "id",
        "inventoryId",
        "orderId",
        "productId",
        "purchaseOrderId",
        "quantity",
        "statusId",
        "unitPrice"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "DateAllocated",
        "Discount",
        "Id",
        "InventoryId",
        "OrderId",
        "ProductId",
        "PurchaseOrderId",
        "Quantity",
        "StatusId",
        "UnitPrice"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String dateAllocated;
    
    private String discount;
    
    private String id;
    
    private String inventoryId;
    
    private String orderId;
    
    private String productId;
    
    private String purchaseOrderId;
    
    private String quantity;
    
    private String statusId;
    
    private String unitPrice;
    
    //
    // trivial getters and setters
    //
    
    // dateAllocated
    
    public void setDateAllocated(String val) {
        this.dateAllocated = val;
    }
    
    public String getDateAllocated() {
        return this.dateAllocated;
    }
    
    // discount
    
    public void setDiscount(String val) {
        this.discount = val;
    }
    
    public String getDiscount() {
        return this.discount;
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
    
    // orderId
    
    public void setOrderId(String val) {
        this.orderId = val;
    }
    
    public String getOrderId() {
        return this.orderId;
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
    
    // statusId
    
    public void setStatusId(String val) {
        this.statusId = val;
    }
    
    public String getStatusId() {
        return this.statusId;
    }
    
    // unitPrice
    
    public void setUnitPrice(String val) {
        this.unitPrice = val;
    }
    
    public String getUnitPrice() {
        return this.unitPrice;
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
