package Backend;

import java.io.Serializable;
import java.util.HashMap;

/**
 * The objects of is used to store all the products the end user wants to buy.
 */
public class Cart implements Serializable {


    /**

    @summary String is the name of the product and the Integer is the quantity
    */
    private HashMap<String, Integer> list_of_items;


    /**
     * getter
     * @return list_of_items
     */
    public HashMap<String, Integer> getList_of_items() {
        return list_of_items;
    }
}
