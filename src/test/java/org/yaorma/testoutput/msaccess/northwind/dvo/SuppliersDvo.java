//
// Data Value Object (DVO) for Suppliers
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class SuppliersDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Suppliers";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "ADDRESS",
        "ATTACHMENTS",
        "BUSINESS PHONE",
        "CITY",
        "COMPANY",
        "COUNTRY/REGION",
        "E-MAIL ADDRESS",
        "FAX NUMBER",
        "FIRST NAME",
        "HOME PHONE",
        "ID",
        "JOB TITLE",
        "LAST NAME",
        "MOBILE PHONE",
        "NOTES",
        "STATE/PROVINCE",
        "WEB PAGE",
        "ZIP/POSTAL CODE"
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
        "address",
        "attachments",
        "business_SPACE_phone",
        "city",
        "company",
        "country_SLASH_region",
        "e_mail_SPACE_address",
        "fax_SPACE_number",
        "first_SPACE_name",
        "home_SPACE_phone",
        "id",
        "job_SPACE_title",
        "last_SPACE_name",
        "mobile_SPACE_phone",
        "notes",
        "state_SLASH_province",
        "web_SPACE_page",
        "zip_SLASH_postal_SPACE_code"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Address",
        "Attachments",
        "Business_SPACE_phone",
        "City",
        "Company",
        "Country_SLASH_region",
        "E_mail_SPACE_address",
        "Fax_SPACE_number",
        "First_SPACE_name",
        "Home_SPACE_phone",
        "Id",
        "Job_SPACE_title",
        "Last_SPACE_name",
        "Mobile_SPACE_phone",
        "Notes",
        "State_SLASH_province",
        "Web_SPACE_page",
        "Zip_SLASH_postal_SPACE_code"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String address;
    
    private String attachments;
    
    private String business_SPACE_phone;
    
    private String city;
    
    private String company;
    
    private String country_SLASH_region;
    
    private String e_mail_SPACE_address;
    
    private String fax_SPACE_number;
    
    private String first_SPACE_name;
    
    private String home_SPACE_phone;
    
    private Integer id;
    
    private String job_SPACE_title;
    
    private String last_SPACE_name;
    
    private String mobile_SPACE_phone;
    
    private String notes;
    
    private String state_SLASH_province;
    
    private String web_SPACE_page;
    
    private String zip_SLASH_postal_SPACE_code;
    
    //
    // trivial getters and setters
    //
    
    // address
    
    public void setAddress(String val) {
        this.address = val;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    // attachments
    
    public void setAttachments(String val) {
        this.attachments = val;
    }
    
    public String getAttachments() {
        return this.attachments;
    }
    
    // business_SPACE_phone
    
    public void setBusiness_SPACE_phone(String val) {
        this.business_SPACE_phone = val;
    }
    
    public String getBusiness_SPACE_phone() {
        return this.business_SPACE_phone;
    }
    
    // city
    
    public void setCity(String val) {
        this.city = val;
    }
    
    public String getCity() {
        return this.city;
    }
    
    // company
    
    public void setCompany(String val) {
        this.company = val;
    }
    
    public String getCompany() {
        return this.company;
    }
    
    // country_SLASH_region
    
    public void setCountry_SLASH_region(String val) {
        this.country_SLASH_region = val;
    }
    
    public String getCountry_SLASH_region() {
        return this.country_SLASH_region;
    }
    
    // e_mail_SPACE_address
    
    public void setE_mail_SPACE_address(String val) {
        this.e_mail_SPACE_address = val;
    }
    
    public String getE_mail_SPACE_address() {
        return this.e_mail_SPACE_address;
    }
    
    // fax_SPACE_number
    
    public void setFax_SPACE_number(String val) {
        this.fax_SPACE_number = val;
    }
    
    public String getFax_SPACE_number() {
        return this.fax_SPACE_number;
    }
    
    // first_SPACE_name
    
    public void setFirst_SPACE_name(String val) {
        this.first_SPACE_name = val;
    }
    
    public String getFirst_SPACE_name() {
        return this.first_SPACE_name;
    }
    
    // home_SPACE_phone
    
    public void setHome_SPACE_phone(String val) {
        this.home_SPACE_phone = val;
    }
    
    public String getHome_SPACE_phone() {
        return this.home_SPACE_phone;
    }
    
    // id
    
    public void setId(Integer val) {
        this.id = val;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    // job_SPACE_title
    
    public void setJob_SPACE_title(String val) {
        this.job_SPACE_title = val;
    }
    
    public String getJob_SPACE_title() {
        return this.job_SPACE_title;
    }
    
    // last_SPACE_name
    
    public void setLast_SPACE_name(String val) {
        this.last_SPACE_name = val;
    }
    
    public String getLast_SPACE_name() {
        return this.last_SPACE_name;
    }
    
    // mobile_SPACE_phone
    
    public void setMobile_SPACE_phone(String val) {
        this.mobile_SPACE_phone = val;
    }
    
    public String getMobile_SPACE_phone() {
        return this.mobile_SPACE_phone;
    }
    
    // notes
    
    public void setNotes(String val) {
        this.notes = val;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    // state_SLASH_province
    
    public void setState_SLASH_province(String val) {
        this.state_SLASH_province = val;
    }
    
    public String getState_SLASH_province() {
        return this.state_SLASH_province;
    }
    
    // web_SPACE_page
    
    public void setWeb_SPACE_page(String val) {
        this.web_SPACE_page = val;
    }
    
    public String getWeb_SPACE_page() {
        return this.web_SPACE_page;
    }
    
    // zip_SLASH_postal_SPACE_code
    
    public void setZip_SLASH_postal_SPACE_code(String val) {
        this.zip_SLASH_postal_SPACE_code = val;
    }
    
    public String getZip_SLASH_postal_SPACE_code() {
        return this.zip_SLASH_postal_SPACE_code;
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
