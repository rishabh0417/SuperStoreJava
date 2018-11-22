package Frontend;

import Backend.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddCategoryMenuViewController {


    @FXML private Button open_up_rec;
    @FXML private Button add_cat_rec;

    Category curr;

    @FXML
    private ListView list_categories;

    public AddCategoryMenuViewController(){

    }

    @FXML public void initialize(){
        System.out.println("here");
        Category curr_category = DATA.currentCategory;


        list_categories.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                DATA.currentCategoryString = newValue;
                DATA.currentCategory = curr_category.getSubCategory().get(DATA.currentCategoryString);
                System.out.println(DATA.path);
            }
        });

        List<String> mainList = new ArrayList<String>();
        mainList.addAll(curr_category.getSubCategory().keySet());
        list_categories.setItems(FXCollections.observableList(mainList));

    }

    @FXML public void open_next_cat(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCategoryMenuView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 650, 500));
            stage.show();
            DATA.path = DATA.path + ">" + DATA.currentCategoryString;

        } catch (IOException e){
            System.out.println(e.getStackTrace());
        }
    }

}