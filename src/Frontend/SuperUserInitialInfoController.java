package Frontend;

import Backend.Store;
import Backend.SuperStore;
import Backend.Warehouse;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SuperUserInitialInfoController {

   @FXML
   public ListView<Store> ListOfStores;

    @FXML
    public ListView<Warehouse> ListOfWarehouses;

    int x = 0;
    Warehouse wa;
    Store sa;

    @FXML
    private void initialize(){

        ListOfStores.setItems(FXCollections.observableList(DATA.list_of_stores));
        ListOfWarehouses.setItems(FXCollections.observableList(DATA.list_of_warehouses));

        ListOfStores.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Store>() {
            @Override
            public void changed(ObservableValue<? extends Store> observable, Store oldValue, Store newValue) {
                sa = newValue;
                x = 1;
                DATA.store = newValue;
            }
        });

        ListOfWarehouses.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Warehouse>() {
            @Override
            public void changed(ObservableValue<? extends Warehouse> observable, Warehouse oldValue, Warehouse newValue) {
                wa = newValue;
                x = 2;
                DATA.warehouse = newValue;
            }
        });


    }


    @FXML public void to_main_menu(){
        try{
            Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("superUser.fxml")) , 600, 500));
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }


    @FXML
    public void openFromSU(){

        if (x == 2) {
            DATA.currentCategory = DATA.warehouse.warehouse_inventory.getCategories().get("root");
            Parent root = null;
            try {
                Stage stage = new Stage();
                root = FXMLLoader.load(getClass().getResource("SuperUserBrowserView.fxml"));
                stage.setTitle("WareHouse value : ");
                stage.setScene(new Scene(root, 600, 500));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (x == 1){
            DATA.currentCategory = DATA.store.store_inventory.getCategories().get("root");
            Parent root = null;
            try {
                Stage stage = new Stage();
                root = FXMLLoader.load(getClass().getResource("SuperUserBrowserView.fxml"));
                stage.setTitle("Store value : ");
                stage.setScene(new Scene(root, 600, 500));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
