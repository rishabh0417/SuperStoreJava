package Backend;

import java.io.Serializable;
import java.util.HashMap;

public class Cart implements Serializable {


    /*

    @summary String is the name of the product and the Integer is the
    */
    private HashMap<String, Integer> list_of_items;




    public HashMap<String, Integer> getList_of_items() {
        return list_of_items;
    }
}
