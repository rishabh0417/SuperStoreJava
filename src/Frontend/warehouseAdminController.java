package Frontend;

import Backend.Warehouse;
import Backend.WarehouseAdmin;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class warehouseAdminController {

    @FXML private Button button_add;
    @FXML private Label warehouse_welcome;
    @FXML private Label error_add_page;

    @FXML private RadioButton radio_product_add;
    @FXML private RadioButton radio_category_add;
    @FXML private RadioButton radio_delete_product;
    @FXML private RadioButton radio_delete_Category;

    WarehouseAdmin wa;

    @FXML private TextField update_name;
    @FXML private TextField del_text;

    @FXML private ComboBox dropdown_warehouse;
    @FXML Warehouse cur_warehouse_for_search;
    @FXML private TextField other_search_text;

    @FXML public void initialize(){
        warehouse_welcome.setText("Hi, " + DATA.cur_warehouseAdmin.getUsername());
        wa = DATA.cur_warehouseAdmin;

        dropdown_warehouse.setItems(FXCollections.observableList(DATA.list_of_warehouses));

        dropdown_warehouse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Warehouse>() {
            @Override
            public void changed(ObservableValue observable, Warehouse oldValue, Warehouse newValue) {
                cur_warehouse_for_search = newValue;
            }
        });
    }

    @FXML public void add_objects(){
        if (wa.getWarehouse()!= null){
            if (radio_product_add.isSelected()){
                try {
                    Stage stage = new Stage();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AddGUI.fxml")), 600, 500);
//                    stage.setTitle("warehouse");
                    stage.setScene(scene);
                    stage.show();
//                    Main.MainStage.setScene());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (radio_category_add.isSelected()){
                try {

                    Stage stage = new Stage();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AddNewCategoryView.fxml")), 600, 500);
//                    stage.setTitle("warehouse");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            error_add_page.setTextFill(Color.valueOf("#ff0000"));
            error_add_page.setText("No, warehouse linked to this admin!!!");
        }
    }

    @FXML public void updateBtn(){
        DATA.string2 = update_name.getText();

        Stage stage = new Stage();
        stage.setTitle("Search Results");
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Update Search.fxml")), 700, 500));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.show();
    }

    @FXML public void del_search(){

        DATA.string2 = del_text.getText();

        if (radio_delete_Category.isSelected()){
            del_text.setDisable(true);

            DATA.currentCategory = DATA.cur_warehouseAdmin.getWarehouse().warehouse_inventory.getCategories().get("root");
            DATA.currentCategoryString = "root";
            DATA.path = DATA.currentCategoryString;


            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("delete pop up.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 650, 500));
                stage.setTitle("Delete...");
                stage.show();
            } catch (IOException e){
                System.out.println(e.getCause());
            }


        } else if (radio_delete_product.isSelected()){
            del_text.setDisable(false);
            Stage stage = new Stage();
            stage.setTitle("Search Results");
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("DeleteSearch.fxml")), 700, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }

            stage.show();
        }
    }

    @FXML public void other_searcher(){
        String s = other_search_text.getText();

        if (s.equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Empty values not permitted");
            alert.showAndWait();
        } else {

            DATA.string2 = s;
            DATA.warehouse = cur_warehouse_for_search;

            Stage stage = new Stage();
            stage.setTitle("Search Results");
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("WarehouseSearch.fxml")), 700, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }

            stage.show();

        }
    }

}
