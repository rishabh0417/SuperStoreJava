package Backend;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Warehouse implements Serializable {

    String id;
    Database warehouse_inventory;
    List<Store> store_list;

    public Warehouse(){
        warehouse_inventory = new Database();
        store_list = new LinkedList<>();
    }

    public void acknowledge(Store s){

    }
}
