package app;

import dao.DBManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {


    private static final DBManager DB_MANAGER = DBManager.getDpInstance();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/WelcomeScene.fxml"));

        Scene scene = new Scene(root);


        stage.setTitle("RPG");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            DB_MANAGER.connectDB();

            launch(args);
        }catch (Exception e){
            System.out.println("Connection error..");
        }finally{
            DB_MANAGER.disconnectDB();
        }


    }

}

