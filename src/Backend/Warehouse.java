package Backend;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Warehouse implements Serializable {

    public String id;
    public Database warehouse_inventory;
    public List<Store> store_list;
    public WarehouseAdmin myAdmin;

    public Warehouse(){
        warehouse_inventory = new Database();
        store_list = new LinkedList<>();
    }

    public void acknowledge(Store s){

    }

    @Override
    public String toString() {
        return this.id;
    }


}
