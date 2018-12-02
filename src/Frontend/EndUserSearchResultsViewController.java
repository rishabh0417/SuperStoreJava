package Frontend;

import Backend.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class EndUserSearchResultsViewController {

    @FXML private ListView list_Products;
    @FXML private CheckBox checkbox_sort;
    @FXML TextField quant_text;

    List<Product> productList;
    List<Product> sorted_productList;
    ObservableList<Product> observer;
    Product selected_product;

public EndUserSearchResultsViewController(){
    System.out.println("EndUserSearchResultsViewController");
}

    @FXML public void initialize(){
        try{
            productList = DATA.store.store_inventory.search(DATA.string3);
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }


        sorted_productList = new LinkedList<>(productList);
        observer = FXCollections.observableList(productList);

        Collections.sort(sorted_productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        list_Products.setItems(observer);

        list_Products.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue observable, Product oldValue, Product newValue) {
                selected_product = newValue;
            }
        });

    }

    @FXML public void sorter(){
        if (checkbox_sort.isSelected()) observer = FXCollections.observableList(sorted_productList);
        else observer = FXCollections.observableList(productList);

        list_Products.setItems(observer);
    }

    @FXML public void add_to_cart(){
        try {
            int quantity = Integer.parseInt(quant_text.getText());
            if (quantity < 1) throw new Exception();
            DATA.current_cart.getList_of_items().put(selected_product, quantity);
        } catch (Exception e){
            e.printStackTrace();
            quant_text.setStyle("-fx-border-color : #ff0000");
        }

    }
}
