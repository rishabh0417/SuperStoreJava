package Backend;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Representing an entity under warehouse admin
 */
public class Warehouse implements Serializable {

    public String id;
    public Database warehouse_inventory;
    public List<Store> store_list;
    public WarehouseAdmin myAdmin;

    /**
     * constructor for warehouse
     */
    public Warehouse(){
        warehouse_inventory = new Database();
        store_list = new LinkedList<>();
    }

    /**
     *
     * @param s
     */
    public void acknowledge(Store s){

    }

    @Override
    public String toString() {
        return this.id;
    }


}
