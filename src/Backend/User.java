package Backend;

import java.io.Serializable;

public class User implements Serializable {
    @Override
    public String toString() {
        return username;
    }

    String username;
    String password;

    public User(String usr, String pas){
        username = usr;
        password = pas;
    }
}
