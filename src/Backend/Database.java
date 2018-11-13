package Backend;

import java.io.Serializable;
import java.util.*;

public class Database implements Serializable {

    private HashMap<String, Category> categories;
    private List<Product> list_of_product_names;
    private SortedSet<Product> sorted_list_of_product_names;
    String path;

    public HashMap<String, Category> getCategories() {
        return categories;
    }

    public void setCategories(HashMap<String, Category> categories) {
        this.categories = categories;
    }

    public Database(){
        categories = new HashMap<>();
        list_of_product_names = new LinkedList<>();
        sorted_list_of_product_names = new TreeSet<>();
    }

    public void insert(String subCategory, String product) throws ProductExistsException{

        Category c = null;
        product = product.trim();
        String[] cats = subCategory.split(">");
        boolean exists = true;

        if (categories.get(cats[0]) != null) c = categories.get(cats[0]);
        else {
            c = new Category(cats[0]);
            categories.put(cats[0], c);
        }

        for (int i = 1 ; i < cats.length ; i++){
            if (c.getSubCategory().get(cats[i]) != null){
                c = c.getSubCategory().get(cats[i]);
            }else {
                exists = false;
                Category cc = new Category(cats[i]);
                c.getSubCategory().put(cats[i], cc);
                c = cc;
            }
        }

        Product p = new Product(product);
        p.setPath(subCategory + ">" + product);
        Category cut = new Category(product);
        cut.setProduct(p);

        if (c.getSubCategory().get(product) == null) {
            c.getSubCategory().put(product, cut);
            list_of_product_names.add(p);
            sorted_list_of_product_names.add(p);
        }
        else throw new ProductExistsException("The given product already exists");

    }

    public void delete(String path) throws ProductNotExistsException{
        String[] dat = path.split(">");
        Category c = null;
        Category c_prev = null;
        if (categories.get(dat[0]) == null) throw new ProductNotExistsException("no such path exists.");
        else c = categories.get(dat[0]);

        int i;
        for (i = 1; i < dat.length; i++) {
            c_prev = c;
            if (c.getSubCategory().get(dat[i]) != null){
                c = c.getSubCategory().get(dat[i]);
            }else break;
        }


        String cat_to_delete = dat[dat.length - 1];
        for (Product p : list_of_product_names){
            if (p.getPath().contains(cat_to_delete)){
                list_of_product_names.remove(p);
                sorted_list_of_product_names.remove(p);
            }
        }

        if (i == dat.length){
            c_prev.getSubCategory().remove(dat[i - 1]);
        }else throw new ProductNotExistsException("no such path exists.");
    }

    public List<Product> search(String product_name) throws ProductNotExistsException{

        List<Product> lst = new LinkedList<>();
        boolean flag = false;
        for (Product p : list_of_product_names){
            if (product_name.equalsIgnoreCase(p.getName())){
                flag = true;
                lst.add(p);
            }
        }
        if (!flag) throw new ProductNotExistsException("No such product found in the inventory.");
        return lst;
    }



    public int sale(Product product, int qty, int balance) throws SaleNotPossibleException{
        if (product.getUnits() < qty){
            if (product.getCost()*qty > balance) throw new SaleNotPossibleException("Sale not possible due to limited products");
        }
        else if (product.getCost()*qty > balance) {
            throw new SaleNotPossibleException("Sale not possible due to insufficient balance, add funds");
        }
        product.setUnits(product.getUnits() - qty);
        return product.getCost()*qty;
    }

    public List<Product> getList_of_product_names() {
        return list_of_product_names;
    }

    public void setList_of_product_names(List<Product> list_of_product_names) {
        this.list_of_product_names = list_of_product_names;
    }

    public SortedSet<Product> getSorted_list_of_product_names() {
        return sorted_list_of_product_names;
    }

    public void setSorted_list_of_product_names(SortedSet<Product> sorted_list_of_product_names) {
        this.sorted_list_of_product_names = sorted_list_of_product_names;
    }
}

//  Exception classes.

class ProductExistsException extends Exception{
    public ProductExistsException(String message){
        super(message);
    }
}

class ProductNotExistsException extends Exception{
    public ProductNotExistsException(String msg){
        super(msg);
    }
}

class SaleNotPossibleException extends Exception {
    public SaleNotPossibleException(String message){ super(message); }
}