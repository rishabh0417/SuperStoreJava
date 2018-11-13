package Backend;

import java.io.Serializable;
import java.util.HashMap;

public class Category implements Serializable {

    private String name;
    private Product product;
    private HashMap<String, Category> subCategory;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public HashMap<String, Category> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(HashMap<String, Category> subCategory) {
        this.subCategory = subCategory;
    }

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