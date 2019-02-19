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

    public static PlayerEntity playerEntity = WellcomeSceneController.playerEntityDAO.findPlayerbyName(WellcomeSceneController.NAME);

    Random random = new Random();
    int randomNumber;
    double hpGoldAmount = 0.1546;
    double dmgGoldAmount = 10.1;
    double defGoldAmount = 10.1;
    double dogeGoldAmount = 10.1;


    @FXML
    private Text speaciesText;

    @FXML
    private TextField dmgBar;


    @FXML
    private TextField dmgBarGold;



    @FXML
    private TextField nameText;



    @FXML
    private Text classText;





    @FXML
    private ImageView speaciesPic;

    @FXML
    private ImageView classPic;

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

    void setPlayerEntity(){
        playerEntity.setName(playerEntityDAO.getPlayerName(WellcomeSceneController.NAME));
        playerEntity.setMoney(playerEntityDAO.getPlayerMoney(WellcomeSceneController.NAME));
        playerEntity.setDmg(playerEntityDAO.getPlayerDmg(WellcomeSceneController.NAME));
    }
    void setFields(){
        nameText.setText(playerEntity.getName());
        goldAmountField.setText(""+(playerEntity.getMoney())+"G");
        dmgBar.setText(""+(playerEntity.getDmg()));



        dmgBarGold.setText(""+ (int)(playerEntity.getDmg() * dmgGoldAmount) +"G");


        classText.setText(playerEntity.getClasses());
        speaciesText.setText(playerEntity.getSpeacies());

    }


    public void initialize(URL url, ResourceBundle rb){
        setPlayerEntity();
        setFields();


    }
}
