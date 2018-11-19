package Frontend;

import Backend.FileWriter;
import Backend.Store;
import Backend.Warehouse;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

import java.io.IOException;

public class superUserController {

    @FXML private RadioButton radio_wareshouse_creation;
    @FXML private RadioButton radio_store_creation;
    @FXML private Label link_status;
    @FXML ComboBox<Store> dropdown_store;
    @FXML ComboBox<Warehouse> dropdown_warehouse;

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
        }else{
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
}