package Backend;

import java.io.Serializable;

public class User implements Serializable {
//    String name;
//    int age;
    String username;
    String password;

    public User(String usr, String pas){
        username = usr;
        pas = password;
    }
}
