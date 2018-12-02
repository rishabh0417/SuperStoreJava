package Backend;

import java.io.*;

/**
 * fileWriter is used for serialisation and deserialization.
 */
public class FileWriter {

    public FileWriter(){

    }

    /**
     * function to serialise the whole superstore class
     * @param sa
     * @throws IOException
     */
    public static void Serialize(SuperStore sa) throws IOException {
        String file = "src/Config.txt";
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
     * function to deserialise the whole superstore class
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static SuperStore Deserialize() throws IOException, ClassNotFoundException {
        String file = "src/Config.txt";
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
