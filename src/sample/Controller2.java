package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller2 {

    @FXML
    private Label userName;

    public Controller2(){
        System.out.println("second controller" +
                " ");
    }


    @FXML
    private void initialize(){
        userName.setText(Controller.name);
    }

    @FXML
    private void openCart(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserCartView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 650, 500));
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void addMoney(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserAddBudgetView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 300, 300));
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
