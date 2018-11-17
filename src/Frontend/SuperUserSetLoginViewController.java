package Frontend;

import Backend.StoreAdmin;
import Backend.SuperStore;
import Backend.WarehouseAdmin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class SuperUserSetLoginViewController {


    @FXML private TextField username_createUser;
    @FXML private TextField password_createUser;
    @FXML private TextField confirm_pass_createUser;
    @FXML private Label user_exists;
    @FXML private Label pass_matched;

    @FXML public void initialize(){

    }

    @FXML public void create_user(){

        boolean flag_usernameExists = false;
        if (username_createUser.getText().equalsIgnoreCase("") || password_createUser.getText().equalsIgnoreCase("") || confirm_pass_createUser.getText().equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Empty fields detected!!!", ButtonType.CLOSE);
            alert.showAndWait();
        }else{
            for (WarehouseAdmin w : DATA.list_of_warehouseAdmins){
                if (w.getUsername().equalsIgnoreCase(username_createUser.getText())){
                    flag_usernameExists = true;
                    user_exists.setText("Username already exists please \n" +
                            "Please choose a different username.");
                    break;
                }
            }

            if (!flag_usernameExists){
                user_exists.setText("");
                if (password_createUser.getText().equalsIgnoreCase(confirm_pass_createUser.getText())){
                    pass_matched.setText("");
                    if (DATA.create_new_user_selection == 1){
                        WarehouseAdmin w = new WarehouseAdmin(username_createUser.getText(), password_createUser.getText());
                        DATA.superStore.getList_of_warehouse_admins().add(w);
                    }else{
                        StoreAdmin w1 = new StoreAdmin(username_createUser.getText(), password_createUser.getText());
                        DATA.superStore.getList_of_store_admins().add(w1);
                    }

                    try{
                        Serialize(DATA.superStore, "src/Config.txt");
                    } catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    pass_matched.setText("Oops! password didn't match!");
                }
            }
        }
    }


    public void Serialize(SuperStore sa, String file) throws IOException {
        ObjectOutputStream oStream = null;

        try {
            oStream = new ObjectOutputStream(new FileOutputStream(file));
            oStream.writeObject(sa);
            System.out.println("Super Store Saved.");
        } finally {
            oStream.close();
        }
    }



}
