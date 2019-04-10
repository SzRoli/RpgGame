package controller;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import modell.Enemy;
import modell.Player;

import java.io.IOException;
import java.net.URL;

import java.util.Random;
import java.util.ResourceBundle;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BattleController implements Initializable{


    Player player = new Player(WellcomeSceneController.NAME);
    Enemy enemy = new Enemy();


    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    Random random = new Random();

    double opaci = 1.0;


    private static final String MEDIA_URL =
            "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

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
    private ImageView mobImage;
    @FXML
    void Hit(ActionEvent event) {
        attack();
    }

    @FXML
    void previousLvlButtonClick(ActionEvent event) {

        if(enemy.getLvl()>=2){
                opaci=1.0;
                hpBar.setProgress(opaci);
                enemy.setMaxHp(enemy.getMaxHp()-400);
                //enemyMaxHp-=400;
                enemy.setHp(enemy.getMaxHp());
                //enemyHp = enemyMaxHp;
                enemyHpText.setText(""+format(enemy.getHp())+" / "+format(enemy.getMaxHp()));
                enemy.setLvl(enemy.getLvl()-1);
                //lvl--;
                lvlText.setText(""+enemy.getLvl());

        }
    }

    @FXML
    void nextLvlButtonClick(ActionEvent event) {

                if (enemy.getLvl() < player.getLvl()) {

                        opaci = 1.0;
                        hpBar.setProgress(opaci);
                        enemy.setMaxHp(enemy.getMaxHp() + 400);
                        //enemyMaxHp+=400;
                        enemy.setHp(enemy.getMaxHp());
                        //enemyHp = enemyMaxHp;
                        enemyHpText.setText("" + format(enemy.getHp()) + " / " + format(enemy.getMaxHp()));
                        //lvl++;
                        enemy.setLvl(enemy.getLvl()+1);
                        lvlText.setText("" + enemy.getLvl());

                }

    }


    @FXML
    void backButtonClick(ActionEvent event) throws IOException {
        makeFadeTrans(1,0);
        try{
            exec.shutdown();
        }catch(Exception e){
            System.out.println(e);
        }


    }

    private void loadNextScene(){
        try{
            Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));
            Scene newGameViewScene = new Scene(newGameViewParent);

            Stage window = (Stage) rootPane.getScene().getWindow();

            window.setScene(newGameViewScene);
            window.show();
        }catch(IOException ex){
            System.out.println("Could open the next fxml! "+ex);
        }

    }
    void winCheck(int currentHp){

        if(currentHp <= 0){

            if(player.getResetCount()>0){
                player.setMoney((int)(player.getMoney()+(50*((double)enemy.getLvl()/2))*(player.getResetCount()+1)));
            }else{
                player.setMoney((int)(player.getMoney()+(50*((double)enemy.getLvl()/2))));
            }
            if(enemy.getLvl()!=player.getLvl()){
                try{
                    int random = (int )(Math.random() * 3 + 1);

                    System.out.println("Images/Mob"+random+".png");
                    Image image = new Image("Images/Mob"+random+".png");

                    mobImage.setImage(image);
                }catch(Exception e){
                    System.out.println("Could open the image file!: "+e);
                }

                enemy.setHp(enemy.getMaxHp());
                enemyHpText.setText(""+format(enemy.getHp())+" / "+format(enemy.getMaxHp()));
            }else{
                try{
                    int random = (int )(Math.random() * 3 + 1);

                    System.out.println("Images/Mob"+random+".png");
                    Image image = new Image("Images/Mob"+random+".png");

                    mobImage.setImage(image);
                }catch(Exception e){
                    System.out.println("Could open the image file!: "+e);
                }
                enemy.setHp(enemy.getMaxHp()+400);
                enemy.setMaxHp(enemy.getHp());
                enemyHpText.setText(""+format(enemy.getHp())+" / "+format(enemy.getMaxHp()));
                enemy.setLvl(enemy.getLvl()+1);
                if(enemy.getLvl()>player.getLvl()){
                    player.setLvl(enemy.getLvl());
                }
                lvlText.setText(""+enemy.getLvl());
            }

            yourMoney.setText(""+format(player.getMoney())+"G");
            if((double)enemy.getHp()/enemy.getMaxHp()>0){
                opaci = (double)enemy.getHp()/enemy.getMaxHp();
            }else{
                opaci = 0;
            }
            hpBar.setProgress(opaci);
            player.save();

        }
    }

    private void bossTimer(){

        System.out.println("boss: "+30+" s");

    }

    private String format(int number){
        double result = number;
        if(number/1000>0){
            return ""+result/1000+"k ";
        }
        return ""+result;
    }

    void attack() {


            if(random.nextInt(100) <= player.getCritical()){
                enemy.setHp(enemy.getHp()-player.getDmg()*player.getCriticalDmg());
                if((double)enemy.getHp()/enemy.getMaxHp()>0){
                    opaci = (double)enemy.getHp()/enemy.getMaxHp();
                }else{
                    opaci = 0;
                }
                dmgText.setOpacity(0);
                dmgText.setFont(Font.font(42));
                dmgText.setFill(Color.ORANGE);

                dmgText.setText(""+format(player.getDmg()*player.getCriticalDmg())+" Hit");

                makeFadeTrandText();
            }else{
                enemy.setHp(enemy.getHp()-player.getDmg());
                if((double)enemy.getHp()/enemy.getMaxHp()>0){
                    opaci = (double)enemy.getHp()/enemy.getMaxHp();
                }else{
                    opaci = 0;
                }
                dmgText.setOpacity(0);
                dmgText.setFill(Color.RED);
                dmgText.setFont(Font.font(32));

                dmgText.setText(""+format(player.getDmg())+" Hit");


                makeFadeTrandText();
            }

            opaci = (double)enemy.getHp()/enemy.getMaxHp();
            hpBar.setProgress(opaci);

            enemyHpText.setText(""+format(enemy.getHp())+" / "+format(enemy.getMaxHp()));

            winCheck(enemy.getHp());

    }
    void AiAttack(){

        enemy.setHp(enemy.getHp()-player.getAiDmg());
        if((double)enemy.getHp()/enemy.getMaxHp()>0){
            opaci = (double)enemy.getHp()/enemy.getMaxHp();
        }else{
            opaci = 0;
        }


        hpBar.setProgress(opaci);


        dmgText.setOpacity(0);
        dmgText.setFont(Font.font(42));
        dmgText.setFill(Color.BLUE);

        dmgText.setText(""+format(player.getAiDmg())+" Hit");

        makeFadeTrandText();



        enemyHpText.setText(""+format(enemy.getHp())+" / "+format(enemy.getMaxHp()));

        winCheck(enemy.getHp());
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
        enemy.setLvl(player.getLvl());
        Platform.setImplicitExit(false);

        exec.scheduleAtFixedRate(new Runnable() {

            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        AiAttack();
                    }
                });

            }
        }, 0, 500,  TimeUnit.MILLISECONDS);

        makeFadeTrans(0,1);
        lvlText.setText(""+enemy.getLvl());
        yourMoney.setText(""+format(player.getMoney())+"G");
        enemy.setHp(enemy.getLvl()*400);
        enemy.setMaxHp(enemy.getHp());

        enemyHpText.setText(""+format(enemy.getHp())+" / "+format(enemy.getMaxHp()));


    }
}
