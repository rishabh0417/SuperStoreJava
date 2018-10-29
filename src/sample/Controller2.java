package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
}
