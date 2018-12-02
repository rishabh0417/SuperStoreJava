package Frontend;

import Backend.FileWriter;
import Backend.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdatePopupController {

//    data fields.
    @FXML private TextField update_name;
    @FXML private TextField update_cost;
    @FXML private TextField update_quantity;
    @FXML private TextField update_D;
    @FXML private TextField update_H;
    @FXML private TextField update_K;
    @FXML private  TextField update_description;
    Product p;

    @FXML public void initialize(){
//        load existing data into the fields
        p = DATA.curr_prodcut;

        update_name.setText(p.getName());
        update_name.setDisable(true);

        update_cost.setText(Integer.toString(p.getCost()));
        update_quantity.setText(Integer.toString(p.getUnits()));
        update_D.setText(Integer.toString(p.getD()));
        update_H.setText(Integer.toString(p.getH()));
        update_K.setText(Integer.toString(p.getK()));
        update_description.setText(p.getDescription());


    }

    @FXML public void update_product(){


        try {
            p.setUnits(Integer.parseInt(update_quantity.getText()));
            p.setCost(Integer.parseInt(update_cost.getText()));
            p.setDescription(update_description.getText());
            p.setD(Integer.parseInt(update_D.getText()));
            p.setH(Integer.parseInt(update_H.getText()));
            p.setK(Integer.parseInt(update_K.getText()));

            FileWriter.Serialize(DATA.superStore);

            Stage stage = (Stage) update_description.getScene().getWindow();
            stage.close();
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
