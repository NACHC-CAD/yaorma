//
// Data Value Object (DVO) for Invoices
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class InvoicesDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Invoices";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "AMOUNT DUE",
        "DUE DATE",
        "INVOICE DATE",
        "INVOICE ID",
        "ORDER ID",
        "SHIPPING",
        "TAX"
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
        "amountDue",
        "dueDate",
        "invoiceDate",
        "invoiceId",
        "orderId",
        "shipping",
        "tax"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "AmountDue",
        "DueDate",
        "InvoiceDate",
        "InvoiceId",
        "OrderId",
        "Shipping",
        "Tax"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String amountDue;
    
    private String dueDate;
    
    private String invoiceDate;
    
    private String invoiceId;
    
    private String orderId;
    
    private String shipping;
    
    private String tax;
    
    //
    // trivial getters and setters
    //
    
    // amountDue
    
    public void setAmountDue(String val) {
        this.amountDue = val;
    }
    
    public String getAmountDue() {
        return this.amountDue;
    }
    
    // dueDate
    
    public void setDueDate(String val) {
        this.dueDate = val;
    }
    
    public String getDueDate() {
        return this.dueDate;
    }
    
    // invoiceDate
    
    public void setInvoiceDate(String val) {
        this.invoiceDate = val;
    }
    
    public String getInvoiceDate() {
        return this.invoiceDate;
    }
    
    // invoiceId
    
    public void setInvoiceId(String val) {
        this.invoiceId = val;
    }
    
    public String getInvoiceId() {
        return this.invoiceId;
    }
    
    // orderId
    
    public void setOrderId(String val) {
        this.orderId = val;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
    
    // shipping
    
    public void setShipping(String val) {
        this.shipping = val;
    }
    
    public String getShipping() {
        return this.shipping;
    }
    
    // tax
    
    public void setTax(String val) {
        this.tax = val;
    }
    
    public String getTax() {
        return this.tax;
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
