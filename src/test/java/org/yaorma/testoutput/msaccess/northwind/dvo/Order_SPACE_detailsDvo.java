//
// Data Value Object (DVO) for Order Details
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class Order_SPACE_detailsDvo implements Dvo {

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
        "date_SPACE_allocated",
        "discount",
        "id",
        "inventory_SPACE_id",
        "order_SPACE_id",
        "product_SPACE_id",
        "purchase_SPACE_order_SPACE_id",
        "quantity",
        "status_SPACE_id",
        "unit_SPACE_price"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Date_SPACE_allocated",
        "Discount",
        "Id",
        "Inventory_SPACE_id",
        "Order_SPACE_id",
        "Product_SPACE_id",
        "Purchase_SPACE_order_SPACE_id",
        "Quantity",
        "Status_SPACE_id",
        "Unit_SPACE_price"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String date_SPACE_allocated;
    
    private String discount;
    
    private Integer id;
    
    private Integer inventory_SPACE_id;
    
    private Integer order_SPACE_id;
    
    private Integer product_SPACE_id;
    
    private Integer purchase_SPACE_order_SPACE_id;
    
    private String quantity;
    
    private Integer status_SPACE_id;
    
    private String unit_SPACE_price;
    
    //
    // trivial getters and setters
    //
    
    // date_SPACE_allocated
    
    public void setDate_SPACE_allocated(String val) {
        this.date_SPACE_allocated = val;
    }
    
    public String getDate_SPACE_allocated() {
        return this.date_SPACE_allocated;
    }
    
    // discount
    
    public void setDiscount(String val) {
        this.discount = val;
    }
    
    public String getDiscount() {
        return this.discount;
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
    
    // order_SPACE_id
    
    public void setOrder_SPACE_id(Integer val) {
        this.order_SPACE_id = val;
    }
    
    public Integer getOrder_SPACE_id() {
        return this.order_SPACE_id;
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
    
    // status_SPACE_id
    
    public void setStatus_SPACE_id(Integer val) {
        this.status_SPACE_id = val;
    }
    
    public Integer getStatus_SPACE_id() {
        return this.status_SPACE_id;
    }
    
    // unit_SPACE_price
    
    public void setUnit_SPACE_price(String val) {
        this.unit_SPACE_price = val;
    }
    
    public String getUnit_SPACE_price() {
        return this.unit_SPACE_price;
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
