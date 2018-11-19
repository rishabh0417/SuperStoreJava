package Frontend;

import Backend.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class superUserController {

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
        }else if (radio_store_creation.isSelected()){
            DATA.create_new_user_selection = 2;
        }

        try {
            Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SuperUserSetLoginView.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
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
    public void search_storeWarehouse(){

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