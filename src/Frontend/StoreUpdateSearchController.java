package Frontend;

import Backend.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StoreUpdateSearchController {

    @FXML
    private ListView list_updation;
    @FXML private CheckBox check_sort;
    @FXML private Button next_button;

    List<Product> productList;
    List<Product> sorted_productList;

    ObservableList<Product> observer;

    Product selected_product;

    @FXML public void initialize(){
        if (DATA.flag1 == 1){
            next_button.setText("");
            next_button.setDisable(true);
        }

        try {
            productList = DATA.cur_storeAdmin.getStore().store_inventory.search(DATA.string2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sorted_productList = new LinkedList<>(productList);
        observer = FXCollections.observableList(productList);

        Collections.sort(sorted_productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        list_updation.setItems(observer);

        list_updation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue observable, Product oldValue, Product newValue) {
                selected_product = newValue;
            }
        });
    }

    @FXML public void sorter(){
        if (check_sort.isSelected()) observer = FXCollections.observableList(sorted_productList);
        else observer = FXCollections.observableList(productList);

        list_updation.setItems(observer);
    }

    @FXML public void next_clicked(){
        DATA.curr_prodcut = selected_product;

        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Update pop up.fxml")), 600, 500));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Edit");
        stage.show();


    }
}
