package Backend;

import java.io.*;
import java.util.List;

public class SuperStore implements Serializable{

    private List<StoreAdmin> list_of_store_admins;
    private List<WarehouseAdmin> list_of_warehouse_admins;
    private List<Warehouse> list_of_warehouse;
    private List<Store> list_of_store;

    Database main_database;

    public SuperStore(){
        main_database = new Database();
    }


    public List<StoreAdmin> getList_of_store_admins() {
        return list_of_store_admins;
    }

    public void setList_of_store_admins(List<StoreAdmin> list_of_store_admins) {
        this.list_of_store_admins = list_of_store_admins;
    }

    public List<WarehouseAdmin> getList_of_warehouse_admins() {
        return list_of_warehouse_admins;
    }

    public void setList_of_warehouse_admins(List<WarehouseAdmin> list_of_warehouse_admins) {
        this.list_of_warehouse_admins = list_of_warehouse_admins;
    }

    public Database getMain_database() {
        return main_database;
    }

    public void setMain_database(Database main_database) {
        this.main_database = main_database;
    }
}
