package Backend;

import java.io.Serializable;

public class Store implements Serializable {

    String id;
    Database store_inventory;
    Warehouse linked_warehouse;

    public Store(){
        store_inventory = new Database();
    }

    public void autoFill(){

    }

    public float calEOQ(){
        return 3f;
    }
}
