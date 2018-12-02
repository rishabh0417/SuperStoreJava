package Backend;

import java.io.Serializable;

public class User implements Serializable {
    @Override
    public String toString() {
        return username;
    }

    public String username;
    public String password;

    public User(String usr, String pas){
        username = usr;
        password = pas;
    }
}
