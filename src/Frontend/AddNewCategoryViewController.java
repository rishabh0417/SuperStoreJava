package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewCategoryViewController implements Initializable {

    @FXML public TextField input_cat_name;
    @FXML public Button button_add;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_add.setOnMouseClicked(event -> {
            String s = input_cat_name.getText();

            if (s.equals("")){
                input_cat_name.setStyle("-fx-border-color : #ff0000");
            }else {
                DATA.string1 = s;
                try {
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCategoryMenuView.fxml"));
                    Parent root = loader.load();

                    AddCategoryMenuViewController aa = loader.getController();
                    aa.setCat(DATA.cur_warehouseAdmin.getWarehouse().warehouse_inventory.getCategories().get("root"));

                    stage.setScene(new Scene(root, 650, 500));
                    stage.setTitle("Add to...");
                    stage.show();
                } catch (IOException e){
                    System.out.println(e + "ss");
                }
            }
        });
    }
}
