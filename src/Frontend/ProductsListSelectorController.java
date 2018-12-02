package Frontend;

import Backend.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductsListSelectorController {

    @FXML private TextField input_quantity;

    @FXML
    private ListView list_updation;
    @FXML private CheckBox check_sort;

    @FXML public void select_product(){

        DATA.curr_prodcut = selected_product;

        try {
            int quant = Integer.parseInt(input_quantity.getText());
            if (quant > selected_product.getUnits()) throw new Exception();
            else{
                Product dupli = new Product(selected_product.getName());
                dupli.setUnits(quant);
                selected_product.setUnits( selected_product.getUnits() - quant);
            }

            Stage stage = new Stage();

            DATA.currentCategory = DATA.cur_storeAdmin.getStore().store_inventory.getCategories().get("root");
            DATA.currentCategoryString = "root";
            DATA.path = DATA.currentCategoryString;


                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("StoreAddItemMenu.fxml")), 600, 500));
                stage.show();

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please enter a possible quantity value");
            alert.showAndWait();
        }
    }

    List<Product> productList;
    List<Product> sorted_productList;

    ObservableList<Product> observer;

    Product selected_product;

    @FXML public void initialize(){

        try {
            productList = DATA.cur_storeAdmin.getStore().linked_warehouse.warehouse_inventory.getList_of_product_names();
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

}
