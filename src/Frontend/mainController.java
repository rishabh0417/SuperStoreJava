package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController {

    @FXML private AnchorPane su;
    @FXML private AnchorPane wa;
    @FXML private AnchorPane sa;


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

    @FXML
    public void warehouse_clicked(){
        open_warehouse();
    }

    @FXML
    public void store_clicked(){
        open_store();
    }

    @FXML
    public void endUser_clicked(){
        try {
            DATA.isEndUser = true;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserView.fxml"));
            Parent root = loader.load();
            Main.MainStage.setTitle("Guest");
            Main.MainStage.setScene(new Scene(root, 600, 500));

        } catch (IOException e){
            System.err.println(e);
        }
    }

    private void open_warehouse(){
        try {
            DATA.isWarehouseAdmin = true;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
            Parent root = loader.load();
            Main.MainStage.setTitle("Warehouse");
            Main.MainStage.setScene(new Scene(root, 500, 500));
        } catch (IOException e){
            System.err.println(e);
        }
    }

    private void open_store(){
        try {
            DATA.isStoreAdmin = true;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
            Parent root = loader.load();
            Main.MainStage.setTitle("Store");
            Main.MainStage.setScene(new Scene(root, 500, 500));

        } catch (IOException e){
            System.err.println(e);
        }
    }
}
