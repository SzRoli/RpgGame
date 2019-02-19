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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modell.GameMaster;
import sun.font.TextLabel;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class BattleController implements Initializable{

    private GameMaster gameMaster = new GameMaster();


    public PlayerEntityDAOImpl playerEntityDAO = PlayerEntityDAOImpl.getPlayerEntityDAOImpl();

    public static PlayerEntity playerEntity = WellcomeSceneController.playerEntityDAO.findPlayerByName(WellcomeSceneController.NAME);


    Random random = new Random();
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
    private TextField yourMoney;

    @FXML
    private ProgressBar hpBar;

    @FXML
    private Text enemyHpText;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

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
    void nextLvlButtonClick(ActionEvent event) {
        if(lvl<playerEntity.getLvl()){
            opaci=1.0;
            hpBar.setProgress(opaci);
            enemyMaxHp+=400;
            enemyHp = enemyMaxHp;
            enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);
            lvl++;
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
            playerEntity.setMoney((int)(playerEntity.getMoney()+(50*((double)lvl/2))*playerEntity.getResetCount()));
            enemyHp = enemyMaxHp + 400;
            enemyMaxHp = enemyHp;
            enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);
            lvl++;
            if(lvl>playerEntity.getLvl()){
                playerEntity.setLvl(lvl);
            }

            lvlText.setText(""+lvl);
            playerEntityDAO.save(playerEntity);
            yourMoney.setText(""+playerEntity.getMoney()+"G");
            opaci = (double)enemyHp/enemyMaxHp;
            hpBar.setProgress(opaci);
        }
    }
    void attack() {
            if(random.nextInt(100) <= playerEntity.getCritical()){
                enemyHp -= yourDmg*playerEntity.getCriticalDmg();
            }else{
                enemyHp -= yourDmg;
            }

            opaci = (double)enemyHp/enemyMaxHp;
            hpBar.setProgress(opaci);



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
        yourMoney.setText(""+playerEntity.getMoney()+"G");
        enemyHp = 400 * lvl;
        enemyMaxHp=enemyHp;

        yourDmg = playerEntity.getDmg();

        enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);


    }
}
