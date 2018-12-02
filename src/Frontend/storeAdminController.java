package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class storeAdminController {

    @FXML private RadioButton radio_category_add;
    @FXML private RadioButton radio_product_add;


//    adding products/category to a particular store
    @FXML public void add_Items(){
        if (DATA.cur_storeAdmin != null) {
            if (radio_product_add.isSelected()) {
                try {
                    Stage stage = new Stage();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ProductsListSelector.fxml")), 600, 500));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (radio_category_add.isSelected()) {

                try {
                    Stage stage = new Stage();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("StoreAddNewCat.fxml")), 600, 500));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
