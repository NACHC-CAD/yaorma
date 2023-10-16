//
// Data Value Object (DVO) for Inventory Transactions
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.math.BigDecimal;

import org.yaorma.dvo.Dvo;

public class Inventory_SPACE_transactionsDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Inventory Transactions";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "COMMENTS",
        "CUSTOMER ORDER ID",
        "PRODUCT ID",
        "PURCHASE ORDER ID",
        "QUANTITY",
        "TRANSACTION CREATED DATE",
        "TRANSACTION ID",
        "TRANSACTION MODIFIED DATE",
        "TRANSACTION TYPE"
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
        "comments",
        "customer_SPACE_order_SPACE_id",
        "product_SPACE_id",
        "purchase_SPACE_order_SPACE_id",
        "quantity",
        "transaction_SPACE_created_SPACE_date",
        "transaction_SPACE_id",
        "transaction_SPACE_modified_SPACE_date",
        "transaction_SPACE_type"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Comments",
        "Customer_SPACE_order_SPACE_id",
        "Product_SPACE_id",
        "Purchase_SPACE_order_SPACE_id",
        "Quantity",
        "Transaction_SPACE_created_SPACE_date",
        "Transaction_SPACE_id",
        "Transaction_SPACE_modified_SPACE_date",
        "Transaction_SPACE_type"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String comments;
    
    private Integer customer_SPACE_order_SPACE_id;
    
    private Integer product_SPACE_id;
    
    private Integer purchase_SPACE_order_SPACE_id;
    
    private Integer quantity;
    
    private String transaction_SPACE_created_SPACE_date;
    
    private Integer transaction_SPACE_id;
    
    private String transaction_SPACE_modified_SPACE_date;
    
    private String transaction_SPACE_type;
    
    //
    // trivial getters and setters
    //
    
    // comments
    
    public void setComments(String val) {
        this.comments = val;
    }
    
    public String getComments() {
        return this.comments;
    }
    
    // customer_SPACE_order_SPACE_id
    
    public void setCustomer_SPACE_order_SPACE_id(Integer val) {
        this.customer_SPACE_order_SPACE_id = val;
    }
    
    public Integer getCustomer_SPACE_order_SPACE_id() {
        return this.customer_SPACE_order_SPACE_id;
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
    
    public void setQuantity(Integer val) {
        this.quantity = val;
    }
    
    public Integer getQuantity() {
        return this.quantity;
    }
    
    // transaction_SPACE_created_SPACE_date
    
    public void setTransaction_SPACE_created_SPACE_date(String val) {
        this.transaction_SPACE_created_SPACE_date = val;
    }
    
    public String getTransaction_SPACE_created_SPACE_date() {
        return this.transaction_SPACE_created_SPACE_date;
    }
    
    // transaction_SPACE_id
    
    public void setTransaction_SPACE_id(Integer val) {
        this.transaction_SPACE_id = val;
    }
    
    public Integer getTransaction_SPACE_id() {
        return this.transaction_SPACE_id;
    }
    
    // transaction_SPACE_modified_SPACE_date
    
    public void setTransaction_SPACE_modified_SPACE_date(String val) {
        this.transaction_SPACE_modified_SPACE_date = val;
    }
    
    public String getTransaction_SPACE_modified_SPACE_date() {
        return this.transaction_SPACE_modified_SPACE_date;
    }
    
    // transaction_SPACE_type
    
    public void setTransaction_SPACE_type(String val) {
        this.transaction_SPACE_type = val;
    }
    
    public String getTransaction_SPACE_type() {
        return this.transaction_SPACE_type;
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
