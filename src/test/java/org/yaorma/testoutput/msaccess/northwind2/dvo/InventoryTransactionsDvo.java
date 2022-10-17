//
// Data Value Object (DVO) for Inventory Transactions
//

package org.yaorma.testoutput.msaccess.northwind2.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class InventoryTransactionsDvo implements Dvo {

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
        "customerOrderId",
        "productId",
        "purchaseOrderId",
        "quantity",
        "transactionCreatedDate",
        "transactionId",
        "transactionModifiedDate",
        "transactionType"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Comments",
        "CustomerOrderId",
        "ProductId",
        "PurchaseOrderId",
        "Quantity",
        "TransactionCreatedDate",
        "TransactionId",
        "TransactionModifiedDate",
        "TransactionType"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String comments;
    
    private String customerOrderId;
    
    private String productId;
    
    private String purchaseOrderId;
    
    private String quantity;
    
    private String transactionCreatedDate;
    
    private String transactionId;
    
    private String transactionModifiedDate;
    
    private String transactionType;
    
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
    
    // customerOrderId
    
    public void setCustomerOrderId(String val) {
        this.customerOrderId = val;
    }
    
    public String getCustomerOrderId() {
        return this.customerOrderId;
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
    
    // transactionCreatedDate
    
    public void setTransactionCreatedDate(String val) {
        this.transactionCreatedDate = val;
    }
    
    public String getTransactionCreatedDate() {
        return this.transactionCreatedDate;
    }
    
    // transactionId
    
    public void setTransactionId(String val) {
        this.transactionId = val;
    }
    
    public String getTransactionId() {
        return this.transactionId;
    }
    
    // transactionModifiedDate
    
    public void setTransactionModifiedDate(String val) {
        this.transactionModifiedDate = val;
    }
    
    public String getTransactionModifiedDate() {
        return this.transactionModifiedDate;
    }
    
    // transactionType
    
    public void setTransactionType(String val) {
        this.transactionType = val;
    }
    
    public String getTransactionType() {
        return this.transactionType;
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
