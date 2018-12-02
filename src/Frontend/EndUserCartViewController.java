package Frontend;

import Backend.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.util.*;

public class EndUserCartViewController {

    Product selected_product;

    List<Product> mainList;

    @FXML
    private ListView disp_cart;

    @FXML private TextField quant;

    @FXML public void initialize(){
        List<Product> mainList = new ArrayList<Product>();

        if (DATA.current_cart != null){

            mainList.addAll(DATA.current_cart.getList_of_items().keySet());
            disp_cart.setItems(FXCollections.observableList(mainList));
        }

        disp_cart.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue observable, Product oldValue, Product newValue) {
                selected_product = newValue;
                quant.setText(DATA.current_cart.getList_of_items().get(selected_product).toString());
                if (selected_product.getUnits() - DATA.current_cart.getList_of_items().get(selected_product) < 0) quant.setStyle("-fx-border-color : #ff0000");
                else quant.setStyle("-fx-border-color : #0000ff");
            }
        });


    }


    @FXML public void update(){
        if (Integer.parseInt(quant.getText()) > 0)
            DATA.current_cart.getList_of_items().put(selected_product, Integer.parseInt(quant.getText()));
    }

    @FXML public void remove(){
        DATA.current_cart.getList_of_items().remove(selected_product);
        disp_cart.setItems(FXCollections.observableList(mainList));
    }

    @FXML public void checkout(){
        int flag = 0 ;
        for (Product p : DATA.current_cart.getList_of_items().keySet()){
            int abc = p.getUnits() - DATA.current_cart.getList_of_items().get(p);
            if (abc < 0) {
                flag = 1;
                break;
            }
        }

        if (flag == 1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Out of Stock! Please update the quantities");
            alert.showAndWait();
        } else{
            for (Product p : DATA.current_cart.getList_of_items().keySet()){
                int abc = p.getUnits() - DATA.current_cart.getList_of_items().get(p);
                p.setUnits(abc);
                DATA.current_cart.getList_of_items().remove(p);
            }
        }
    }

}
