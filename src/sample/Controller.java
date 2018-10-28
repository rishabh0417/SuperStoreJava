package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

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

    public Controller(){}

    @FXML
    private void Clicked(){
        usr.setText("Login done");
    }

}
