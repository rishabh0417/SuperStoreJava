package Frontend;

import Backend.StoreAdmin;
import Backend.WarehouseAdmin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginViewController {

    static String name = "XXX";

    int data;

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



    public LoginViewController(){
        System.out.println("LoginViewController~");
    }

    @FXML
    private void Clicked(MouseEvent event) {

        if (DATA.isSuperUser) {
            if (usr.getText().equalsIgnoreCase("admin") && pswd.getText().equalsIgnoreCase("super")){
                try {
                    Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SuperUserInitialInfo.fxml")), 600, 500));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                failStatus.setText("The Username or Password you \n entered is incorrect!");
            }
        } else if (DATA.isWarehouseAdmin){
            boolean flag= false;

            for (WarehouseAdmin a : DATA.list_of_warehouseAdmins){
                if (usr.getText().equalsIgnoreCase(a.getUsername()) && pswd.getText().equalsIgnoreCase(a.getPassword())){
                    DATA.cur_warehouseAdmin = a;
                    flag = true;
                    break;
                }
            }

            if (!flag){
                failStatus.setText("The Username or Password you \n entered is incorrect!");
            }else{
                failStatus.setText("");
                try {
                    Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("warehouseAdmin.fxml")), 600, 500));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (DATA.isStoreAdmin){

            boolean flag = false;

            for (StoreAdmin a : DATA.list_of_storeAdmins){
                if (usr.getText().equalsIgnoreCase(a.username) && pswd.getText().equalsIgnoreCase(a.password)){
                    DATA.cur_storeAdmin = a;
                    flag = true;
                    break;
                }
            }

            if (!flag){
                failStatus.setText("The Username or Password you \n entered is incorrect!");
            }else{
                failStatus.setText("");
                try {
                    Main.MainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("storeAdmin.fxml")), 600, 500));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}