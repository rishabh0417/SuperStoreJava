package Backend;

//import statements
import java.io.Serializable;

/**
 * Representing an entity under store admin
 */
public class Store implements Serializable {
    //**********************************************************
    //variables
    //**********************************************************
    public String id;
    public Database store_inventory;
    public Warehouse linked_warehouse;

    //**********************************************************
    //Constructor
    //**********************************************************
    public Store(){
        store_inventory = new Database();
    }

    public void autoFill(){

    }

    //?
    public float calEOQ(){
        return 3f;
    }

    @Override
    public String toString() {
        return this.id;
    }

    /**
     *getter for id
     * @return id ID of the store
     */
    public String getId() {
        return id;
    }

    /**
     *getter
     * @return store_inventory directory of store products
     */
    public Database getStore_inventory() {
        return store_inventory;
    }

    /**
     *setter
     * @param id Store ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *setter
     * @param store_inventory directory of store products
     */
    public void setStore_inventory(Database store_inventory) {
        this.store_inventory = store_inventory;
    }

    /**
     *getter
     * @return linked warehouse
     */
    public Warehouse getLinked_warehouse() {
        return linked_warehouse;
    }

    /**
     *setter for warehouse
     * @param linked_warehouse the warehouse linked to the store
     */
    public void setLinked_warehouse(Warehouse linked_warehouse) {
        this.linked_warehouse = linked_warehouse;
    }
}
