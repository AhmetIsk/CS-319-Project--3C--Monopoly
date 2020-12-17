//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.lang.Math;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class GameController implements Initializable{




    ArrayList<Token> tokens;
    ArrayList<Player> names;

    //Array List that contains player objects


    public void initial(ArrayList<Player> names, ArrayList<Token> tokens) throws FileNotFoundException {
        this.names = names;
        this.tokens = tokens;
        if (names.size() == 1) {
            p1NameLabel.setText(names.get(0).getName());
            p1AccountLabel.setText(String.valueOf(names.get(0).getBalance()));
            //make other buttons not visible
            p2DeedButton.setVisible(false);
            p3DeedButton.setVisible(false);
            p4DeedButton.setVisible(false);
            // p1Deed Button will be here
            Image image = new Image(getClass().getResourceAsStream((tokens.get(0)).getDirectory()));
            token1.setImage(image);
            (tokens.get(0)).setImageView(token1);

        }
        if (names.size() == 2) {
            p1NameLabel.setText(names.get(0).getName());
            p1AccountLabel.setText(String.valueOf(names.get(0).getBalance()));
            //make other buttons not visible
            p3DeedButton.setVisible(false);
            p4DeedButton.setVisible(false);
            // p1Deed Button will be here
            p2NameLabel.setText(names.get(1).getName());
            p2AccountLabel.setText(String.valueOf(names.get(1).getBalance()));
            // p1Deed Button will be here
            Image image = new Image(getClass().getResourceAsStream((tokens.get(0)).getDirectory()));
            token1.setImage(image);
            (tokens.get(0)).setImageView(token1);
            Image image1 = new Image(getClass().getResourceAsStream((tokens.get(1)).getDirectory()));
            token2.setImage(image1);
            (tokens.get(1)).setImageView(token2);

        }
        if (names.size() == 3) {
            p1NameLabel.setText(names.get(0).getName());
            p1AccountLabel.setText(String.valueOf(names.get(0).getBalance()));
            // p1Deed Button will be here
            p2NameLabel.setText(names.get(1).getName());
            p2AccountLabel.setText(String.valueOf(names.get(1).getBalance()));
            // p1Deed Button will be here
            p3NameLabel.setText(names.get(2).getName());
            p3AccountLabel.setText(String.valueOf(names.get(2).getBalance()));
            //make other buttons not visible
            p4DeedButton.setVisible(false);
            // p1Deed Button will be here
            Image image = new Image(getClass().getResourceAsStream((tokens.get(0)).getDirectory()));
            token1.setImage(image);
            (tokens.get(0)).setImageView(token1);
            Image image1 = new Image(getClass().getResourceAsStream((tokens.get(1)).getDirectory()));
            token2.setImage(image1);
            (tokens.get(1)).setImageView(token2);
            Image image2 = new Image(getClass().getResourceAsStream((tokens.get(2)).getDirectory()));
            token3.setImage(image2);
            (tokens.get(2)).setImageView(token3);

        }
        if (names.size() == 4) {
            p1NameLabel.setText(names.get(0).getName());
            p1AccountLabel.setText(String.valueOf(names.get(0).getBalance()));
            // p1Deed Button will be here
            p2NameLabel.setText(names.get(1).getName());
            p2AccountLabel.setText(String.valueOf(names.get(1).getBalance()));
            // p1Deed Button will be here
            p3NameLabel.setText(names.get(2).getName());
            p3AccountLabel.setText(String.valueOf(names.get(2).getBalance()));
            // p1Deed Button will be here
            p4NameLabel.setText(names.get(3).getName());
            p4AccountLabel.setText(String.valueOf(names.get(3).getBalance()));
            // p1Deed Button will be here
            Image image = new Image(getClass().getResourceAsStream((tokens.get(0)).getDirectory()));
            token1.setImage(image);
            (tokens.get(0)).setImageView(token1);
            Image image1 = new Image(getClass().getResourceAsStream((tokens.get(1)).getDirectory()));
            token2.setImage(image1);
            (tokens.get(1)).setImageView(token2);
            Image image2 = new Image(getClass().getResourceAsStream((tokens.get(2)).getDirectory()));
            token3.setImage(image2);
            (tokens.get(2)).setImageView(token3);
            Image image3 = new Image(getClass().getResourceAsStream((tokens.get(3)).getDirectory()));
            token4.setImage(image3);
            (tokens.get(3)).setImageView(token4);

        }

//        File file = new File((tokens.get(0)).getDirectory());
//        Image image = new Image(file.toURI().toString());
//        token1.setImage(new Image(new FileInputStream(tokens.get(0).getDirectory())));
    }




    //Chance cards
    CardDecorator card1 = new AlienAttack(new ChanceCard(1));
    CardDecorator card2 = new PutJail(new ChanceCard(2));
    CardDecorator card3 = new ChangeBankAccount(new ChanceCard(3));
    CardDecorator card4 = new ChangePosition(new ChanceCard(4));
    CardDecorator card5 = new ChangeBankAccount(new ChangePosition(new ChanceCard(5)));
    CardDecorator[] cardsArray =  new CardDecorator[]{card1, card2, card3, card4, card5};

    public CardDecorator getRandomCard() {
        int randomNum = (int)((1 + Math.random()*5) - 1);
        return cardsArray[randomNum];
    }


    int totalDice;

    //turn number
    //if there are 4 players turns is between 0-3
    int turn = 0;
    Player currentPlayer;

    @FXML
    ImageView token1;
    @FXML
    ImageView token2;
    @FXML
    ImageView token3;
    @FXML
    ImageView token4;

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
    @FXML
    Label currentPlayerName;

    //buttons and labels on Card window
    @FXML
    Button okInCard;

    @FXML
    Label titleOnCard;

    @FXML
    Button btnMove;




    @FXML
    Button alertOkButton;

    @FXML
    Label dutyLabel;
    //end of buttons and labels on Card window

    //GridPane for monopoly board
    @FXML
    GridPane boardPane;

    //biggest anchorPane (full screen)
    @FXML
    AnchorPane bigPane;


    //titleDeed anchorPane
    @FXML
    AnchorPane deedPane;

    //titleDeed anchorPane
    @FXML
    Label deedPaneTitle;

    //titleDeed anchorPane
    @FXML
    Button closeDeeds;

    //scroll Pane in titleDeeds
    @FXML
    ScrollPane scrollPaneDeeds;



    //bank account tabla
    @FXML
    GridPane infoTable;

    //Bank Account Table Labels and Buttons
    @FXML
    Label p1NameLabel;
    @FXML
    Label p2NameLabel;
    @FXML
    Label p3NameLabel;
    @FXML
    Label p4NameLabel;
    @FXML
    Label p1AccountLabel;
    @FXML
    Label p2AccountLabel;
    @FXML
    Label p3AccountLabel;
    @FXML
    Label p4AccountLabel;
    @FXML
    Button p1DeedButton;
    @FXML
    Button p2DeedButton;
    @FXML
    Button p3DeedButton;
    @FXML
    Button p4DeedButton;
    //end of BankAccount Table





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
        //this method is for BankAccount Table
    void updateTable(){

        //p1NameLabel.setText(names.get(0).getName());


        //updateTable();


    }


    @FXML
    //this method is to show title Deeds of players
    void showDeeds() throws Exception{
        //if first players button is clicked
        if(p1DeedButton.isFocused()){
            //set title
            deedPaneTitle.setText(p1NameLabel.getText() + "'s TitleDeeds");
            //if no title deed
            if(names.get(0).getTitleDeeds().size() == 0){
                deedPaneTitle.setText(p1NameLabel.getText() + " has no Property");
            }
            else{
                //initialize an array to print in scroll pane
                ArrayList<String> propertyNames = new ArrayList<String>();
                for(int i = 0; i<names.get(0).getNumProperty(); i++ ){
                    propertyNames.add("a");
                }

            }
            deedPane.setVisible(true);
        }
        else if(p2DeedButton.isFocused() && names.get(1) != null){
            deedPaneTitle.setText(p2NameLabel.getText() + "'s TitleDeeds");
            if(names.get(1).getTitleDeeds().size() == 0){
                deedPaneTitle.setText(p2NameLabel.getText() + " has no Property");
            }
            else{
                ArrayList<String> propertyNames = new ArrayList<String>();
                for(int i = 0; i<names.get(1).getNumProperty(); i++ ){
                    propertyNames.add("a");
                }

            }
            deedPane.setVisible(true);
        }else if(p3DeedButton.isFocused() && names.get(2) != null ){
            deedPaneTitle.setText(p3NameLabel.getText() + "'s TitleDeeds");
            if(names.get(2).getTitleDeeds().size() == 0){
                deedPaneTitle.setText(p3NameLabel.getText() + " has no Property");
            }
            else{
                ArrayList<String> propertyNames = new ArrayList<String>();
                for(int i = 0; i<names.get(2).getNumProperty(); i++ ){
                    propertyNames.add("a");
                }

            }
            deedPane.setVisible(true);
        }else if(p3DeedButton.isFocused() && names.get(3) != null){
            deedPaneTitle.setText(p4NameLabel.getText() + "'s TitleDeeds");
            if(names.get(3).getTitleDeeds().size() == 0){
                deedPaneTitle.setText(p4NameLabel.getText() + " has no Property");
            }
            else{
                ArrayList<String> propertyNames = new ArrayList<String>();
                for(int i = 0; i<names.get(3).getNumProperty(); i++ ){
                    propertyNames.add("a");
                }

            }
            deedPane.setVisible(true);
        }
        else{
            deedPane.setVisible(false);
        }


    }


    @FXML
        //this method closes titleDeeds
    void closeDeeds(){

        deedPane.setVisible(false);

    }
    @FXML
        //this method is called when the card is drawn
        // comment & displays a random card name
    void takeCard() throws Exception{
        try{

            //FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("cardWindow.fxml"));
            //Parent cardRoot = (Parent) fxmlLoader3.load();

            //When card is drawn card duty section comes
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Monopoly Space EDITION - Card");
            CardDecorator randomCard = getRandomCard();
            alert.setContentText(randomCard.getContent());
            Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("alertOkButton");

            //When ok button is clicked duty is done.

            okButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    randomCard.setTakenBy(currentPlayer);
                    randomCard.duty();
                    int tempTurn = (turn + (names.size() - 1)) % names.size();
                    //Balance is changing
                    System.out.println(currentPlayer.getName());
                    System.out.println("bank account: " + currentPlayer.getBalance());


                    System.out.println("inJail = " + currentPlayer.checkJail());
                    if (randomCard.equals(card2)) {
                        //token moves to jail
                        boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                        boardPane.add((tokens.get(tempTurn)).getImageView(), 10, 0);
                    }

                    if (randomCard.equals(card3)) {
                        if (currentPlayer.equals(names.get(0))) {
                            p1AccountLabel.setText("" + currentPlayer.getBalance());
                        }
                        else if (currentPlayer.equals(names.get(1))) {
                            p2AccountLabel.setText("" + currentPlayer.getBalance());
                        }
                        else if (currentPlayer.equals(names.get(2))){
                            p3AccountLabel.setText("" + currentPlayer.getBalance());
                        }
                        else if (currentPlayer.equals(names.get(3))){
                            p4AccountLabel.setText("" + currentPlayer.getBalance());
                        }
                    }

                    System.out.println("random card = " + randomCard);
                    System.out.println("id: " + randomCard.getId());
                    if(randomCard.equals(card4)) {
                        //token moves to start location
                        boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                        boardPane.add((tokens.get(tempTurn)).getImageView(), 10, 10);
                    }

                    if(randomCard.equals(card5)) {
                        System.out.println("balance ikili: " + currentPlayer.getBalance());
                        //fonk
                        boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                        boardPane.add((tokens.get(tempTurn)).getImageView(), 10, 10);
                        //fonk
                        if (currentPlayer.equals(names.get(0))) {
                            p1AccountLabel.setText("" + currentPlayer.getBalance());
                        }
                        else if (currentPlayer.equals(names.get(1))) {
                            p2AccountLabel.setText("" + currentPlayer.getBalance());
                        }
                        else if (currentPlayer.equals(names.get(2))){
                            p3AccountLabel.setText("" + currentPlayer.getBalance());
                        }
                        else if (currentPlayer.equals(names.get(3))){
                            p4AccountLabel.setText("" + currentPlayer.getBalance());
                        }
                    }
                    System.out.println("current player position: " + currentPlayer.getPosition());
                    System.out.println();

                }
            });


            alert.show();


            /*
            System.out.println(card1.getContent());
            System.out.println(card2.getContent());
            System.out.println(card3.getContent());
            System.out.println(card4.getContent());
            System.out.println(card5.getContent());
            System.out.println(names.get(0).getName());
            System.out.println(tokens.get(0).getDirectory());
             */

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
        //
        boardPane.getChildren().remove((tokens.get(turn)).getImageView());

        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);
        totalDice = dice1 + dice2;
        int a = dice1 + dice2;

        labelDice1.setText("Dice 1 : "+dice1);
        labelDice2.setText("Dice 2 : "+dice2);
        currentPlayer = names.get(turn);
        int updatedPosition = (currentPlayer.getPosition() + totalDice) %40;

        currentPlayer.setPosition(updatedPosition);


        try {
            if (updatedPosition <= 10) {
                boardPane.add((tokens.get(turn)).getImageView(), 10 - updatedPosition, 10);
            } else if (updatedPosition <= 20) {
                boardPane.add((tokens.get(turn)).getImageView(), 0, 20 - updatedPosition);
            } else if (updatedPosition <= 30) {
                boardPane.add((tokens.get(turn)).getImageView(), updatedPosition - 20, 0);
            } else {
                boardPane.add((tokens.get(turn)).getImageView(), 10, updatedPosition - 30);
            }
        }
         catch(Exception e4){
            System.out.println("operation can not be done");
        }

        turn = (turn + 1) % names.size();
        for(int i = 0; i<names.size(); i++){

            String nameOfPlayer = names.get(i).getName();
            int curPos = names.get(i).getPosition();
            System.out.println(nameOfPlayer + "position: " + curPos );

        }
        currentPlayerName.setText("Current Player : " + currentPlayer.getName());

        return updatedPosition;
    }



}
