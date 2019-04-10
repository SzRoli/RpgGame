package app;

import dao.DBManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;


public class MainApp extends Application {


    private static final Logger LOGGER = LoggerFactory.getLogger(DBManager.class.getName());

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
            LOGGER.error("Connection error..");
        }finally{
            DB_MANAGER.disconnectDB();
        }


    }

}

