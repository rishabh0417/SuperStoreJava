package Frontend;

import Backend.*;

import java.util.List;

public class DATA {
    public static boolean isSuperUser;
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
//    1 : means wareshouse and 2 : means store.

    public DATA(){
    }

}
