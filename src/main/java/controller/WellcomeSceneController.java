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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
    void NewGameClick(ActionEvent event) throws IOException {
        Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/NewGame.fxml"));
        Scene newGameViewScene = new Scene(newGameViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newGameViewScene);
        window.show();
    }
    @FXML
    void GameButtonClick(ActionEvent event) throws IOException {

        NAME = nameField.getText();

        playerEntity = playerEntityDAO.findPlayerbyName(NAME);

        if(playerEntity == null){
            playerEntity = new PlayerEntity();
            playerEntity.setName(NAME);

            playerEntityDAO.save(playerEntity);

            Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/NewGame.fxml"));
            Scene newGameViewScene = new Scene(newGameViewParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(newGameViewScene);
            window.show();



        }else{
            Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));
            Scene newGameViewScene = new Scene(newGameViewParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(newGameViewScene);
            window.show();
        }


    }
    @FXML
    void QuitClick(ActionEvent event) {

    }

    public void initialize(URL url, ResourceBundle rb){

    }
}
