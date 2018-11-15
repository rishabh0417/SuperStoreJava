package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController {

    static String name = "XXX";
    @FXML
    private Label userName;

    @FXML
    private TextField usr;

    @FXML
    private TextField pswd;

    @FXML
    private Label failStatus;

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

    public LoginViewController(){
        System.out.println("LoginViewController~");
    }

    @FXML
    private void Clicked(MouseEvent event) {

        if (DATA.isSuperUser) {
            if (usr.getText().equalsIgnoreCase("admin") && pswd.getText().equalsIgnoreCase("super")){
                try {
                    Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SUInitialInfo.fxml")), 600, 500));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                failStatus.setText("The Username or Password you \n entered is incorrect!");
            }
        } else {
            String s1 = usr.getText();
            try {
                LoginViewController.name = s1;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserView.fxml"));
                Parent root = FXMLLoader.load(getClass().getResource("EndUserView.fxml"));
//            Stage stage = new Stage();
                Main.MainStage.setScene(new Scene(root, 650, 500));
                LoginViewController.name = s1;
                Main.MainStage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


}