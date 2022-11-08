//
// Data Value Object (DVO) for Products
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class ProductsDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "Products";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "northwind";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "ATTACHMENTS",
        "CATEGORY",
        "DESCRIPTION",
        "DISCONTINUED",
        "ID",
        "LIST PRICE",
        "MINIMUM REORDER QUANTITY",
        "PRODUCT CODE",
        "PRODUCT NAME",
        "QUANTITY PER UNIT",
        "REORDER LEVEL",
        "STANDARD COST",
        "SUPPLIER IDS",
        "TARGET LEVEL"
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
        "attachments",
        "category",
        "description",
        "discontinued",
        "id",
        "listPrice",
        "minimumReorderQuantity",
        "productCode",
        "productName",
        "quantityPerUnit",
        "reorderLevel",
        "standardCost",
        "supplierIds",
        "targetLevel"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "Attachments",
        "Category",
        "Description",
        "Discontinued",
        "Id",
        "ListPrice",
        "MinimumReorderQuantity",
        "ProductCode",
        "ProductName",
        "QuantityPerUnit",
        "ReorderLevel",
        "StandardCost",
        "SupplierIds",
        "TargetLevel"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String attachments;
    
    private String category;
    
    private String description;
    
    private String discontinued;
    
    private String id;
    
    private String listPrice;
    
    private String minimumReorderQuantity;
    
    private String productCode;
    
    private String productName;
    
    private String quantityPerUnit;
    
    private String reorderLevel;
    
    private String standardCost;
    
    private String supplierIds;
    
    private String targetLevel;
    
    //
    // trivial getters and setters
    //
    
    // attachments
    
    public void setAttachments(String val) {
        this.attachments = val;
    }
    
    public String getAttachments() {
        return this.attachments;
    }
    
    // category
    
    public void setCategory(String val) {
        this.category = val;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    // description
    
    public void setDescription(String val) {
        this.description = val;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    // discontinued
    
    public void setDiscontinued(String val) {
        this.discontinued = val;
    }
    
    public String getDiscontinued() {
        return this.discontinued;
    }
    
    // id
    
    public void setId(String val) {
        this.id = val;
    }
    
    public String getId() {
        return this.id;
    }
    
    // listPrice
    
    public void setListPrice(String val) {
        this.listPrice = val;
    }
    
    public String getListPrice() {
        return this.listPrice;
    }
    
    // minimumReorderQuantity
    
    public void setMinimumReorderQuantity(String val) {
        this.minimumReorderQuantity = val;
    }
    
    public String getMinimumReorderQuantity() {
        return this.minimumReorderQuantity;
    }
    
    // productCode
    
    public void setProductCode(String val) {
        this.productCode = val;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    
    // productName
    
    public void setProductName(String val) {
        this.productName = val;
    }
    
    public String getProductName() {
        return this.productName;
    }
    
    // quantityPerUnit
    
    public void setQuantityPerUnit(String val) {
        this.quantityPerUnit = val;
    }
    
    public String getQuantityPerUnit() {
        return this.quantityPerUnit;
    }
    
    // reorderLevel
    
    public void setReorderLevel(String val) {
        this.reorderLevel = val;
    }
    
    public String getReorderLevel() {
        return this.reorderLevel;
    }
    
    // standardCost
    
    public void setStandardCost(String val) {
        this.standardCost = val;
    }
    
    public String getStandardCost() {
        return this.standardCost;
    }
    
    // supplierIds
    
    public void setSupplierIds(String val) {
        this.supplierIds = val;
    }
    
    public String getSupplierIds() {
        return this.supplierIds;
    }
    
    // targetLevel
    
    public void setTargetLevel(String val) {
        this.targetLevel = val;
    }
    
    public String getTargetLevel() {
        return this.targetLevel;
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
