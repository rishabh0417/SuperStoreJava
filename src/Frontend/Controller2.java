package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Used by end user
 */
public class Controller2 {

    @FXML
    private Label userName;

    public Controller2(){
        System.out.println("second controller" +
                " ");
    }


    @FXML
    private void initialize(){
        userName.setText(LoginViewController.name);
    }

    /**
     * opens end user cart
     */
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

    /**
     * used to add money
     */
    @FXML
    private void addMoney(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserAddBudgetView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 300, 200));
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * used to browse the store
     */
    @FXML
    private void storeBrowse(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserStoreBrowserView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 650, 500));
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Used to search products.
     */
    @FXML
    private void itemSearch(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserSearchResultsView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 650, 500));
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
