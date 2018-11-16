package Frontend;

import Backend.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuperUserBrowserViewController {

    @FXML
    private ListView browse_results;

    @FXML
    public void initialize(){
        Category cat = DATA.currentCategory;
        browse_results.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                DATA.currentCategoryString = newValue;
                DATA.currentCategory = cat.getSubCategory().get(DATA.currentCategoryString);
            }
        });

        List<String> mainList = new ArrayList<String>();
        mainList.addAll(cat.getSubCategory().keySet());
        browse_results.setItems(FXCollections.observableList(mainList));
    }

    @FXML
    public void open_button(){
        Parent root = null;
        try {

            Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("SuperUserBrowserView.fxml"));
            stage.setTitle("=== WareHouse ===");
            stage.setScene(new Scene(root, 600, 500));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }