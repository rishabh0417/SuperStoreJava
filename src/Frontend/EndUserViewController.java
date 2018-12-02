package Frontend;

import Backend.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EndUserViewController {


    private Store current_store;
    @FXML private ChoiceBox choicebox_store;
    @FXML private TextField input_product;

    public EndUserViewController(){
        System.out.println("EndUserViewController" +
                " ");
    }


    @FXML
    private void initialize(){
        choicebox_store.setItems(FXCollections.observableList(DATA.list_of_stores));
        choicebox_store.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Store>() {
            @Override
            public void changed(ObservableValue observable, Store oldValue, Store newValue) {
                current_store = newValue;
            }
        });
    }

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


    @FXML
    private void storeBrowse(){

        DATA.store = current_store;
        try {

            DATA.currentCategory = DATA.store.store_inventory.getCategories().get("root");
            DATA.currentCategoryString = "root";
            DATA.path = DATA.currentCategoryString;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserStoreBrowserView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 650, 500));
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void itemSearch(){

        DATA.string3 = input_product.getText();
        DATA.store = current_store;

        if (current_store != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserSearchResultsView.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 650, 500));
                stage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            input_product.setStyle("-fx-border-color : #ff0000");
        }
    }
}
