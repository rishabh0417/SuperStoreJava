package Backend;

import java.io.*;

public class SuperUser extends User {
    private SuperStore superStore;

    public SuperUser(String i, String p){
        super(i, p);
        this.superStore = new SuperStore();
    }

    public void setCredentials(String a, String b){
        username = a;
        password = b;
    }

//    Serialization and Deserialization
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