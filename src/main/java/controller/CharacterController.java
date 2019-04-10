package controller;

import com.sun.org.apache.xerces.internal.dom.ParentNode;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import modell.Player;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class CharacterController implements Initializable {

    Player player = new Player(WellcomeSceneController.NAME);

    Random random = new Random();
    int randomNumber;
    double dmgGoldAmount = 5.1;
    double critChanceGoldAmount = 450;
    double critDmgGoldAmount = 11.1;
    double aiDmgGoldAmount = 4.1;

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
    private AnchorPane rootAnchorPane;

    @FXML
    private Button  aiDmgPlus;

    @FXML
    private TextField  aiDmgBarGold;

    @FXML
    private TextField aiDmgBar;

    @FXML
    void critChancePlusButtonClick(ActionEvent event) {

        player.critPlus(critChanceGoldAmount);

        setFields();

        if(player.getCritical()>=100){
            critChancePlus.setDisable(true);
        }
    }

    @FXML
    void critDmgPlusButtonClick(ActionEvent event) {

        player.critDmgPlus(critDmgGoldAmount);

        setFields();

    }
    @FXML
    void aiDmgPlusButtonClick(ActionEvent event) {

        player.aiDmgPlus(aiDmgGoldAmount);

        setFields();

    }
    @FXML
    void resetButtonClick(ActionEvent event) {

        player.statReset();

        setFields();

        critChancePlus.setDisable(false);

    }
    @FXML
    void PlayButtonClick(ActionEvent event) {
        if(player.getMoney() > 0 && player.getMoney() >= Integer.parseInt(yourMoney.getText()) &&
                number.getText() != null && Integer.parseInt(number.getText()) < 11 && Integer.parseInt(number.getText()) > 0){

            player.setMoney(player.getMoney()-Integer.parseInt(yourMoney.getText()));

            randomNumber = random.nextInt(10)+1;

            setFields();

            if(randomNumber == Integer.parseInt(number.getText())){
                player.setMoney(player.getMoney()+Integer.parseInt(yourMoney.getText()) * 10);

                setFields();

                youGet.setText("You win: " + format(Integer.parseInt(yourMoney.getText()) * 10)+"G");
            }else{
                youGet.setText("You Lose: " + format(Integer.parseInt(yourMoney.getText()))+"G");
            }
        }


    }



    @FXML
    void dmgPlusButtonClick(ActionEvent event) {

        player.dmgPlus(dmgGoldAmount);

        setFields();


    }

    @FXML
    void adventureButtonClick(ActionEvent event)throws IOException {
        makeFadeOut();


    }
    private void makeFadeOut(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootAnchorPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loadNextScene();
            }
        });
        fadeTransition.play();
    }

    private void loadNextScene(){

        try{
            Parent newGameViewParent = FXMLLoader.load(getClass().getResource("/fxml/Battle.fxml"));
            Scene newGameViewScene = new Scene(newGameViewParent);

            Stage window = (Stage) rootAnchorPane.getScene().getWindow();

            window.setScene(newGameViewScene);
            window.show();
        }catch(IOException ex){
            System.out.println("Nope! "+ex);
        }


    }
    private String format(int number){
        double result = number;
        if(number/1000>0){
            return ""+result/1000+"k ";
        }
        return ""+result;
    }
    void setFields(){
        if(player.getCritical()>=100){
            critChancePlus.setDisable(true);
        }
        aiDmgBar.setText(""+format(player.getAiDmg()));
        aiDmgBarGold.setText(""+format((int)(player.getAiDmg()*aiDmgGoldAmount))+"G");
        nameText.setText(player.getName());
        goldAmountField.setText(""+format(player.getMoney())+"G");
        dmgBar.setText(""+format(player.getDmg()));

        critChanceBar.setText(""+format(player.getCritical()));
        critDmgBar.setText(""+format(player.getCriticalDmg()));

        dmgBarGold.setText(""+ format((int)(player.getDmg() * dmgGoldAmount)) +"G");
        resetGold.setText(""+format(player.getResetCount()*100000+100000)+"G");
        critChanceBarGold.setText(""+format((int)(player.getCritical() * critChanceGoldAmount))+"G");
        critDmgBarGold.setText(""+format((int)(player.getCriticalDmg() * critDmgGoldAmount))+"G");

        player.save();
    }


    public void initialize(URL url, ResourceBundle rb){
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        Platform.setImplicitExit(false);

        exec.scheduleAtFixedRate(new Runnable() {

            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        goldAmountField.setText(""+format(player.getMoney())+"G");
                    }
                });

            }
        }, 0, 500, TimeUnit.MILLISECONDS);
        setFields();


    }
}
