package Backend;

import java.io.*;

/**
 * Customised for testing the operations of the application in the backend only.
 */
public class BackendTester {

    public static void main(String[] args) {

        int test_mode = 1;

        if (test_mode == 1) {
            Warehouse w1 = new Warehouse();
            w1.id = "#123";
            try {
                w1.warehouse_inventory.insert("root>phone", new Product("iphone"));
                w1.warehouse_inventory.insert("root>phone", new Product("oneplus"));
                w1.warehouse_inventory.insert("root>new", new Product("6tOneplus"));
                w1.warehouse_inventory.insert("root>new", new Product("samsung"));
                w1.warehouse_inventory.insert("root>elec>house", new Product("toaster"));
            } catch (ProductExistsException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            Warehouse w2 = new Warehouse();
            w2.id = "#12";
            try {
                w2.warehouse_inventory.insert("root>phone", new Product("iphone"));
                w2.warehouse_inventory.insert("root>phone", new Product("oneplus"));
                w2.warehouse_inventory.insert("root>new", new Product("6tOneplus"));
                w2.warehouse_inventory.insert("root>new", new Product("samsung"));
                w2.warehouse_inventory.insert("root>elec>house", new Product("toaster"));
            } catch (ProductExistsException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            Warehouse w3 = new Warehouse();
            w3.id = "#1";
            try {
                w3.warehouse_inventory.insert("root>phone", new Product("iphone"));
                w3.warehouse_inventory.insert("root>phone", new Product("oneplus"));
                w3.warehouse_inventory.insert("root>new", new Product("6tOneplus"));
                w3.warehouse_inventory.insert("root>new", new Product("samsung"));
                w3.warehouse_inventory.insert("root>elec>house", new Product("toaster"));
            } catch (ProductExistsException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }


            Store s1 = new Store();
            s1.id = "#1";
            try {
                s1.store_inventory.insert("root>phone", new Product("iphone"));
                s1.store_inventory.insert("root>new", new Product("samsung"));
                s1.store_inventory.insert("root>elec>house", new Product("toaster"));
            } catch (ProductExistsException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            s1.linked_warehouse = w1;

            Store s2 = new Store();
            s2.id = "#2";
            try {
                s2.store_inventory.insert("root>phone", new Product("iphone"));
                s2.store_inventory.insert("root>new", new Product("samsung"));
                s2.store_inventory.insert("root>elec>house", new Product("toaster"));
            } catch (ProductExistsException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            s2.linked_warehouse = w2;

            Store s3 = new Store();
            s3.id = "#3";
            try {
                s3.store_inventory.insert("root>phone", new Product("iphone"));
                s3.store_inventory.insert("root>new", new Product("samsung"));
                s3.store_inventory.insert("root>elec>house", new Product("toaster"));
            } catch (ProductExistsException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            s3.linked_warehouse = w3;

            w1.store_list.add(s1);
            w2.store_list.add(s2);
            w3.store_list.add(s3);

            SuperStore superStore = new SuperStore();
            superStore.getList_of_warehouse().add(w1);
            superStore.getList_of_warehouse().add(w2);
            superStore.getList_of_warehouse().add(w3);

            superStore.getList_of_store().add(s1);
            superStore.getList_of_store().add(s2);
            superStore.getList_of_store().add(s3);

            try {
                Serialize(superStore, "src/Config.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (test_mode == 2){
            try {

                SuperStore sa = Deserialize("src/Config.txt");

                System.out.println(sa.getList_of_warehouse_admins());

                for (WarehouseAdmin w : sa.getList_of_warehouse_admins()) {
                    System.out.println(w.getUsername() + " " + w.getPassword());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (test_mode == 3){
            try {
                SuperStore sa = Deserialize("src/Config.txt");
//                #1
                for (Warehouse w : sa.getList_of_warehouse()){
                    System.out.println(w + " : " + w.store_list);
                }

                for (Store s : sa.getList_of_store()){
                    System.out.println(s + " : " + s.linked_warehouse);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * testing serialisation
     * @param sa
     * @param file
     * @throws IOException
     */
    public static void Serialize(SuperStore sa, String file) throws IOException {
        ObjectOutputStream oStream = null;

        try {
            oStream = new ObjectOutputStream(new FileOutputStream(file));
            oStream.writeObject(sa);
            System.out.println("Super Store Saved.");
        } finally {
            oStream.close();
        }
    }

    /**
     * testing deserialisation
     * @param file
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static SuperStore Deserialize(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = null;
        SuperStore sa;

        try{
            inputStream = new ObjectInputStream(new FileInputStream(file));
            sa = (SuperStore) inputStream.readObject();
        } finally {
            inputStream.close();
        }

        return sa;
    }
}
