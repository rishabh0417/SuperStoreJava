package Frontend;

import Backend.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddGUIController {

//    DATA fields.
    @FXML private TextField name;
    @FXML private TextField cost;
    @FXML private TextField quantity;
    @FXML private TextField D;
    @FXML private TextField H;
    @FXML private TextField K;
    @FXML private TextArea description;


    @FXML public void open_Items(){

        String get_name = name.getText();
        String get_cost = cost.getText();
        String get_quantity = quantity.getText();
        String get_D = D.getText();
        String get_H = H.getText();
        String get_K = K.getText();
        String get_description = description.getText();

        try{
            DATA.currentCategory = DATA.cur_warehouseAdmin.getWarehouse().warehouse_inventory.getCategories().get("root");
            DATA.currentCategoryString = "root";
            DATA.path = DATA.currentCategoryString;


            Product p = new Product(get_name);
            p.setUnits(Integer.parseInt(get_quantity));
            p.setCost(Integer.parseInt(get_cost));
            p.setDescription(get_description);
            p.setD(Integer.parseInt(get_D));
            p.setH(Integer.parseInt(get_H));
            p.setK(Integer.parseInt(get_K));

            DATA.curr_prodcut = p;

            Stage new_stage = new Stage();
            new_stage.setTitle("Select Category");
            new_stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("AddItemMenuView.fxml")), 600, 500));
            new_stage.show();

//            close the current window if Successful.
//            Stage stage = (Stage) name.getScene().getWindow();
//            stage.close();

        } catch (Exception e){

            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter correct values in the respective ");

            alert.showAndWait();
        }


    }
}
