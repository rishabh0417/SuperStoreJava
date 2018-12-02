package Frontend;

import Backend.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;

public class SuperUserSetLoginViewController {

    @FXML private ChoiceBox dropdown_store;

    private Store str;
    private Warehouse wa;

    @FXML private TextField username_createUser;
    @FXML private TextField password_createUser;
    @FXML private TextField confirm_pass_createUser;
    @FXML private Label user_exists;
    @FXML private Label pass_matched;

    @FXML public void initialize(){
        if (DATA.create_new_user_selection == 1){
            dropdown_store.setItems(FXCollections.observableList(DATA.list_of_warehouses));
        } else{
            dropdown_store.setItems(FXCollections.observableList(DATA.list_of_stores));
        }

        dropdown_store.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                if (DATA.create_new_user_selection == 1){
                    wa = (Warehouse) newValue;
                }else {
                    str = (Store) newValue;
                }
            }
        });
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
                    user_exists.setText("Username already exists please \n" + "Please choose a different username.");
                    break;
                }
            }

            if (!flag_usernameExists){
                user_exists.setText("");
                if (password_createUser.getText().equalsIgnoreCase(confirm_pass_createUser.getText())){
                    pass_matched.setText("");
                    if (DATA.create_new_user_selection == 1){
                        WarehouseAdmin w = new WarehouseAdmin(username_createUser.getText(), password_createUser.getText());
                        w.setWarehouse(wa);
                        wa.myAdmin = w;
                        DATA.list_of_warehouseAdmins.add(w);
                    }else{
                        StoreAdmin w1 = new StoreAdmin(username_createUser.getText(), password_createUser.getText());
                        w1.setStore(str);
                        DATA.list_of_storeAdmins.add(w1);
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
// TODO : create dropdown for linking admins with their respective stores.


}
