//
// Data Value Object (DVO) for Employees
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class EmployeesDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Employees";
    
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
        "businessPhone",
        "city",
        "company",
        "country_SLASH_region",
        "e_mailAddress",
        "faxNumber",
        "firstName",
        "homePhone",
        "id",
        "jobTitle",
        "lastName",
        "mobilePhone",
        "notes",
        "state_SLASH_province",
        "webPage",
        "zip_SLASH_postalCode"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Address",
        "Attachments",
        "BusinessPhone",
        "City",
        "Company",
        "Country_SLASH_region",
        "E_mailAddress",
        "FaxNumber",
        "FirstName",
        "HomePhone",
        "Id",
        "JobTitle",
        "LastName",
        "MobilePhone",
        "Notes",
        "State_SLASH_province",
        "WebPage",
        "Zip_SLASH_postalCode"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String address;
    
    private String attachments;
    
    private String businessPhone;
    
    private String city;
    
    private String company;
    
    private String country_SLASH_region;
    
    private String e_mailAddress;
    
    private String faxNumber;
    
    private String firstName;
    
    private String homePhone;
    
    private String id;
    
    private String jobTitle;
    
    private String lastName;
    
    private String mobilePhone;
    
    private String notes;
    
    private String state_SLASH_province;
    
    private String webPage;
    
    private String zip_SLASH_postalCode;
    
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
    
    // businessPhone
    
    public void setBusinessPhone(String val) {
        this.businessPhone = val;
    }
    
    public String getBusinessPhone() {
        return this.businessPhone;
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
    
    // e_mailAddress
    
    public void setE_mailAddress(String val) {
        this.e_mailAddress = val;
    }
    
    public String getE_mailAddress() {
        return this.e_mailAddress;
    }
    
    // faxNumber
    
    public void setFaxNumber(String val) {
        this.faxNumber = val;
    }
    
    public String getFaxNumber() {
        return this.faxNumber;
    }
    
    // firstName
    
    public void setFirstName(String val) {
        this.firstName = val;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    // homePhone
    
    public void setHomePhone(String val) {
        this.homePhone = val;
    }
    
    public String getHomePhone() {
        return this.homePhone;
    }
    
    // id
    
    public void setId(String val) {
        this.id = val;
    }
    
    public String getId() {
        return this.id;
    }
    
    // jobTitle
    
    public void setJobTitle(String val) {
        this.jobTitle = val;
    }
    
    public String getJobTitle() {
        return this.jobTitle;
    }
    
    // lastName
    
    public void setLastName(String val) {
        this.lastName = val;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    // mobilePhone
    
    public void setMobilePhone(String val) {
        this.mobilePhone = val;
    }
    
    public String getMobilePhone() {
        return this.mobilePhone;
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
    
    // webPage
    
    public void setWebPage(String val) {
        this.webPage = val;
    }
    
    public String getWebPage() {
        return this.webPage;
    }
    
    // zip_SLASH_postalCode
    
    public void setZip_SLASH_postalCode(String val) {
        this.zip_SLASH_postalCode = val;
    }
    
    public String getZip_SLASH_postalCode() {
        return this.zip_SLASH_postalCode;
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
