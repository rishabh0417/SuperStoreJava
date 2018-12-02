package Frontend;

import Backend.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EndUserStoreBrowserViewController {

    private String current_instance;

    Stage stage;
    Category curr;

    @FXML
    private Button btn_opn;
    @FXML private ListView list_display;

    @FXML public void initialize(){
        stage = new Stage();
        System.out.println("here");
        Category curr_category = DATA.currentCategory;

        list_display.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                DATA.currentCategoryString = newValue;
                DATA.currentCategory = curr_category.getSubCategory().get(DATA.currentCategoryString);
//                Product exists in it and not a category so disable the button

                if (DATA.currentCategory.getProduct() != null) btn_opn.setDisable(true);

//                System.out.println(DATA.path);
                current_instance = DATA.path;
            }
        });

        List<String> mainList = new ArrayList<String>();
        mainList.addAll(curr_category.getSubCategory().keySet());
        list_display.setItems(FXCollections.observableList(mainList));

    }

    //    called upon adding the product
    @FXML public void open_prod(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EndUserStoreBrowserView.fxml"));
            Parent root = loader.load();
            stage = new Stage();
            stage.setScene(new Scene(root, 650, 500));
            stage.show();
            DATA.path = DATA.path + ">" + DATA.currentCategoryString;

            System.out.println(DATA.path);

            stage.setOnCloseRequest(event -> {
                DATA.path = current_instance;
                System.out.println("Windows has been closed.");
            });

        } catch (IOException e){
            System.out.println(e.getStackTrace());
        }
    }

}
