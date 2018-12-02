package Frontend;

import Backend.WarehouseAdmin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class warehouseAdminController {

    @FXML private Button button_add;
    @FXML private Label warehouse_welcome;
    @FXML private Label error_add_page;

    @FXML private RadioButton radio_product_add;
    @FXML private RadioButton radio_category_add;
    @FXML private RadioButton radio_update_product;
    @FXML private RadioButton radio_update_Category;

    WarehouseAdmin wa;

    @FXML private TextField update_name;

    @FXML public void initialize(){
        warehouse_welcome.setText("Hi, " + DATA.cur_warehouseAdmin.getUsername());
        wa = DATA.cur_warehouseAdmin;
    }

    @FXML public void add_objects(){
        if (wa.getWarehouse()!= null){
            if (radio_product_add.isSelected()){
                try {
                    Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("AddGUI.fxml")), 600, 500));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (radio_category_add.isSelected()){
                try {
                    Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("AddNewCategoryView.fxml")), 600, 500));
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

//TODO: category renaming time taking therefore will implement if time allows.
}
