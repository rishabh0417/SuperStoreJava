package Backend;

import java.io.Serializable;
import java.util.HashMap;

/**
 * The objects of this class represents the sub-directories of products
 */
public class Category implements Serializable {

    private String name;
    private Product product;
    /**
     * contains all the categories inside this category
     */
    private HashMap<String, Category> subCategory;

    /**
     * getter
     * @return product objects
     */
    public Product getProduct() {
        return product;
    }

    /**
     * setter
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * getter
     * @return subcategories
     */
    public HashMap<String, Category> getSubCategory() {
        return subCategory;
    }

    /**
     * setter
     * @param subCategory
     */
    public void setSubCategory(HashMap<String, Category> subCategory) {
        this.subCategory = subCategory;
    }

    /**
     * constructor
     * @param name
     */
    public Category(String name){
        product = null;
        subCategory = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (product != null) return product.getName() + "p";
        else return this.name;
    }
}