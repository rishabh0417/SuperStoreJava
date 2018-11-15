package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class mainController {


    @FXML
    public void super_user_clicked(){
        DATA.isSuperUser = true;
        try {
            Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("LoginView.fxml")), 600, 500));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
