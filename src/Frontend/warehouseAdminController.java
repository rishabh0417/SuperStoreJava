package Frontend;

import Backend.WarehouseAdmin;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class warehouseAdminController {

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

        }
        else{
            System.out.println("No, warehouse linked to this admin!!!");
        }
    }
}
