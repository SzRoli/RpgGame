package app;

import dao.DBManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


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

