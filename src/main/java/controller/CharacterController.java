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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modell.GameMaster;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class CharacterController implements Initializable {

    GameMaster gameMaster = new GameMaster();

    public PlayerEntityDAOImpl playerEntityDAO = PlayerEntityDAOImpl.getPlayerEntityDAOImpl();

    public static PlayerEntity playerEntity = WellcomeSceneController.playerEntityDAO.findPlayerByName(WellcomeSceneController.NAME);

    Random random = new Random();
    int randomNumber;
    double dmgGoldAmount = 10.1;
    double critChanceGoldAmount = 10.1;
    double critDmgGoldAmount = 10.1;

    @FXML
    private TextField dmgBar;

    @FXML
    private TextField dmgBarGold;

    @FXML
    private TextField nameText;

    @FXML
    private TextField goldAmountField;

    @FXML
    private Button dmgPlus;

    @FXML
    private TextField yourMoney;

    @FXML
    private TextField number;

    @FXML
    private TextField youGet;

    @FXML
    private TextField critChanceBarGold;

    @FXML
    private Button critDmgPlus;

    @FXML
    private TextField critDmgBar;

    @FXML
    private TextField critDmgBarGold;

    @FXML
    private Button critChancePlus;

    @FXML
    private TextField resetGold;

    @FXML
    private TextField critChanceBar;

    @FXML
    private Button resetButton;

    @FXML
    void critChancePlusButtonClick(ActionEvent event) {

        if((int)(playerEntity.getCritical()*critChanceGoldAmount) <= playerEntity.getMoney()){
            playerEntity.setMoney((playerEntity.getMoney()-(int)(playerEntity.getCritical()*critChanceGoldAmount)));

            playerEntity.setCritical(playerEntity.getCritical()+1);
            setFields();
            playerEntityDAO.save(playerEntity);
        }
        if(playerEntity.getCritical()>=100){
            critChancePlus.setDisable(true);
        }
    }

    @FXML
    void critDmgPlusButtonClick(ActionEvent event) {
        if((int)(playerEntity.getCriticalDmg()*critDmgGoldAmount) <= playerEntity.getMoney()){
            playerEntity.setMoney((playerEntity.getMoney()-(int)(playerEntity.getCriticalDmg()*critDmgGoldAmount)));
            playerEntity.setCriticalDmg(playerEntity.getCriticalDmg()+1);
            setFields();
            playerEntityDAO.save(playerEntity);
        }
    }

    @FXML
    void resetButtonClick(ActionEvent event) {
        if((playerEntity.getResetCount()*100+100) <= playerEntity.getMoney()){
            playerEntity.setResetCount(playerEntity.getResetCount()+1);
            playerEntity.setMoney((playerEntity.getMoney()-(int)(playerEntity.getResetCount()*100+100)));
            playerEntity.setCriticalDmg(2);
            playerEntity.setCritical(8);
            playerEntity.setLvl(1);
            playerEntity.setDmg(16);
            setFields();
            playerEntityDAO.save(playerEntity);
            critChancePlus.setDisable(false);
        }
    }
    @FXML
    void PlayButtonClick(ActionEvent event) {
        if(playerEntity.getMoney() > 0 && playerEntity.getMoney() >= Integer.parseInt(yourMoney.getText()) &&
                number.getText() != null && Integer.parseInt(number.getText()) < 11 && Integer.parseInt(number.getText()) > 0){
            playerEntity.setMoney(playerEntity.getMoney()-Integer.parseInt(yourMoney.getText()));
            randomNumber = random.nextInt(10)+1;
            setFields();
            if(randomNumber == Integer.parseInt(number.getText())){
                playerEntity.setMoney(playerEntity.getMoney()+Integer.parseInt(yourMoney.getText()) * 10);
                setFields();
                youGet.setText("You win: " + (Integer.parseInt(yourMoney.getText()) * 10));
            }else{
                youGet.setText("You Lose: " + (Integer.parseInt(yourMoney.getText())));
            }
        }


    }



    @FXML
    void dmgPlusButtonClick(ActionEvent event) {
        if((int)(playerEntity.getDmg()*dmgGoldAmount) <= playerEntity.getMoney()){
            playerEntity.setMoney((playerEntity.getMoney()-(int)(playerEntity.getDmg()*dmgGoldAmount)));

            playerEntity.setDmg(playerEntity.getDmg()+1);
            setFields();
            playerEntityDAO.save(playerEntity);
        }
    }



    @FXML
    void adventureButtonClick(ActionEvent event)throws IOException {

        Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Battle.fxml"));
        Scene newGameViewScene = new Scene(newGameViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newGameViewScene);
        window.show();

    }
    void setFields(){
        if(playerEntity.getCritical()>=100){
            critChancePlus.setDisable(true);
        }
        nameText.setText(playerEntity.getName());
        goldAmountField.setText(""+(playerEntity.getMoney())+"G");
        dmgBar.setText(""+(playerEntity.getDmg()));

        critChanceBar.setText(""+playerEntity.getCritical());
        critDmgBar.setText(""+playerEntity.getCriticalDmg());

        dmgBarGold.setText(""+ (int)(playerEntity.getDmg() * dmgGoldAmount) +"G");
        resetGold.setText(""+(100+playerEntity.getResetCount()*100));
        critChanceBarGold.setText(""+(int)(playerEntity.getCritical() * critChanceGoldAmount));
        critDmgBarGold.setText(""+(int)(playerEntity.getCriticalDmg() * critDmgGoldAmount));
    }


    public void initialize(URL url, ResourceBundle rb){
        setFields();


    }
}
