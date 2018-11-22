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

public class AddCategoryMenuViewController implements Initializable {

    Category curr_category;

    @FXML private Button open_up_rec;
    @FXML private Button add_cat_rec;

    @FXML
    private ListView list_categories;

    @FXML public void initialize(){
        ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> mainList = new ArrayList<>();
        mainList.addAll(curr_category.getSubCategory().keySet());

        System.out.println(curr_category.getSubCategory().keySet());
        list_categories.setItems(FXCollections.observableList(mainList));

        list_categories.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                curr_category = curr_category.getSubCategory().get(newValue);
            }
        });


        open_up_rec.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCategoryMenuView.fxml"));
                Parent root = loader.load();

                AddCategoryMenuViewController aa = loader.getController();
                aa.setCat(curr_category);

                Stage stage = new Stage();
                stage.setScene(new Scene(root, 650, 500));
                stage.show();

            } catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        });
    }

    public void setCat(Category cat){
        curr_category = cat;
    }
}
