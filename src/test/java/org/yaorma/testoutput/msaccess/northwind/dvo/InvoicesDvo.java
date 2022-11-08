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
        "amount_SPACE_due",
        "due_SPACE_date",
        "invoice_SPACE_date",
        "invoice_SPACE_id",
        "order_SPACE_id",
        "shipping",
        "tax"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Amount_SPACE_due",
        "Due_SPACE_date",
        "Invoice_SPACE_date",
        "Invoice_SPACE_id",
        "Order_SPACE_id",
        "Shipping",
        "Tax"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String amount_SPACE_due;
    
    private String due_SPACE_date;
    
    private String invoice_SPACE_date;
    
    private Integer invoice_SPACE_id;
    
    private Integer order_SPACE_id;
    
    private String shipping;
    
    private String tax;
    
    //
    // trivial getters and setters
    //
    
    // amount_SPACE_due
    
    public void setAmount_SPACE_due(String val) {
        this.amount_SPACE_due = val;
    }
    
    public String getAmount_SPACE_due() {
        return this.amount_SPACE_due;
    }
    
    // due_SPACE_date
    
    public void setDue_SPACE_date(String val) {
        this.due_SPACE_date = val;
    }
    
    public String getDue_SPACE_date() {
        return this.due_SPACE_date;
    }
    
    // invoice_SPACE_date
    
    public void setInvoice_SPACE_date(String val) {
        this.invoice_SPACE_date = val;
    }
    
    public String getInvoice_SPACE_date() {
        return this.invoice_SPACE_date;
    }
    
    // invoice_SPACE_id
    
    public void setInvoice_SPACE_id(Integer val) {
        this.invoice_SPACE_id = val;
    }
    
    public Integer getInvoice_SPACE_id() {
        return this.invoice_SPACE_id;
    }
    
    // order_SPACE_id
    
    public void setOrder_SPACE_id(Integer val) {
        this.order_SPACE_id = val;
    }
    
    public Integer getOrder_SPACE_id() {
        return this.order_SPACE_id;
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
