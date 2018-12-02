package Frontend;

import Backend.FileWriter;
import Backend.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StoreDeleteSearchController {

    @FXML
    private ListView list_updation;
    @FXML private CheckBox check_sort;

    List<Product> productList;
    List<Product> sorted_productList;

    ObservableList<Product> observer;

    Product selected_product;

    @FXML public void initialize(){

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

        System.out.println(selected_product.getPath());
        try {
            DATA.cur_storeAdmin.getStore().store_inventory.delete(selected_product.getPath());
            FileWriter.Serialize(DATA.superStore);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
