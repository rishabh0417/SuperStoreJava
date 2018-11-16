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


    @FXML
    private void initialize(){

        ObjectInputStream inputStream = null;
        SuperStore sa = null;

        try{
            inputStream = new ObjectInputStream(new FileInputStream("src/Config.txt"));
            sa = (SuperStore) inputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DATA.list_of_stores = sa.getList_of_store();
        DATA.list_of_warehouses = sa.getList_of_warehouse();

        ListOfStores.setItems(FXCollections.observableList(DATA.list_of_stores));
        ListOfWarehouses.setItems(FXCollections.observableList(DATA.list_of_warehouses));

        ListOfStores.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Store>() {
            @Override
            public void changed(ObservableValue<? extends Store> observable, Store oldValue, Store newValue) {
                DATA.store = newValue;
            }
        });

        ListOfWarehouses.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Warehouse>() {
            @Override
            public void changed(ObservableValue<? extends Warehouse> observable, Warehouse oldValue, Warehouse newValue) {
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

        DATA.currentCategory = DATA.warehouse.warehouse_inventory.getCategories().get("root") ;
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

    }

}
