package Backend;

import java.io.Serializable;
import java.util.*;

/**
 * Representation of the whole directory structure. This class contains list of all categories and their products.<br>
 * Contains all methods to insert and delete.
 */
public class Database implements Serializable {

    private HashMap<String, Category> categories;
    private List<Product> list_of_product_names;
    /**
     * Sorted set used so that insertion and deletion is fast.
     */
    private SortedSet<Product> sorted_list_of_product_names;
    String path;

    public HashMap<String, Category> getCategories() {
        return categories;
    }

    public void setCategories(HashMap<String, Category> categories) {
        this.categories = categories;
    }

    /**
     * constructor for the class
     */
    public Database(){
        categories = new HashMap<>();
        list_of_product_names = new LinkedList<>();
        sorted_list_of_product_names = new TreeSet<>();
    }

    /**
     *
     * Insert method is used to insert category or product.
     *
     * @param subCategory
     * @param p
     * @throws ProductExistsException
     */
    public void insert(String subCategory, Product p) throws ProductExistsException{

        Category c = null;
        Category prev = null;
//        product = product.trim();
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
                prev = cc;
                c.getSubCategory().put(cats[i], cc);
                c = cc;
            }
        }

        if (p != null) {
            p.setPath(subCategory + ">" + p.getName());
            Category cut = new Category(p.getName());
            cut.setProduct(p);

            if (c.getSubCategory().get(p.getName()) == null) {
                c.getSubCategory().put(p.getName(), cut);
                list_of_product_names.add(p);
                sorted_list_of_product_names.add(p);
            } else throw new ProductExistsException("The given product already exists");
        } else{

        }

    }

    /**
     *
     * delete method is used to delete any category or product with the given path.
     *
     * @param path
     * @throws ProductNotExistsException
     */
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

    /**
     *
     * search is used to search for a product or a subcategory.
     *
     * @param product_name
     * @return
     * @throws ProductNotExistsException
     */
    public List<Product> search(String product_name) throws ProductNotExistsException{

        List<Product> lst = new LinkedList<>();
        boolean flag = false;
        for (Product p : list_of_product_names){
            if (p.getName().contains(product_name)){
                flag = true;
                lst.add(p);
            }
        }
        if (!flag) throw new ProductNotExistsException("No such product found in the inventory.");
        return lst;
    }


    /**
     * sale is used to sell a product with the given quantity and end user balance
     * @param product
     * @param qty
     * @param balance
     * @return
     * @throws SaleNotPossibleException
     */
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


class ProductNotExistsException extends Exception{
    public ProductNotExistsException(String msg){
        super(msg);
    }
}

class SaleNotPossibleException extends Exception {
    public SaleNotPossibleException(String message){ super(message); }
}