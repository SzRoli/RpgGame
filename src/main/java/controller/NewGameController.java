package controller;

import dao.PlayerEntity;
import dao.PlayerEntityDAOImpl;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import modell.GameMaster;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

    GameMaster gameMaster = new GameMaster();

    public PlayerEntityDAOImpl playerEntityDAO = PlayerEntityDAOImpl.getPlayerEntityDAOImpl();

    public static PlayerEntity playerEntity = WellcomeSceneController.playerEntityDAO.findPlayerbyName(WellcomeSceneController.NAME);



   /* public static  int hp;
    public static  int dmg;
    public static  int def;
    public static  int doge;
    public static  String name;
    public static  String gender;
    public static  String classe;
    public static  String speacies;
    public static int goldAmount;*/

    @FXML
    private RadioButton womanBox;

    @FXML
    private RadioButton man2Box;

    @FXML
    private RadioButton man3Box;

    @FXML
    private ToggleGroup ChosseSpecies;

    @FXML
    private RadioButton man4Box;

    @FXML
    private Button createButton;

    @FXML
    private RadioButton manBox;

    @FXML
    private RadioButton woman2Box;

    @FXML
    private RadioButton woman3Box;

    @FXML
    private RadioButton woman4Box;


    @FXML
    private RadioButton rougeCheckBox;

    @FXML
    private RadioButton shielderCheckBox;

    @FXML
    private RadioButton wizzardCheckBox;

    @FXML
    private RadioButton warriorCheckBox;

    @FXML
    private ToggleGroup ChosseClass;

    void speaciesCheck(){

        if(manBox.isSelected()){

            playerEntity.setSpeacies("Human");
            playerEntity.setGender("Man");

        }

        if(man2Box.isSelected()){
            playerEntity.setSpeacies("Orc");
            playerEntity.setGender("Man");

        }
        if(man3Box.isSelected()){
            playerEntity.setSpeacies("Elf");
            playerEntity.setGender("Man");

        }
        if(man4Box.isSelected()){

            playerEntity.setSpeacies("Goblin");
            playerEntity.setGender("Man");

        }
        if(womanBox.isSelected()){
            playerEntity.setSpeacies("Human");
            playerEntity.setGender("Woman");

        }
        if(woman2Box.isSelected()){
            playerEntity.setSpeacies("Orc");
            playerEntity.setGender("Woman");

        }
        if(woman3Box.isSelected()){
            playerEntity.setSpeacies("Elf");
            playerEntity.setGender("Woman");

        }
        if(woman4Box.isSelected()){
            playerEntity.setSpeacies("Goblin");
            playerEntity.setGender("Woman");

        }
    }

    void classCheck(){

        if(warriorCheckBox.isSelected()){
            playerEntity.setMoney(500);
            playerEntity.setClasses("Warrior");
            playerEntity.setDmg(16);

        }

        if(shielderCheckBox.isSelected()){
            playerEntity.setMoney(500);
            playerEntity.setClasses("Shielder");
            playerEntity.setDmg(5);

        }

        if(rougeCheckBox.isSelected()){
            playerEntity.setMoney(500);
            playerEntity.setClasses("Rouge");
            playerEntity.setDmg(5);

        }
        if(wizzardCheckBox.isSelected()){
            playerEntity.setMoney(500);
            playerEntity.setClasses("Wizzard");
            playerEntity.setDmg(16);

        }

    }


    @FXML
    void CreateButtonAction(ActionEvent event) throws Exception {

        classCheck();
        speaciesCheck();
        playerEntityDAO.save(playerEntity);


        Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));
        Scene newGameViewScene = new Scene(newGameViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newGameViewScene);
        window.show();
    }


    public void initialize(URL url, ResourceBundle rb){




    }
}
