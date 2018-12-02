package Frontend;

import Backend.*;

import java.util.LinkedList;
import java.util.List;

public class DATA {
    public static boolean isSuperUser;
    public static boolean isWarehouseAdmin;
    public static boolean isStoreAdmin;
    public static boolean isEndUser;

    public static WarehouseAdmin cur_warehouseAdmin;


    public static SuperStore superStore;
    public static SuperUser current_super_user;
    public static List<Store> list_of_stores;
    public static List<Warehouse> list_of_warehouses;
    public static String path;
    public static Warehouse warehouse;
    public static Store store;
    public static String currentCategoryString = "root";
    public static Category currentCategory;
    public static int create_new_user_selection;
    public static List<WarehouseAdmin> list_of_warehouseAdmins;
    public static List<StoreAdmin> list_of_storeAdmins;

//    1 : means wareshouse and 2 : means store.

//    data variables.
    public static String string1;
    public static String string2;

    public DATA(){
        list_of_warehouseAdmins = new LinkedList<>();
        list_of_storeAdmins = new LinkedList<>();
    }


//    more variables

    public static Product curr_prodcut;

}
