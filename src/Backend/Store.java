package Backend;

public class Store {

    String id;
    Database store_inventory;
    Warehouse linked_warehouse;

    public void autoFill(){

    }

    public float calEOQ(){
        return 3f;
    }
}
