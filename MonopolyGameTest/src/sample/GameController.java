//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Random;

public class GameController implements Initializable{


    int totalDice;
    @FXML
    Label labelDice1;

    @FXML
    Label labelDice2;

    @FXML
    Button finishBtn;

    @FXML
    Button replayBtn;

    @FXML
    Button rollDiceBtn;

    @FXML
    void closeGame(){
        // to make operation on the stage
        Stage stage = (Stage) finishBtn.getScene().getWindow();
        // to close window
        stage.close();
    }

    @FXML
    //this method is to replay the game
    void replayGame(){

    }

    @FXML
    //this method is to roll dice
    void rollDice(){
        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);
        totalDice = dice1 + dice2;
        labelDice1.setText("Dice 1: "+dice1);
        labelDice2.setText("Dice 2: "+dice2);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
