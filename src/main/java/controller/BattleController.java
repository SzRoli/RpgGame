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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modell.GameMaster;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class BattleController implements Initializable{

    private GameMaster gameMaster = new GameMaster();


    public PlayerEntityDAOImpl playerEntityDAO = PlayerEntityDAOImpl.getPlayerEntityDAOImpl();

    public static PlayerEntity playerEntity = WellcomeSceneController.playerEntityDAO.findPlayerbyName(WellcomeSceneController.NAME);



    int dmg = playerEntity.getDmg();
    int currentHp;
    double opaci = 1.0;
    int lvl = playerEntity.getLvl();
    int enemyHp;
    int yourDmg;
    int yourMaxHp = currentHp;
    int enemyMaxHp = enemyHp;

    @FXML
    private Button previousLvlButton;


    @FXML
    private ProgressBar hpBar;

    @FXML
    private Text enemyHpText;

    @FXML
    private Button backButton;

    @FXML
    private Button hitButton;

    @FXML
    private Text lvlText;

    @FXML
    void Hit(ActionEvent event) {
        attack();
    }

    @FXML
    void previousLvlButtonClick(ActionEvent event) {
        if(lvl>=2){
            opaci=1.0;
            hpBar.setProgress(opaci);
            enemyMaxHp-=400;
            enemyHp = enemyMaxHp;
            enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);
            lvl--;
            lvlText.setText(""+lvl);

        }
    }


    @FXML
    void backButtonClick(ActionEvent event) throws IOException {
        Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));
        Scene newGameViewScene = new Scene(newGameViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newGameViewScene);
        window.show();
    }

    void winCheck(int currentHp){
        if(currentHp <= 0){
            playerEntity.setMoney(playerEntity.getMoney()+50);
            enemyHp = enemyMaxHp + 400;
            enemyMaxHp = enemyHp;
            enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);
            lvl++;
            playerEntity.setLvl(lvl);
            lvlText.setText(""+lvl);
            playerEntityDAO.save(playerEntity);
        }
    }
    void attack() {

            hpBar.setProgress(opaci);
            enemyHp -= yourDmg;
            opaci = (double)enemyHp/enemyMaxHp;

            if(enemyMaxHp/1000>0){
                if(enemyHp/1000 > 0){
                    enemyHpText.setText(""+(double)enemyHp/1000+"K / "+(double)enemyMaxHp/1000+"K");
                }else{
                    enemyHpText.setText(""+enemyHp+" / "+(double)enemyMaxHp/1000+"K");
                }
            }else{
                enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);
            }



            winCheck(enemyHp);


    }

    public void initialize(URL url, ResourceBundle rb){
        lvlText.setText(""+lvl);

        enemyHp = 400 * lvl;
        enemyMaxHp=enemyHp;

        yourDmg = playerEntity.getDmg();

        enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);


    }
}
