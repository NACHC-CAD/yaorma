//
// Data Value Object (DVO) for Purchase Orders
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class Purchase_SPACE_ordersDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Purchase Orders";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "APPROVED BY",
        "APPROVED DATE",
        "CREATED BY",
        "CREATION DATE",
        "EXPECTED DATE",
        "NOTES",
        "PAYMENT AMOUNT",
        "PAYMENT DATE",
        "PAYMENT METHOD",
        "PURCHASE ORDER ID",
        "SHIPPING FEE",
        "STATUS ID",
        "SUBMITTED BY",
        "SUBMITTED DATE",
        "SUPPLIER ID",
        "TAXES"
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
        "approved_SPACE_by",
        "approved_SPACE_date",
        "created_SPACE_by",
        "creation_SPACE_date",
        "expected_SPACE_date",
        "notes",
        "payment_SPACE_amount",
        "payment_SPACE_date",
        "payment_SPACE_method",
        "purchase_SPACE_order_SPACE_id",
        "shipping_SPACE_fee",
        "status_SPACE_id",
        "submitted_SPACE_by",
        "submitted_SPACE_date",
        "supplier_SPACE_id",
        "taxes"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Approved_SPACE_by",
        "Approved_SPACE_date",
        "Created_SPACE_by",
        "Creation_SPACE_date",
        "Expected_SPACE_date",
        "Notes",
        "Payment_SPACE_amount",
        "Payment_SPACE_date",
        "Payment_SPACE_method",
        "Purchase_SPACE_order_SPACE_id",
        "Shipping_SPACE_fee",
        "Status_SPACE_id",
        "Submitted_SPACE_by",
        "Submitted_SPACE_date",
        "Supplier_SPACE_id",
        "Taxes"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private Integer approved_SPACE_by;
    
    private String approved_SPACE_date;
    
    private Integer created_SPACE_by;
    
    private String creation_SPACE_date;
    
    private String expected_SPACE_date;
    
    private String notes;
    
    private String payment_SPACE_amount;
    
    private String payment_SPACE_date;
    
    private String payment_SPACE_method;
    
    private Integer purchase_SPACE_order_SPACE_id;
    
    private String shipping_SPACE_fee;
    
    private Integer status_SPACE_id;
    
    private Integer submitted_SPACE_by;
    
    private String submitted_SPACE_date;
    
    private Integer supplier_SPACE_id;
    
    private String taxes;
    
    //
    // trivial getters and setters
    //
    
    // approved_SPACE_by
    
    public void setApproved_SPACE_by(Integer val) {
        this.approved_SPACE_by = val;
    }
    
    public Integer getApproved_SPACE_by() {
        return this.approved_SPACE_by;
    }
    
    // approved_SPACE_date
    
    public void setApproved_SPACE_date(String val) {
        this.approved_SPACE_date = val;
    }
    
    public String getApproved_SPACE_date() {
        return this.approved_SPACE_date;
    }
    
    // created_SPACE_by
    
    public void setCreated_SPACE_by(Integer val) {
        this.created_SPACE_by = val;
    }
    
    public Integer getCreated_SPACE_by() {
        return this.created_SPACE_by;
    }
    
    // creation_SPACE_date
    
    public void setCreation_SPACE_date(String val) {
        this.creation_SPACE_date = val;
    }
    
    public String getCreation_SPACE_date() {
        return this.creation_SPACE_date;
    }
    
    // expected_SPACE_date
    
    public void setExpected_SPACE_date(String val) {
        this.expected_SPACE_date = val;
    }
    
    public String getExpected_SPACE_date() {
        return this.expected_SPACE_date;
    }
    
    // notes
    
    public void setNotes(String val) {
        this.notes = val;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    // payment_SPACE_amount
    
    public void setPayment_SPACE_amount(String val) {
        this.payment_SPACE_amount = val;
    }
    
    public String getPayment_SPACE_amount() {
        return this.payment_SPACE_amount;
    }
    
    // payment_SPACE_date
    
    public void setPayment_SPACE_date(String val) {
        this.payment_SPACE_date = val;
    }
    
    public String getPayment_SPACE_date() {
        return this.payment_SPACE_date;
    }
    
    // payment_SPACE_method
    
    public void setPayment_SPACE_method(String val) {
        this.payment_SPACE_method = val;
    }
    
    public String getPayment_SPACE_method() {
        return this.payment_SPACE_method;
    }
    
    // purchase_SPACE_order_SPACE_id
    
    public void setPurchase_SPACE_order_SPACE_id(Integer val) {
        this.purchase_SPACE_order_SPACE_id = val;
    }
    
    public Integer getPurchase_SPACE_order_SPACE_id() {
        return this.purchase_SPACE_order_SPACE_id;
    }
    
    // shipping_SPACE_fee
    
    public void setShipping_SPACE_fee(String val) {
        this.shipping_SPACE_fee = val;
    }
    
    public String getShipping_SPACE_fee() {
        return this.shipping_SPACE_fee;
    }
    
    // status_SPACE_id
    
    public void setStatus_SPACE_id(Integer val) {
        this.status_SPACE_id = val;
    }
    
    public Integer getStatus_SPACE_id() {
        return this.status_SPACE_id;
    }
    
    // submitted_SPACE_by
    
    public void setSubmitted_SPACE_by(Integer val) {
        this.submitted_SPACE_by = val;
    }
    
    public Integer getSubmitted_SPACE_by() {
        return this.submitted_SPACE_by;
    }
    
    // submitted_SPACE_date
    
    public void setSubmitted_SPACE_date(String val) {
        this.submitted_SPACE_date = val;
    }
    
    public String getSubmitted_SPACE_date() {
        return this.submitted_SPACE_date;
    }
    
    // supplier_SPACE_id
    
    public void setSupplier_SPACE_id(Integer val) {
        this.supplier_SPACE_id = val;
    }
    
    public Integer getSupplier_SPACE_id() {
        return this.supplier_SPACE_id;
    }
    
    // taxes
    
    public void setTaxes(String val) {
        this.taxes = val;
    }
    
    public String getTaxes() {
        return this.taxes;
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
