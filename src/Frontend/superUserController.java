package Frontend;

import Backend.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class superUserController {

    @FXML private TextField id_of_newUser;

    @FXML private RadioButton radio_wareshouse_creation;
    @FXML private RadioButton radio_store_creation;
    @FXML private Label link_status;
    @FXML private ComboBox<Store> dropdown_store;
    @FXML private ComboBox<Warehouse> dropdown_warehouse;
    @FXML private TextField search_input;
    @FXML private RadioButton radio_warehouse_search;
    @FXML private RadioButton radio_store_search;

    @FXML private RadioButton radio_del_warehouse;
    @FXML private RadioButton radio_del_warehouse_admin;
    @FXML private RadioButton radio_del_store;
    @FXML private RadioButton radio_del_store_admin;

    @FXML private RadioButton radio_warehouse_creation;
    @FXML private RadioButton radio_str_creation;

    @FXML private TextField del_input;
    @FXML private Label delete_status;



    private Store store_selected;
    private Warehouse warehouse_selected;

    @FXML
    public void initialize(){
            dropdown_store.setItems(FXCollections.observableList(DATA.list_of_stores));
            dropdown_warehouse.setItems(FXCollections.observableList(DATA.list_of_warehouses));

//            listeners for value change

        dropdown_store.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Store>() {
            @Override
            public void changed(ObservableValue<? extends Store> observable, Store oldValue, Store newValue) {
                store_selected = newValue;
            }
        });

        dropdown_warehouse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Warehouse>() {
            @Override
            public void changed(ObservableValue<? extends Warehouse> observable, Warehouse oldValue, Warehouse newValue) {
                warehouse_selected = newValue;
            }
        });
    }


    @FXML
    public void create_new_user(){

        if (radio_wareshouse_creation.isSelected()){
            DATA.create_new_user_selection = 1;

            try {
                Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SuperUserSetLoginView.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if (radio_store_creation.isSelected()){
            DATA.create_new_user_selection = 2;

            try {
                Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SuperUserSetLoginView.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if (radio_warehouse_creation.isSelected()){

            Warehouse w = new Warehouse();
            if (id_of_newUser.getText().equals("")){id_of_newUser.setStyle("-fx-border-color: #ff0000");}
            else {

                Boolean isDuplicate = false;

                for (Warehouse temp_ware : DATA.list_of_warehouses) {
                    if (temp_ware.toString().equals(id_of_newUser.getText())) {
                        Tooltip tp = new Tooltip("This userId already exists!");
                        Tooltip.install(id_of_newUser, tp);
                        isDuplicate = true;
                        break;
                    }
                }


                if (!isDuplicate) {
                    w.id = id_of_newUser.getText();
                    DATA.list_of_warehouses.add(w);

                    try {
                        w.warehouse_inventory.insert("root", new Product("default"));
                    } catch (Backend.ProductExistsException e) {
                        e.printStackTrace();
                    }

                    id_of_newUser.setStyle("-fx-border-color: #0000ff");

                    try {
                        FileWriter.Serialize(DATA.superStore);
                    } catch (IOException e) {
                        System.out.println(e.getStackTrace());
                    }
                }
                else{ id_of_newUser.setStyle("-fx-border-color: #ff0000");}
            }
        }else if (radio_str_creation.isSelected()){
            Store w = new Store();
            if (id_of_newUser.getText().equals("")){id_of_newUser.setStyle("-fx-border-color: #ff0000");}
            else {


                Boolean isDuplicate = false;

                for (Store temp_store : DATA.list_of_stores){
                    if (temp_store.getId().equals(id_of_newUser.getText())){
                        Tooltip tp = new Tooltip("This userId already exists!");
                        isDuplicate = true;
                        Tooltip.install(id_of_newUser, tp);
                        break;
                    }
                }
                if (!isDuplicate) {

                    w.id = id_of_newUser.getText();
                    DATA.list_of_stores.add(w);

                    try {
                        w.store_inventory.insert("root", new Product("default"));
                    } catch (Backend.ProductExistsException e) {
                        e.printStackTrace();
                    }
                    id_of_newUser.setStyle("-fx-border-color: #0000ff");

                    try {
                        FileWriter.Serialize(DATA.superStore);
                    } catch (IOException e) {
                        System.out.println(e.getStackTrace());
                    }
                }else { id_of_newUser.setStyle("-fx-border-color: #ff0000"); }
            }
        }
    }

    @FXML
    public void link_warehouse_store(){

        try {
            warehouse_selected.store_list.add(store_selected);
            store_selected.linked_warehouse = warehouse_selected;
            link_status.setText("Link Successful.");
            link_status.setTextFill(Color.valueOf("#0000ff"));
        } catch (Exception e){
            System.out.println("Null error");
            link_status.setText("Unable to link!");
            link_status.setTextFill(Color.valueOf("#ff0000"));
        }

        try {
            FileWriter.Serialize(DATA.superStore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void explore(){
        try {
            Stage stage = new Stage();
            stage.setTitle("Explore");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SuperUserInitialInfo.fxml"))));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void delete_user(){

        String id = del_input.getText();
        boolean found = false;

        if (id.equals("")) {
            delete_status.setTextFill(Color.valueOf("#ff0000"));
            delete_status.setText("Please Enter all the fields");
        }else {

            if (radio_del_store.isSelected()) {
                for (Store a : DATA.list_of_stores){
                    if (a.getId().equalsIgnoreCase(id)) {
                        found = true;
                        DATA.list_of_stores.remove(a);
                        break;
                    }
                }

            } else if (radio_del_store_admin.isSelected()) {
                for (StoreAdmin a : DATA.list_of_storeAdmins){
                    if (a.toString().equalsIgnoreCase(id)) {
                        found = true;
                        DATA.list_of_storeAdmins.remove(a);
                        break;
                    }
                }
            } else if (radio_del_warehouse.isSelected()) {
                for (Warehouse a : DATA.list_of_warehouses){
                    if (a.id.equalsIgnoreCase(id)) {
                        found = true;
                        DATA.list_of_warehouses.remove(a);
                        break;
                    }
                }
            } else if (radio_del_warehouse_admin.isSelected()) {
                for (WarehouseAdmin a : DATA.list_of_warehouseAdmins){
                    if (a.toString().equalsIgnoreCase(id)) {
                        found = true;
                        DATA.list_of_warehouseAdmins.remove(a);
                        break;
                    }
                }
            } else {
                delete_status.setTextFill(Color.valueOf("#ff0000"));
                delete_status.setText("Please select some option!");
            }
        }

        if (!found){
            delete_status.setTextFill(Color.valueOf("#ff0000"));
            delete_status.setText("ID/Username not found!");
        }else {
            delete_status.setTextFill(Color.valueOf("#0000ff"));
            delete_status.setText("Deletion Successful!");

            try {
                FileWriter.Serialize(DATA.superStore);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}