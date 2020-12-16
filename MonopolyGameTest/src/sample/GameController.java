//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.lang.Math;
import javafx.scene.layout.GridPane;

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
    CardDecorator[] cardsArray =  new CardDecorator[]{card1, card2, card3, card4, card5};

    public CardDecorator getRandomCard() {
        int randomNum = (int)((1 + Math.random()*5) - 1);
        return cardsArray[randomNum];
    }



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
    Button chanceBtn1;
    @FXML
    Button chanceBtn2;
    @FXML
    Button chanceBtn3;
    @FXML
    Button chestBtn;
    @FXML
    Button chestBtn1;
    @FXML
    Button chestBtn2;
    @FXML
    Button chestBtn11;

    //buttons and labels on Card window
    @FXML
    Button okInCard;

    @FXML
    Label titleOnCard;

    @FXML
    Button btnMove;

    @FXML
    Circle circle1;

    //@FXML
    // Circle circle2;

    @FXML
    Label dutyLabel;
    //end of buttons and labels on Card window

    @FXML
    GridPane boardPane;

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


    // pelinde çalışması için update



    @FXML
        //this method is called when the card is drawn
        // comment & displays a random card name
    void takeCard() throws Exception{
        try{

            FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("cardWindow.fxml"));
            Parent cardRoot = (Parent) fxmlLoader3.load();

            //When card is drawn card duty section comes

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Monopoly Space EDITION - Card");
            alert.setContentText(getRandomCard().getContent());
            alert.show();

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

    @FXML
    void move(){


    }

    @FXML
        //this method is to roll dice
    //token position is updated here
    int rollDice() throws Exception{
        boardPane.getChildren().remove(circle1);
        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);
        totalDice = dice1 + dice2;
        int a = dice1 + dice2;

        labelDice1.setText("Dice 1 : "+dice1);
        labelDice2.setText("Dice 2 : "+dice2);
        currentPlayer = names.get(turn);
        int updatedPosition = (currentPlayer.getPosition() + totalDice) %40;
        currentPlayer.setPosition(updatedPosition);
        turn = (turn + 1) % names.size();
        for(int i = 0; i<names.size(); i++){

            String nameOfPlayer = names.get(i).getName();
            int curPos = names.get(i).getPosition();
            System.out.println(nameOfPlayer + "position: " + curPos);

        }

        try {
            if (updatedPosition <= 10) {
                boardPane.add(circle1, 10 - updatedPosition, 10);
            } else if (updatedPosition <= 20) {
                boardPane.add(circle1, 0, 20 - updatedPosition);
            } else if (updatedPosition <= 30) {
                boardPane.add(circle1, updatedPosition - 20, 0);
            } else {
                boardPane.add(circle1, 10, updatedPosition - 30);
            }
        }
         catch(Exception e4){
            System.out.println("operation can not be done");
        }


        //boardPane.add(circle1,updatedPosition%10,1);
        //boardPane

        //circle1.setCenterX(circle1.getCenterX()*totalDice - 55);

        return updatedPosition;
    }



}
