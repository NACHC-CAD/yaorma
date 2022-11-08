//
// Data Value Object (DVO) for Customers
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class CustomersDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Customers";
    
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
        "country/region",
        "e-mailAddress",
        "faxNumber",
        "firstName",
        "homePhone",
        "id",
        "jobTitle",
        "lastName",
        "mobilePhone",
        "notes",
        "state/province",
        "webPage",
        "zip/postalCode"
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
        "Country/region",
        "E-mailAddress",
        "FaxNumber",
        "FirstName",
        "HomePhone",
        "Id",
        "JobTitle",
        "LastName",
        "MobilePhone",
        "Notes",
        "State/province",
        "WebPage",
        "Zip/postalCode"
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
    
    private String country/region;
    
    private String e-mailAddress;
    
    private String faxNumber;
    
    private String firstName;
    
    private String homePhone;
    
    private String id;
    
    private String jobTitle;
    
    private String lastName;
    
    private String mobilePhone;
    
    private String notes;
    
    private String state/province;
    
    private String webPage;
    
    private String zip/postalCode;
    
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
    
    // country/region
    
    public void setCountry/region(String val) {
        this.country/region = val;
    }
    
    public String getCountry/region() {
        return this.country/region;
    }
    
    // e-mailAddress
    
    public void setE-mailAddress(String val) {
        this.e-mailAddress = val;
    }
    
    public String getE-mailAddress() {
        return this.e-mailAddress;
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
    
    // state/province
    
    public void setState/province(String val) {
        this.state/province = val;
    }
    
    public String getState/province() {
        return this.state/province;
    }
    
    // webPage
    
    public void setWebPage(String val) {
        this.webPage = val;
    }
    
    public String getWebPage() {
        return this.webPage;
    }
    
    // zip/postalCode
    
    public void setZip/postalCode(String val) {
        this.zip/postalCode = val;
    }
    
    public String getZip/postalCode() {
        return this.zip/postalCode;
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
