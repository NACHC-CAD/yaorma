//
// Data Value Object (DVO) for Purchase Orders
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class PurchaseOrdersDvo implements Dvo {

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
        "approvedBy",
        "approvedDate",
        "createdBy",
        "creationDate",
        "expectedDate",
        "notes",
        "paymentAmount",
        "paymentDate",
        "paymentMethod",
        "purchaseOrderId",
        "shippingFee",
        "statusId",
        "submittedBy",
        "submittedDate",
        "supplierId",
        "taxes"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "ApprovedBy",
        "ApprovedDate",
        "CreatedBy",
        "CreationDate",
        "ExpectedDate",
        "Notes",
        "PaymentAmount",
        "PaymentDate",
        "PaymentMethod",
        "PurchaseOrderId",
        "ShippingFee",
        "StatusId",
        "SubmittedBy",
        "SubmittedDate",
        "SupplierId",
        "Taxes"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String approvedBy;
    
    private String approvedDate;
    
    private String createdBy;
    
    private String creationDate;
    
    private String expectedDate;
    
    private String notes;
    
    private String paymentAmount;
    
    private String paymentDate;
    
    private String paymentMethod;
    
    private String purchaseOrderId;
    
    private String shippingFee;
    
    private String statusId;
    
    private String submittedBy;
    
    private String submittedDate;
    
    private String supplierId;
    
    private String taxes;
    
    //
    // trivial getters and setters
    //
    
    // approvedBy
    
    public void setApprovedBy(String val) {
        this.approvedBy = val;
    }
    
    public String getApprovedBy() {
        return this.approvedBy;
    }
    
    // approvedDate
    
    public void setApprovedDate(String val) {
        this.approvedDate = val;
    }
    
    public String getApprovedDate() {
        return this.approvedDate;
    }
    
    // createdBy
    
    public void setCreatedBy(String val) {
        this.createdBy = val;
    }
    
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    // creationDate
    
    public void setCreationDate(String val) {
        this.creationDate = val;
    }
    
    public String getCreationDate() {
        return this.creationDate;
    }
    
    // expectedDate
    
    public void setExpectedDate(String val) {
        this.expectedDate = val;
    }
    
    public String getExpectedDate() {
        return this.expectedDate;
    }
    
    // notes
    
    public void setNotes(String val) {
        this.notes = val;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    // paymentAmount
    
    public void setPaymentAmount(String val) {
        this.paymentAmount = val;
    }
    
    public String getPaymentAmount() {
        return this.paymentAmount;
    }
    
    // paymentDate
    
    public void setPaymentDate(String val) {
        this.paymentDate = val;
    }
    
    public String getPaymentDate() {
        return this.paymentDate;
    }
    
    // paymentMethod
    
    public void setPaymentMethod(String val) {
        this.paymentMethod = val;
    }
    
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    
    // purchaseOrderId
    
    public void setPurchaseOrderId(String val) {
        this.purchaseOrderId = val;
    }
    
    public String getPurchaseOrderId() {
        return this.purchaseOrderId;
    }
    
    // shippingFee
    
    public void setShippingFee(String val) {
        this.shippingFee = val;
    }
    
    public String getShippingFee() {
        return this.shippingFee;
    }
    
    // statusId
    
    public void setStatusId(String val) {
        this.statusId = val;
    }
    
    public String getStatusId() {
        return this.statusId;
    }
    
    // submittedBy
    
    public void setSubmittedBy(String val) {
        this.submittedBy = val;
    }
    
    public String getSubmittedBy() {
        return this.submittedBy;
    }
    
    // submittedDate
    
    public void setSubmittedDate(String val) {
        this.submittedDate = val;
    }
    
    public String getSubmittedDate() {
        return this.submittedDate;
    }
    
    // supplierId
    
    public void setSupplierId(String val) {
        this.supplierId = val;
    }
    
    public String getSupplierId() {
        return this.supplierId;
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
