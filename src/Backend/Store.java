package Backend;

import java.io.Serializable;

public class Store implements Serializable {

    public String id;
    public Database store_inventory;
    public Warehouse linked_warehouse;

    public Store(){
        store_inventory = new Database();
    }

    public void autoFill(){

    }

    public float calEOQ(){
        return 3f;
    }

    @Override
    public String toString() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Database getStore_inventory() {
        return store_inventory;
    }

    public void setStore_inventory(Database store_inventory) {
        this.store_inventory = store_inventory;
    }

    public Warehouse getLinked_warehouse() {
        return linked_warehouse;
    }

    public void setLinked_warehouse(Warehouse linked_warehouse) {
        this.linked_warehouse = linked_warehouse;
    }
}
