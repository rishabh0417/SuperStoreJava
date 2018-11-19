package Frontend;

import Backend.FileWriter;
import Backend.SuperStore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main extends Application {

    public static Stage MainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        ObjectInputStream inputStream = null;
        SuperStore sa = null;

        try{
            inputStream = new ObjectInputStream(new FileInputStream("src/Config.txt"));
            sa = (SuperStore) inputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DATA data = new DATA();
        FileWriter fw = new FileWriter();


        DATA.superStore = sa;
        DATA.list_of_stores = sa.getList_of_store();
        DATA.list_of_warehouses = sa.getList_of_warehouse();
        DATA.list_of_warehouseAdmins = sa.getList_of_warehouse_admins();
        DATA.list_of_storeAdmins = sa.getList_of_store_admins();
        MainStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Welcome Super User");
        primaryStage.setScene(new Scene(root, 420, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
