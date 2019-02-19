package controller;

import dao.PlayerEntity;
import dao.PlayerEntityDAOImpl;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import modell.GameMaster;
import org.apache.derby.impl.sql.CursorInfo;
import sun.font.TextLabel;

import java.awt.*;
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
    private AnchorPane rootPane;

    @FXML
    private Text dmgText;
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
        makeFadeTrans(1,0);
    }
    private void loadNextScene(){
        try{
            Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));
            Scene newGameViewScene = new Scene(newGameViewParent);

            Stage window = (Stage) rootPane.getScene().getWindow();

            window.setScene(newGameViewScene);
            window.show();
        }catch(IOException ex){
            System.out.println("Nope! "+ex);
        }

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
                dmgText.setOpacity(0);
                dmgText.setFont(Font.font(42));
                dmgText.setFill(Color.ORANGE);
                //Point mouse = MouseInfo.getPointerInfo().getLocation();
                //System.out.println(mouse);
                //dmgText.setLayoutX(mouse.x);
                //dmgText.setLayoutY(mouse.y);

                dmgText.setText(""+yourDmg*playerEntity.getCriticalDmg()+" Hit");

                makeFadeTrandText();
            }else{
                enemyHp -= yourDmg;
                dmgText.setOpacity(0);
                dmgText.setFill(Color.RED);
                dmgText.setFont(Font.font(32));
                //Point mouse = MouseInfo.getPointerInfo().getLocation();
                //System.out.println(rootPane.getHeight() + "" + rootPane.getWidth());
                //dmgText.setLayoutX(rootPane.getWidth()+10);
                //dmgText.setLayoutY(rootPane.getHeight()-10);

                dmgText.setText(""+yourDmg+" Hit");


                makeFadeTrandText();
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
    private void makeFadeTrans(int start, int end){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(start);
        fadeTransition.setToValue(end);
        if(end < start){
            fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    loadNextScene();
                }
            });
        }
        fadeTransition.play();
    }
    private void makeFadeTrandText(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(dmgText);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }
    public void initialize(URL url, ResourceBundle rb){
        makeFadeTrans(0,1);
        lvlText.setText(""+lvl);
        yourMoney.setText(""+playerEntity.getMoney()+"G");
        enemyHp = 400 * lvl;
        enemyMaxHp=enemyHp;

        yourDmg = playerEntity.getDmg();

        enemyHpText.setText(""+enemyHp+" / "+enemyMaxHp);


    }
}
