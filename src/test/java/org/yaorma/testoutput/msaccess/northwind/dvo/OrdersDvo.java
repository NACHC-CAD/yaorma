//
// Data Value Object (DVO) for Orders
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.math.BigDecimal;

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
        "customer_SPACE_id",
        "employee_SPACE_id",
        "notes",
        "order_SPACE_date",
        "order_SPACE_id",
        "paid_SPACE_date",
        "payment_SPACE_type",
        "ship_SPACE_address",
        "ship_SPACE_city",
        "ship_SPACE_country_SLASH_region",
        "ship_SPACE_name",
        "ship_SPACE_state_SLASH_province",
        "ship_SPACE_zip_SLASH_postal_SPACE_code",
        "shipped_SPACE_date",
        "shipper_SPACE_id",
        "shipping_SPACE_fee",
        "status_SPACE_id",
        "tax_SPACE_rate",
        "tax_SPACE_status",
        "taxes",
        "versionhistoryF5f8918f_0a3f_4da9_ae71_184ee5012880"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Customer_SPACE_id",
        "Employee_SPACE_id",
        "Notes",
        "Order_SPACE_date",
        "Order_SPACE_id",
        "Paid_SPACE_date",
        "Payment_SPACE_type",
        "Ship_SPACE_address",
        "Ship_SPACE_city",
        "Ship_SPACE_country_SLASH_region",
        "Ship_SPACE_name",
        "Ship_SPACE_state_SLASH_province",
        "Ship_SPACE_zip_SLASH_postal_SPACE_code",
        "Shipped_SPACE_date",
        "Shipper_SPACE_id",
        "Shipping_SPACE_fee",
        "Status_SPACE_id",
        "Tax_SPACE_rate",
        "Tax_SPACE_status",
        "Taxes",
        "VersionhistoryF5f8918f_0a3f_4da9_ae71_184ee5012880"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private Integer customer_SPACE_id;
    
    private Integer employee_SPACE_id;
    
    private String notes;
    
    private String order_SPACE_date;
    
    private Integer order_SPACE_id;
    
    private String paid_SPACE_date;
    
    private String payment_SPACE_type;
    
    private String ship_SPACE_address;
    
    private String ship_SPACE_city;
    
    private String ship_SPACE_country_SLASH_region;
    
    private String ship_SPACE_name;
    
    private String ship_SPACE_state_SLASH_province;
    
    private String ship_SPACE_zip_SLASH_postal_SPACE_code;
    
    private String shipped_SPACE_date;
    
    private Integer shipper_SPACE_id;
    
    private String shipping_SPACE_fee;
    
    private String status_SPACE_id;
    
    private String tax_SPACE_rate;
    
    private String tax_SPACE_status;
    
    private String taxes;
    
    private String versionhistoryF5f8918f_0a3f_4da9_ae71_184ee5012880;
    
    //
    // trivial getters and setters
    //
    
    // customer_SPACE_id
    
    public void setCustomer_SPACE_id(Integer val) {
        this.customer_SPACE_id = val;
    }
    
    public Integer getCustomer_SPACE_id() {
        return this.customer_SPACE_id;
    }
    
    // employee_SPACE_id
    
    public void setEmployee_SPACE_id(Integer val) {
        this.employee_SPACE_id = val;
    }
    
    public Integer getEmployee_SPACE_id() {
        return this.employee_SPACE_id;
    }
    
    // notes
    
    public void setNotes(String val) {
        this.notes = val;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    // order_SPACE_date
    
    public void setOrder_SPACE_date(String val) {
        this.order_SPACE_date = val;
    }
    
    public String getOrder_SPACE_date() {
        return this.order_SPACE_date;
    }
    
    // order_SPACE_id
    
    public void setOrder_SPACE_id(Integer val) {
        this.order_SPACE_id = val;
    }
    
    public Integer getOrder_SPACE_id() {
        return this.order_SPACE_id;
    }
    
    // paid_SPACE_date
    
    public void setPaid_SPACE_date(String val) {
        this.paid_SPACE_date = val;
    }
    
    public String getPaid_SPACE_date() {
        return this.paid_SPACE_date;
    }
    
    // payment_SPACE_type
    
    public void setPayment_SPACE_type(String val) {
        this.payment_SPACE_type = val;
    }
    
    public String getPayment_SPACE_type() {
        return this.payment_SPACE_type;
    }
    
    // ship_SPACE_address
    
    public void setShip_SPACE_address(String val) {
        this.ship_SPACE_address = val;
    }
    
    public String getShip_SPACE_address() {
        return this.ship_SPACE_address;
    }
    
    // ship_SPACE_city
    
    public void setShip_SPACE_city(String val) {
        this.ship_SPACE_city = val;
    }
    
    public String getShip_SPACE_city() {
        return this.ship_SPACE_city;
    }
    
    // ship_SPACE_country_SLASH_region
    
    public void setShip_SPACE_country_SLASH_region(String val) {
        this.ship_SPACE_country_SLASH_region = val;
    }
    
    public String getShip_SPACE_country_SLASH_region() {
        return this.ship_SPACE_country_SLASH_region;
    }
    
    // ship_SPACE_name
    
    public void setShip_SPACE_name(String val) {
        this.ship_SPACE_name = val;
    }
    
    public String getShip_SPACE_name() {
        return this.ship_SPACE_name;
    }
    
    // ship_SPACE_state_SLASH_province
    
    public void setShip_SPACE_state_SLASH_province(String val) {
        this.ship_SPACE_state_SLASH_province = val;
    }
    
    public String getShip_SPACE_state_SLASH_province() {
        return this.ship_SPACE_state_SLASH_province;
    }
    
    // ship_SPACE_zip_SLASH_postal_SPACE_code
    
    public void setShip_SPACE_zip_SLASH_postal_SPACE_code(String val) {
        this.ship_SPACE_zip_SLASH_postal_SPACE_code = val;
    }
    
    public String getShip_SPACE_zip_SLASH_postal_SPACE_code() {
        return this.ship_SPACE_zip_SLASH_postal_SPACE_code;
    }
    
    // shipped_SPACE_date
    
    public void setShipped_SPACE_date(String val) {
        this.shipped_SPACE_date = val;
    }
    
    public String getShipped_SPACE_date() {
        return this.shipped_SPACE_date;
    }
    
    // shipper_SPACE_id
    
    public void setShipper_SPACE_id(Integer val) {
        this.shipper_SPACE_id = val;
    }
    
    public Integer getShipper_SPACE_id() {
        return this.shipper_SPACE_id;
    }
    
    // shipping_SPACE_fee
    
    public void setShipping_SPACE_fee(String val) {
        this.shipping_SPACE_fee = val;
    }
    
    public String getShipping_SPACE_fee() {
        return this.shipping_SPACE_fee;
    }
    
    // status_SPACE_id
    
    public void setStatus_SPACE_id(String val) {
        this.status_SPACE_id = val;
    }
    
    public String getStatus_SPACE_id() {
        return this.status_SPACE_id;
    }
    
    // tax_SPACE_rate
    
    public void setTax_SPACE_rate(String val) {
        this.tax_SPACE_rate = val;
    }
    
    public String getTax_SPACE_rate() {
        return this.tax_SPACE_rate;
    }
    
    // tax_SPACE_status
    
    public void setTax_SPACE_status(String val) {
        this.tax_SPACE_status = val;
    }
    
    public String getTax_SPACE_status() {
        return this.tax_SPACE_status;
    }
    
    // taxes
    
    public void setTaxes(String val) {
        this.taxes = val;
    }
    
    public String getTaxes() {
        return this.taxes;
    }
    
    // versionhistoryF5f8918f_0a3f_4da9_ae71_184ee5012880
    
    public void setVersionhistoryF5f8918f_0a3f_4da9_ae71_184ee5012880(String val) {
        this.versionhistoryF5f8918f_0a3f_4da9_ae71_184ee5012880 = val;
    }
    
    public String getVersionhistoryF5f8918f_0a3f_4da9_ae71_184ee5012880() {
        return this.versionhistoryF5f8918f_0a3f_4da9_ae71_184ee5012880;
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
