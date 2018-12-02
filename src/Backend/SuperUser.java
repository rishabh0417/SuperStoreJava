package Backend;

import java.io.*;

/**
 * Class for the SuperUsers. Super User can create store, warehouses and their admins.
 */
public class SuperUser extends User {
    private SuperStore superStore;

    /**
     * constructor
     * @param i
     * @param p
     */
    public SuperUser(String i, String p){
        super(i, p);
        this.superStore = new SuperStore();
    }

    /**
     * method used to set username and passwords for superUser.
     * @param a
     * @param b
     */
    public void setCredentials(String a, String b){
        username = a;
        password = b;
    }


    /**
     * Serailsation of SuperUser
     * @param sa
     * @param file
     * @throws IOException
     */
    public static void Serialize(SuperStore sa, String file) throws IOException {
        ObjectOutputStream oStream = null;

        try {
            oStream = new ObjectOutputStream(new FileOutputStream(file));
            oStream.writeObject(sa);
            System.out.println("store admin saved.");
        } finally {
            oStream.close();
        }
    }

    /**
     * deserialistion of superUser
     * @param file
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static SuperStore DeserializeSA(String file) throws IOException, ClassNotFoundException {
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