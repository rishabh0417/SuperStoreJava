package Backend;

import java.io.Serializable;

/**
 * User is the super class of all admins.
 */
public class User implements Serializable {
    @Override
    public String toString() {
        return username;
    }

    public String username;
    public String password;

    /**
     * Constructor
     * @param usr
     * @param pas
     */
    public User(String usr, String pas){
        username = usr;
        password = pas;
    }
}
