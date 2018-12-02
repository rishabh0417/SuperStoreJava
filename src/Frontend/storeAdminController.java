package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class storeAdminController {

    @FXML private RadioButton radio_category_add;
    @FXML private RadioButton radio_product_add;

    @FXML private RadioButton radio_delete_product;
    @FXML private RadioButton radio_delete_Category;
    @FXML private TextField del_text;


    @FXML private TextField update_text;

    @FXML public void store_del_items(){
        DATA.string2 = del_text.getText();


        if (radio_delete_Category.isSelected()) {
            DATA.currentCategory = DATA.cur_storeAdmin.getStore().store_inventory.getCategories().get("root");
            DATA.currentCategoryString = "root";
            DATA.path = DATA.currentCategoryString;


            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreDelete.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 650, 500));
                stage.setTitle("Delete...");
                stage.show();
            } catch (IOException e) {
                System.out.println(e.getCause());
            }
        } else if (radio_delete_product.isSelected()){
            del_text.setDisable(false);
            Stage stage = new Stage();
            stage.setTitle("Search Results");
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("StoreDeleteSearch.fxml")), 700, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }

            stage.show();
        }

    }


    @FXML public void update_btn_store(){
        DATA.string2 = update_text.getText();

        Stage stage = new Stage();
        stage.setTitle("Search Results");
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("StoreUpdateSearch.fxml")), 700, 500));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.show();
    }


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
