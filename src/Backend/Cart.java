package Backend;

import java.io.Serializable;
import java.util.HashMap;


/**
 * The objects of is used to store all the products the end user wants to buy.
 */
public class Cart implements Serializable {



    public Cart(){
        list_of_items = new HashMap<>();
    }

    /**

     @summary String is the name of the product and the Integer is the quantity
     */
    private HashMap<Product, Integer> list_of_items;



    /**
     * getter
     * @return list_of_items
     */
    public HashMap<Product, Integer> getList_of_items() {
        return list_of_items;
    }
}
