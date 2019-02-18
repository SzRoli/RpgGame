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
    double hpGoldAmount = 0.1;
    double dmgGoldAmount = 10.1;
    double defGoldAmount = 10.1;
    double dogeGoldAmount = 10.1;


    @FXML
    private Text speaciesText;

    @FXML
    private TextField dmgBar;

    @FXML
    private Button dogePlus;

    @FXML
    private TextField dmgBarGold;

    @FXML
    private TextField hpBar;

    @FXML
    private Button hpPlus;

    @FXML
    private TextField nameText;

    @FXML
    private TextField defBar;

    @FXML
    private Text classText;

    @FXML
    private TextField hpBarGold;

    @FXML
    private Button defPlus;

    @FXML
    private ImageView speaciesPic;

    @FXML
    private ImageView classPic;

    @FXML
    private TextField goldAmountField;

    @FXML
    private Button dmgPlus;

    @FXML
    private TextField dogeBar;

    @FXML
    private TextField dogeBarGold;

    @FXML
    private TextField defBarGold;


    @FXML
    private TextField yourMoney;

    @FXML
    private TextField number;

    @FXML
    private TextField youGet;

    /*@FXML
    void PlayButtonClick(ActionEvent event) {
        if(gameMaster.getEntity().getMoney() > 0 && goldAmount >= Integer.parseInt(yourMoney.getText()) &&
                !number.getText().isEmpty() && Integer.parseInt(number.getText()) < 11 && Integer.parseInt(number.getText()) > 0){
            newGameController.goldAmount -= Integer.parseInt(yourMoney.getText());
            randomNumber = random.nextInt(10)+1;
            setFields();
            if(randomNumber == Integer.parseInt(number.getText())){
                newGameController.goldAmount += Integer.parseInt(yourMoney.getText()) * 10;
                setFields();
                youGet.setText("You win: " + (Integer.parseInt(yourMoney.getText()) * 10));
            }else{
                youGet.setText("You Lose: " + (Integer.parseInt(yourMoney.getText())));
            }
        }


    }*/

   /* @FXML
    void hpPlusButtonClick(ActionEvent event) {
        if(newGameController.goldAmount >=hpGoldAmount){
            newGameController.goldAmount -= hpGoldAmount;
            hpGoldAmount = (int)(hpGoldAmount* 1.1);
            newGameController.hp++;
            setFields();
        }

    }*/

   /* @FXML
    void dmgPlusButtonClick(ActionEvent event) {
        if(newGameController.goldAmount >=dmgGoldAmount) {
            newGameController.goldAmount -= dmgGoldAmount;
            dmgGoldAmount = (int) (dmgGoldAmount * 1.1);
            newGameController.dmg++;
            setFields();
        }
    }
*/
   /* @FXML
    void defPlusButtonClick(ActionEvent event) {
        if(newGameController.goldAmount >=defGoldAmount){
            newGameController.goldAmount -= defGoldAmount;
            defGoldAmount = (int) (defGoldAmount*1.1);
            newGameController.def++;
            setFields();
        }


    }*/

    @FXML
    void dogePlusButtonClick(ActionEvent event) {
        if((int)(playerEntity.getDoge()*dogeGoldAmount) <= playerEntity.getMoney()){
            playerEntity.setMoney((playerEntity.getMoney()-(int)(playerEntity.getDoge()*dogeGoldAmount)));

            playerEntity.setDoge(playerEntity.getDoge()+1);
            setFields();
            playerEntityDAO.save(playerEntity);
        }

    }

    /*@FXML
    void adventureButtonClick(ActionEvent event)throws IOException {

        Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Battle.fxml"));
        Scene newGameViewScene = new Scene(newGameViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newGameViewScene);
        window.show();

    }*/

   /* void setGolds(){
        hpGoldAmount = 25;
        dmgGoldAmount = 25;
        defGoldAmount = 25;
        dogeGoldAmount = 25;

    }*/
    void setPlayerEntity(){
        playerEntity.setName(playerEntityDAO.getPlayerName(WellcomeSceneController.NAME));
        playerEntity.setMoney(playerEntityDAO.getPlayerMoney(WellcomeSceneController.NAME));
        playerEntity.setHp(playerEntityDAO.getPlayerHp(WellcomeSceneController.NAME));
        playerEntity.setDmg(playerEntityDAO.getPlayerDmg(WellcomeSceneController.NAME));
    }
    void setFields(){
        nameText.setText(playerEntity.getName());
        goldAmountField.setText(""+(playerEntity.getMoney())+"G");
        dmgBar.setText(""+(playerEntity.getDmg()));
        hpBar.setText(""+(playerEntity.getHp()));
        defBar.setText(""+(playerEntity.getDef()));
        dogeBar.setText(""+(playerEntity.getDoge()));

        hpBarGold.setText(""+ (int)(playerEntity.getHp() * hpGoldAmount) +"G");
        dmgBarGold.setText(""+ (int)(playerEntity.getDmg() * dmgGoldAmount) +"G");
        defBarGold.setText(""+ (int)(playerEntity.getDef() * defGoldAmount) +"G");
        dogeBarGold.setText(""+ (int)(playerEntity.getDoge() * dogeGoldAmount) + "G");

        classText.setText(playerEntity.getClasses());
        speaciesText.setText(playerEntity.getSpeacies());

    }


    public void initialize(URL url, ResourceBundle rb){
        setPlayerEntity();
        setFields();


    }
}
