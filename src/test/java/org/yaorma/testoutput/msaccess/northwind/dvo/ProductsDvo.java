//
// Data Value Object (DVO) for Products
//

package org.yaorma.testoutput.msaccess.northwind.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.math.BigDecimal;

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
        "list_SPACE_price",
        "minimum_SPACE_reorder_SPACE_quantity",
        "product_SPACE_code",
        "product_SPACE_name",
        "quantity_SPACE_per_SPACE_unit",
        "reorder_SPACE_level",
        "standard_SPACE_cost",
        "supplier_SPACE_ids",
        "target_SPACE_level"
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
        "List_SPACE_price",
        "Minimum_SPACE_reorder_SPACE_quantity",
        "Product_SPACE_code",
        "Product_SPACE_name",
        "Quantity_SPACE_per_SPACE_unit",
        "Reorder_SPACE_level",
        "Standard_SPACE_cost",
        "Supplier_SPACE_ids",
        "Target_SPACE_level"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String attachments;
    
    private String category;
    
    private String description;
    
    private String discontinued;
    
    private Integer id;
    
    private String list_SPACE_price;
    
    private String minimum_SPACE_reorder_SPACE_quantity;
    
    private String product_SPACE_code;
    
    private String product_SPACE_name;
    
    private String quantity_SPACE_per_SPACE_unit;
    
    private String reorder_SPACE_level;
    
    private String standard_SPACE_cost;
    
    private String supplier_SPACE_ids;
    
    private Integer target_SPACE_level;
    
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
    
    public void setId(Integer val) {
        this.id = val;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    // list_SPACE_price
    
    public void setList_SPACE_price(String val) {
        this.list_SPACE_price = val;
    }
    
    public String getList_SPACE_price() {
        return this.list_SPACE_price;
    }
    
    // minimum_SPACE_reorder_SPACE_quantity
    
    public void setMinimum_SPACE_reorder_SPACE_quantity(String val) {
        this.minimum_SPACE_reorder_SPACE_quantity = val;
    }
    
    public String getMinimum_SPACE_reorder_SPACE_quantity() {
        return this.minimum_SPACE_reorder_SPACE_quantity;
    }
    
    // product_SPACE_code
    
    public void setProduct_SPACE_code(String val) {
        this.product_SPACE_code = val;
    }
    
    public String getProduct_SPACE_code() {
        return this.product_SPACE_code;
    }
    
    // product_SPACE_name
    
    public void setProduct_SPACE_name(String val) {
        this.product_SPACE_name = val;
    }
    
    public String getProduct_SPACE_name() {
        return this.product_SPACE_name;
    }
    
    // quantity_SPACE_per_SPACE_unit
    
    public void setQuantity_SPACE_per_SPACE_unit(String val) {
        this.quantity_SPACE_per_SPACE_unit = val;
    }
    
    public String getQuantity_SPACE_per_SPACE_unit() {
        return this.quantity_SPACE_per_SPACE_unit;
    }
    
    // reorder_SPACE_level
    
    public void setReorder_SPACE_level(String val) {
        this.reorder_SPACE_level = val;
    }
    
    public String getReorder_SPACE_level() {
        return this.reorder_SPACE_level;
    }
    
    // standard_SPACE_cost
    
    public void setStandard_SPACE_cost(String val) {
        this.standard_SPACE_cost = val;
    }
    
    public String getStandard_SPACE_cost() {
        return this.standard_SPACE_cost;
    }
    
    // supplier_SPACE_ids
    
    public void setSupplier_SPACE_ids(String val) {
        this.supplier_SPACE_ids = val;
    }
    
    public String getSupplier_SPACE_ids() {
        return this.supplier_SPACE_ids;
    }
    
    // target_SPACE_level
    
    public void setTarget_SPACE_level(Integer val) {
        this.target_SPACE_level = val;
    }
    
    public Integer getTarget_SPACE_level() {
        return this.target_SPACE_level;
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
