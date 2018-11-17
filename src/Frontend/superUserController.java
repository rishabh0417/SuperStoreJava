package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;

import java.io.IOException;

public class superUserController {

    @FXML private RadioButton radio_wareshouse_creation;
    @FXML private RadioButton radio_store_creation;

    @FXML
    public void create_new_user(){

        if (radio_wareshouse_creation.isSelected()){
            DATA.create_new_user_selection = 1;
        }else{
            DATA.create_new_user_selection = 2;
        }

        try {
            Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SuperUserSetLoginView.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}