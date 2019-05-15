package controller;

import dao.PlayerEntity;
import dao.PlayerEntityDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.tinylog.Logger;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WellcomeSceneController implements Initializable{



    public static PlayerEntity playerEntity = new PlayerEntity();

    public static PlayerEntityDAOImpl playerEntityDAO = PlayerEntityDAOImpl.getPlayerEntityDAOImpl();

    public static String NAME;

    @FXML
    private Button quitButton;

    @FXML
    private Button gameButton;

    @FXML
    private TextField nameField;

    @FXML
    void GameButtonClick(ActionEvent event) throws IOException {

        NAME = nameField.getText();

        playerEntity = playerEntityDAO.findPlayerByName(NAME);

        if(playerEntity == null){
            playerEntity = new PlayerEntity();
            playerEntity.setName(NAME);
            playerEntity.setMoney(500);
            playerEntity.setLvl(1);
            playerEntity.setDmg(16);
            playerEntity.setCritical(8);
            playerEntity.setCriticalDmg(2);
            playerEntity.setResetCount(0);
            playerEntity.setAiDmg(20);
            playerEntityDAO.save(playerEntity);

            Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));
            Scene newGameViewScene = new Scene(newGameViewParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(newGameViewScene);
            window.show();

            Logger.info("Players's cararachter created!");

        }else{

            Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));
            Scene newGameViewScene = new Scene(newGameViewParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(newGameViewScene);
            window.show();

            Logger.info("Players's cararachter loaded!");
        }


    }

    @FXML
    void QuitClick(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    public void initialize(URL url, ResourceBundle rb){

    }
}
