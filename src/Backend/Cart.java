package Backend;

import java.io.Serializable;
import java.util.HashMap;

public class Cart implements Serializable {


    /*

    @summary String is the name of the product and the Integer is the
    */
    private HashMap<Product, Integer> list_of_items;

    public HashMap<Product, Integer> getList_of_items() {
        return list_of_items;
    }
}
