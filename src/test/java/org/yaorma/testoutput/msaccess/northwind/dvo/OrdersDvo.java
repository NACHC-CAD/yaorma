//
// Data Value Object (DVO) for Orders
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class OrdersDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Orders";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "CUSTOMER ID",
        "EMPLOYEE ID",
        "NOTES",
        "ORDER DATE",
        "ORDER ID",
        "PAID DATE",
        "PAYMENT TYPE",
        "SHIP ADDRESS",
        "SHIP CITY",
        "SHIP COUNTRY/REGION",
        "SHIP NAME",
        "SHIP STATE/PROVINCE",
        "SHIP ZIP/POSTAL CODE",
        "SHIPPED DATE",
        "SHIPPER ID",
        "SHIPPING FEE",
        "STATUS ID",
        "TAX RATE",
        "TAX STATUS",
        "TAXES",
        "VERSIONHISTORY_F5F8918F-0A3F-4DA9-AE71-184EE5012880"
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
        "customerId",
        "employeeId",
        "notes",
        "orderDate",
        "orderId",
        "paidDate",
        "paymentType",
        "shipAddress",
        "shipCity",
        "shipCountry/region",
        "shipName",
        "shipState/province",
        "shipZip/postalCode",
        "shippedDate",
        "shipperId",
        "shippingFee",
        "statusId",
        "taxRate",
        "taxStatus",
        "taxes",
        "versionhistoryF5f8918f-0a3f-4da9-ae71-184ee5012880"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "CustomerId",
        "EmployeeId",
        "Notes",
        "OrderDate",
        "OrderId",
        "PaidDate",
        "PaymentType",
        "ShipAddress",
        "ShipCity",
        "ShipCountry/region",
        "ShipName",
        "ShipState/province",
        "ShipZip/postalCode",
        "ShippedDate",
        "ShipperId",
        "ShippingFee",
        "StatusId",
        "TaxRate",
        "TaxStatus",
        "Taxes",
        "VersionhistoryF5f8918f-0a3f-4da9-ae71-184ee5012880"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String customerId;
    
    private String employeeId;
    
    private String notes;
    
    private String orderDate;
    
    private String orderId;
    
    private String paidDate;
    
    private String paymentType;
    
    private String shipAddress;
    
    private String shipCity;
    
    private String shipCountry/region;
    
    private String shipName;
    
    private String shipState/province;
    
    private String shipZip/postalCode;
    
    private String shippedDate;
    
    private String shipperId;
    
    private String shippingFee;
    
    private String statusId;
    
    private String taxRate;
    
    private String taxStatus;
    
    private String taxes;
    
    private String versionhistoryF5f8918f-0a3f-4da9-ae71-184ee5012880;
    
    //
    // trivial getters and setters
    //
    
    // customerId
    
    public void setCustomerId(String val) {
        this.customerId = val;
    }
    
    public String getCustomerId() {
        return this.customerId;
    }
    
    // employeeId
    
    public void setEmployeeId(String val) {
        this.employeeId = val;
    }
    
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    // notes
    
    public void setNotes(String val) {
        this.notes = val;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    // orderDate
    
    public void setOrderDate(String val) {
        this.orderDate = val;
    }
    
    public String getOrderDate() {
        return this.orderDate;
    }
    
    // orderId
    
    public void setOrderId(String val) {
        this.orderId = val;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
    
    // paidDate
    
    public void setPaidDate(String val) {
        this.paidDate = val;
    }
    
    public String getPaidDate() {
        return this.paidDate;
    }
    
    // paymentType
    
    public void setPaymentType(String val) {
        this.paymentType = val;
    }
    
    public String getPaymentType() {
        return this.paymentType;
    }
    
    // shipAddress
    
    public void setShipAddress(String val) {
        this.shipAddress = val;
    }
    
    public String getShipAddress() {
        return this.shipAddress;
    }
    
    // shipCity
    
    public void setShipCity(String val) {
        this.shipCity = val;
    }
    
    public String getShipCity() {
        return this.shipCity;
    }
    
    // shipCountry/region
    
    public void setShipCountry/region(String val) {
        this.shipCountry/region = val;
    }
    
    public String getShipCountry/region() {
        return this.shipCountry/region;
    }
    
    // shipName
    
    public void setShipName(String val) {
        this.shipName = val;
    }
    
    public String getShipName() {
        return this.shipName;
    }
    
    // shipState/province
    
    public void setShipState/province(String val) {
        this.shipState/province = val;
    }
    
    public String getShipState/province() {
        return this.shipState/province;
    }
    
    // shipZip/postalCode
    
    public void setShipZip/postalCode(String val) {
        this.shipZip/postalCode = val;
    }
    
    public String getShipZip/postalCode() {
        return this.shipZip/postalCode;
    }
    
    // shippedDate
    
    public void setShippedDate(String val) {
        this.shippedDate = val;
    }
    
    public String getShippedDate() {
        return this.shippedDate;
    }
    
    // shipperId
    
    public void setShipperId(String val) {
        this.shipperId = val;
    }
    
    public String getShipperId() {
        return this.shipperId;
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
    
    // taxRate
    
    public void setTaxRate(String val) {
        this.taxRate = val;
    }
    
    public String getTaxRate() {
        return this.taxRate;
    }
    
    // taxStatus
    
    public void setTaxStatus(String val) {
        this.taxStatus = val;
    }
    
    public String getTaxStatus() {
        return this.taxStatus;
    }
    
    // taxes
    
    public void setTaxes(String val) {
        this.taxes = val;
    }
    
    public String getTaxes() {
        return this.taxes;
    }
    
    // versionhistoryF5f8918f-0a3f-4da9-ae71-184ee5012880
    
    public void setVersionhistoryF5f8918f-0a3f-4da9-ae71-184ee5012880(String val) {
        this.versionhistoryF5f8918f-0a3f-4da9-ae71-184ee5012880 = val;
    }
    
    public String getVersionhistoryF5f8918f-0a3f-4da9-ae71-184ee5012880() {
        return this.versionhistoryF5f8918f-0a3f-4da9-ae71-184ee5012880;
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
