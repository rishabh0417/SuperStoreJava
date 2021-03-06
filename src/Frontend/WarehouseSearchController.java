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

/**
 * Used to search for products and categories in the wareHose under the admin.
 */
public class WarehouseSearchController {


    @FXML
    private ListView list_updation;
    @FXML private CheckBox check_sort;

    List<Product> productList;
    List<Product> sorted_productList;

    ObservableList<Product> observer;

    Product selected_product;

    @FXML public void initialize(){

        try {
            productList = DATA.warehouse.warehouse_inventory.search(DATA.string2);
//            System.out.println(DATA.string2);
//            System.out.println(productList);
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

    /**
     * Used when the admin wants to sort the search results.
     */
    @FXML public void sorter(){
        if (check_sort.isSelected()) observer = FXCollections.observableList(sorted_productList);
        else observer = FXCollections.observableList(productList);

        list_updation.setItems(observer);
    }

}