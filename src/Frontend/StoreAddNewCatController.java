package Frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreAddNewCatController {

    @FXML
    private Button add_cat;
    @FXML public TextField input_cat_name;

    public StoreAddNewCatController(){
        System.out.println("in add new");
    }

    @FXML public void clicked_add(){
        String s = input_cat_name.getText();

        if (s.equals("")){
            input_cat_name.setStyle("-fx-border-color : #ff0000");
        }else {
            DATA.string1 = s;
            try {
                DATA.currentCategory = DATA.cur_storeAdmin.getStore().store_inventory.getCategories().get("root");
                DATA.currentCategoryString = "root";
                DATA.path = DATA.currentCategoryString;

                FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreAddCategoryMenu.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 650, 500));
                stage.setTitle("Add to...");
                stage.show();
            } catch (IOException e){
                StackTraceElement elements[] = e.getStackTrace();
                for (int i = 1; i < elements.length; i++) {
                    StackTraceElement s1 = elements[i];
                    System.out.println("\tat " + s1.getClassName() + "." + s1.getMethodName()
                            + "(" + s1.getFileName() + ":" + s1.getLineNumber() + ")");
                }

                System.out.println(e.getMessage());
                System.out.println(e.getCause());

            }
        }
    }

}
