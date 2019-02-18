/*package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modell.GameMaster;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class BattleController implements Initializable{

    private GameMaster gameMaster = new GameMaster();

    //NewGameController newGameController = new NewGameController();

    int dmg = gameMaster.playerEntityDAO.getPlayerDmg();
    Random random = new Random();
    int currentHp;

    int enemyHp;
    int dogeRate;
    int yourDmg;
    int enemyDmg;
    int yourMaxHp = currentHp;
    int enemyMaxHp = enemyHp;
    @FXML
    private TextArea textArea;

    @FXML
    private Text enemyHpText;

    @FXML
    private Text yourHpText;

    @FXML
    private Button backButton;



    @FXML
    void backButtonClick(ActionEvent event) throws IOException {
        Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));
        Scene newGameViewScene = new Scene(newGameViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newGameViewScene);
        window.show();
    }

    void winCheck(int currentHp){
        if(currentHp > 0){
            newGameController.goldAmount += 50;
        }
    }
    void battle() {
        currentHp = newGameController.hp;
        enemyHp = newGameController.hp/2;

        yourMaxHp=currentHp;
        enemyMaxHp=enemyHp;

        yourDmg = newGameController.dmg;


        while(currentHp > 0 && enemyHp > 0){

            yourHpText.setText(""+currentHp+" / "+yourMaxHp);
            textArea.setText(textArea.getText() + "Attack: " +yourDmg + "\n");
            enemyHp -= yourDmg;
            enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);


            enemyDmg = random.nextInt(26);
            enemyDmg -= newGameController.def;
            dogeRate = random.nextInt(newGameController.doge);
            if(dogeRate >= 8){
                textArea.setText(textArea.getText() + "Enemy hit! Miss! \n");
            }else if(enemyDmg <=0){
                textArea.setText(textArea.getText() + "Enemy hit! Block! \n");

            }else{
                textArea.setText(textArea.getText() + "Enemy hit: " + enemyDmg + "\n");
                currentHp -=enemyDmg;
            }


        }
        winCheck(currentHp);
    }

    public void initialize(URL url, ResourceBundle rb){
        battle();
    }
}
*/