package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.io.IOException;

public class mainController {


    @FXML
    public void super_user_clicked(){
        DATA.isSuperUser = true;
        try {
            Scene s1 = new Scene(FXMLLoader.load(getClass().getResource("LoginView.fxml")), 600, 500);
            Main.MainStage.setScene(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
