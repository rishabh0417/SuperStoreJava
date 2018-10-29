package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    static String name = "XXX";
    @FXML
    private Label userName;

    @FXML
    private TextField usr;

    @FXML
    private TextField pswd;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @FXML
    private void initialize(){}

    public Controller(){
        System.out.println("first controller" +
                " ");
    }

    @FXML
    private void Clicked(){
//        usr.setText("Login done");
        String s1 = usr.getText();
        try {
            Controller.name = s1;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserView.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("EndUserView.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 650, 500));
            Controller.name = s1;
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }


}