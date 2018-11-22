package Frontend;

import Backend.WarehouseAdmin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import java.io.IOException;

public class warehouseAdminController {

    @FXML private Button button_add;
    @FXML private Label warehouse_welcome;
    @FXML private Label error_add_page;

    @FXML private RadioButton radio_product_add;
    @FXML private RadioButton radio_category_add;

    WarehouseAdmin wa;

    @FXML public void initialize(){
        warehouse_welcome.setText("Hi, " + DATA.cur_warehouseAdmin.getUsername());
        wa = DATA.cur_warehouseAdmin;
    }

    @FXML public void add_objects(){
        if (wa.getWarehouse()!= null){
            if (radio_product_add.isSelected()){

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


}
