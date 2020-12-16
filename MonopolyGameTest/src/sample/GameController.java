//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController implements Initializable{




    ArrayList<Token> tokens;
    ArrayList<Player> names;

    //Array List that contains player objects


    public void initial(ArrayList<Player> names, ArrayList<Token> tokens) {
        this.names = names;
        this.tokens = tokens;

    }




    //Chance cards
    CardDecorator card1 = new AlienAttack(new ChanceCard(1));
    CardDecorator card2 = new PutJail(new ChanceCard(2));
    CardDecorator card3 = new ChangeBankAccount(new ChanceCard(3));
    CardDecorator card4 = new ChangePosition(new ChanceCard(4));
    CardDecorator card5 = new ChangePosition(new ChangeBankAccount(new ChanceCard(5)));


    String cardDuty = card1.getContent();
    int totalDice;

    //turn number
    //if there are 4 players turns is between 0-3
    int turn = 0;
    Player currentPlayer;


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
    Button chanceBtn;
    @FXML
    Button chestBtn;

    //buttons and labels on Card window
    @FXML
    Button okInCard;

    @FXML
    Label titleOnCard;

    @FXML
    Label dutyLabel;
    //end of buttons and labels on Card window

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
    int rollDice(){
        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);
        totalDice = dice1 + dice2;
        labelDice1.setText("Dice 1 : "+dice1);
        labelDice2.setText("Dice 2 : "+dice2);
        currentPlayer = names.get(turn);
        int updatedPosition = currentPlayer.getPosition() + totalDice;
        currentPlayer.setPosition(updatedPosition);
        turn = (turn + 1) % names.size();
        for(int i = 0; i<names.size(); i++){

            String nameOfPlayer = names.get(i).getName();
            int curPos = names.get(i).getPosition();
            System.out.println(nameOfPlayer + "position: " + curPos);

        }
        return totalDice;
    }

    @FXML
    //this method is called when the card is drawn
    // comment
    void takeCard() throws Exception{
        try{

            FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("cardWindow.fxml"));
            Parent cardRoot = (Parent) fxmlLoader3.load();
            Stage cardStage = new Stage();
            cardStage.setTitle("Monopoly Space EDITION - Card");
            cardStage.setScene(new Scene(cardRoot));
            cardStage.setResizable(false);
            cardStage.show();

            System.out.println(card1.getContent());
            System.out.println(card2.getContent());
            System.out.println(card3.getContent());
            System.out.println(card4.getContent());
            System.out.println(card5.getContent());
//            System.out.println(names.get(0).getName());
//            System.out.println(tokens.get(0).getDirectory());

        } catch(Exception e3){
            System.out.println("operation can not be done");
        }
    }

    @FXML
    //this method close the new opened windows on Board
    //closing Card, Title Deed, Go To Jail...
    void closeOpenedOnBoard(){
        Stage stage = (Stage) okInCard.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
