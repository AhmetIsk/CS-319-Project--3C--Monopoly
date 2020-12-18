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

import FileControllerManager.GameInfoReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.lang.Math;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class GameController implements Initializable{


    final int PLANET_NUMBER = 22;
    final int LOCATION_NUMBER = 40;

    ArrayList<Token> tokens;
    ArrayList<Player> names;

    String [] planetsNames;
    Integer [] planetsPositions;
    Integer [] planetsPrices;
    Integer [] planetsMortgagePrices;
    Integer [] planetsRentPrices;

    //Planet properties and actions-----
    MortgageStrategy ms;
    BuildStrategy bs;
    //Array List that contains player objects
//    Planet p1 = new Planet("Planet 1",bs,  ms, 300, 1,
//    150, 30);
//    Planet p3 = new Planet("Planet 3",bs,  ms, 200, 3,
//            100, 20);
//    Planet p6 = new Planet("Planet 6",bs,  ms, 400, 6,
//            200, 40);
//    Planet p8 = new Planet("Planet 8",bs,  ms, 350, 8,
//            175, 35);
//    Planet p9 = new Planet("Planet 9",bs,  ms, 300, 9,
//            150, 30);
//    Planet p11 = new Planet("Planet 11",bs,  ms, 500, 11,
//            250, 50);
//    Planet p13 = new Planet("Planet 13",bs,  ms, 380, 13,
//            190, 38);
//    Planet p14 = new Planet("Planet 14",bs,  ms, 400, 14,
//            200, 40);
//    Planet p16 = new Planet("Planet 16",bs,  ms, 150, 16,
//            75, 15);
//    Planet p18 = new Planet("Planet 18",bs,  ms, 200, 18,
//            100, 20);
//    Planet p19 = new Planet("Planet 19",bs,  ms, 300, 19,
//            150, 30);
//    Planet p21 = new Planet("Planet 21",bs,  ms, 250, 21,
//            125, 25);
//    Planet p23 = new Planet("Planet 23",bs,  ms, 350, 23,
//            175, 35);
//    Planet p24 = new Planet("Planet 24",bs,  ms, 200, 24,
//            100, 20);
//    Planet p26 = new Planet("Planet 26",bs,  ms, 500, 26,
//            250, 50);
//    Planet p27 = new Planet("Planet 27",bs,  ms, 280, 27,
//            140, 28);
//    Planet p29 = new Planet("Planet 29",bs,  ms, 400, 29,
//            200, 40);
//    Planet p31 = new Planet("Planet 31",bs,  ms, 250, 31,
//            125, 25);
//    Planet p32 = new Planet("Planet 32",bs,  ms, 300, 32,
//            150, 30);
//    Planet p34 = new Planet("Planet 34",bs,  ms, 200, 34,
//            100, 20);
//    Planet p37 = new Planet("Planet 37",bs,  ms, 350, 37,
//            175, 35);
//    Planet p39 = new Planet("Planet 39",bs,  ms, 280, 39,
//            140, 28);



//    Planet[] planets = new Planet[]{null,p1,null,p3,null,null,p6,null,p8,p9,null,p11,null,p13,p14
//            ,null,p16,null,p18,p19,null,p21,null,p23,p24,null,p26,p27,null,p29,null,p31,p32,null,p34
//    ,null,null,p37,null,p39};

    Planet[] planets = new Planet[LOCATION_NUMBER];



    @FXML
    //this method opens a new window for Property by clicking propety on board
    public void showProperty(){

        //first make buttons visible, they will be unvisible if neccessary
        buyButton.setVisible(true);
        payRentButton.setVisible(true);
        buildButton.setVisible(false);

        //set text at the top of the pane to show information at current player's location
        //price-rent and planet name will be shown
        propertyFeature.setText( planets[currentPlayer.getPosition()].getPropName() + "\nPrice is: " + planets[currentPlayer.getPosition()].getPrice()
                + "\nRent is" +planets[currentPlayer.getPosition()].getRentPrice());

        //show rent price of the planet
        rentLabel.setText("Rent :" + planets[currentPlayer.getPosition()].getRentPrice());

        //show pane that shows information of property
        propertyPane.setVisible(true);

        //CASE1 player comes other player's planet
        //if planet at current player's location has owner,
        //and owner is not current player
        //buy button will be unvisible since buy option is not available
        if( planets[currentPlayer.getPosition()].checkHasOwner()
                && planets[currentPlayer.getPosition()].getOwnerName() != currentPlayer.getName()){
            buyButton.setVisible(false);
            buildButton.setVisible(false);
            closePropButton.setVisible(false);
            //show information about planet, by adding owner player name
            propertyFeature.setText( planets[currentPlayer.getPosition()].getPropName() + "\nOwner: " + planets[currentPlayer.getPosition()].getOwnerName()
                    + "\nRent is" +planets[currentPlayer.getPosition()].getRentPrice());
        }

        //if player comes to his/her own property
        if( planets[currentPlayer.getPosition()].checkHasOwner()
                && planets[currentPlayer.getPosition()].getOwnerName() == currentPlayer.getName()){
            buyButton.setVisible(false);
            buildButton.setVisible(true);
            payRentButton.setVisible(false);
            //show information about planet, by adding owner player name
            propertyFeature.setText( planets[currentPlayer.getPosition()].getPropName() + "\nOwner: " + planets[currentPlayer.getPosition()].getOwnerName()
                    + "\nRent is" +planets[currentPlayer.getPosition()].getRentPrice());
        }

        //if planet has no owner, pay rent button is not visible
        //because pay rent is not available for planets that has no owner
        if( !(planets[currentPlayer.getPosition()].checkHasOwner())){
            payRentButton.setVisible(false);
            buildButton.setVisible(false);
            //if buy button is clicked, player buy the planet property
            if(buyButton.isFocused()){
                //if planet has no owner, add it to players title list
                if(!planets[currentPlayer.getPosition()].checkHasOwner()){
                    //player buy the planet with buy property method
                    currentPlayer.buyProperty(planets[currentPlayer.getPosition()]);


                    //make planet hasOwner true
                    planets[currentPlayer.getPosition()].setHasOwner(true);
                    //buy button will be unvisible, since it has owner now

                    buyButton.setVisible(false);
                    //set owner of the planet

                    planets[currentPlayer.getPosition()].setOwner(currentPlayer);

                    System.out.println(currentPlayer.getName() + " buy " +currentPlayer.getTitleDeeds().get(0).getPropName());
                    //update bank account in bank account table
                    changeTable();
                }


            }


        }


        if(buildButton.isFocused()){

        }

    }

    @FXML
    public void closePropertyPane(){
        //make property pane unvisible
        propertyPane.setVisible(false);
    }

    @FXML
    //this method is to make payment for rent of the planets
    public void payRent(){

        //planet's rent  that is at the currentPlayer's location
        int temp1 = planets[currentPlayer.getPosition()].getRentPrice();
        //temp2 = currentPlayers bank account after payment
        int temp2 = currentPlayer.getBalance() -temp1;
        //set current players bank account after payment for rent
        currentPlayer.setBalance(temp2);

        String tempName =planets[currentPlayer.getPosition()].getOwnerName();

        for(int i = 0; i<names.size(); i++){
            if( names.get(i).getName()==tempName){
                //set owner's bank account
                names.get(i).setBalance(names.get(i).getBalance() + temp1);
                changeTable(names.get(i));
                System.out.println(tempName + "balance " + names.get(i).getBalance());

            }
        }

        System.out.println(currentPlayer.getBalance());

        //update bank account in bank account table
        changeTable();
        //after payment, make pay button unvisible to avoid multiple payment
        if(payRentButton.isFocused()) {
            payRentButton.setVisible(false);
            closePropButton.setVisible(true);
        }
        //message in the label that indicates payment is done
        rentLabel.setText("payment is \n done!");


    }

    public void changeTable(){
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

    public void changeTable(Player p){

        int index = names.indexOf(p);
        if(index ==0){

            p1AccountLabel.setText(""+p.getBalance());

        }else if (index ==1){
            p2AccountLabel.setText(""+p.getBalance());

        }else if(index ==2){

            p3AccountLabel.setText(""+p.getBalance());
        }else{
            p4AccountLabel.setText(""+p.getBalance());
        }

    }

    public void initial(ArrayList<Player> names, ArrayList<Token> tokens) {
        this.names = names;
        this.tokens = tokens;
        int locationCounter = 0;
        boolean equal = false;

        planetsNames = GameInfoReader.getPlanetNames();
        planetsPositions = GameInfoReader.getPlanetSPositions();
        planetsPrices = GameInfoReader.getPlanetsPrice();
        planetsRentPrices = GameInfoReader.getPlanetsRentPrice();
        planetsMortgagePrices = GameInfoReader.getPlanetsMortgagePrice();

        for (int i = 0; i < LOCATION_NUMBER; i++) {
            if ( planetsPositions[locationCounter] == i) {
                equal = true;
                planets[i] = new Planet(planetsNames[locationCounter], bs, ms, planetsPrices[locationCounter],
                        planetsPositions[locationCounter], planetsMortgagePrices[locationCounter], planetsRentPrices[locationCounter]);
            }
            if (equal)
                locationCounter++;
            equal = false;
        }

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
    Button jailButton;

    @FXML
    Pane jailPane;

    @FXML
    ImageView paneImage;

    @FXML
    TextArea deedInfo;

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

    //Property Pane ----
    @FXML
    AnchorPane propertyPane;

    @FXML
    Button buyButton;

    @FXML
    Button buildButton;

    @FXML
    Button closePropButton;

    @FXML
    Label propertyFeature;

    @FXML
    Label rentLabel;

    @FXML
    Button payRentButton;

    //--------


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
        //if first players button is clicked, show players' title deed
        String printedDeed = ""; //to print planet names as string
        if(p1DeedButton.isFocused()){
            //set title of the opened title deed's pane
            deedPaneTitle.setText(p1NameLabel.getText() + "'s TitleDeeds");

            //deedInfo is text area
            //if player has no propety(players' title deed array is empty)
            if(names.get(0).getTitleDeeds().size() == 0){
                //indicate in the title that player has no property
                deedPaneTitle.setText(p1NameLabel.getText() + " has no Property");
                //scrollPaneDeeds.setContent(deedInfo);
            }
            else{

                for(int i = 0; i< names.get(0).getTitleDeeds().size(); i++ ){
                    printedDeed = printedDeed + "\n" + names.get(0).getTitleDeeds().get(i).getPropName();
//                    Tam anlayamadım düzeni, iki opsiyon denedim ama ikisi de çalışmadı
//                    deedInfo.setText(propertyNames.get(i));
//                    deedInfo.setText((((names.get(0)).getTitleDeeds()).get(i)).getPropName());
                }
                deedInfo.appendText(printedDeed);
                scrollPaneDeeds.setContent(deedInfo);
            }
            deedPane.setVisible(true);
        }
        else if(p2DeedButton.isFocused() && names.get(1) != null){
            //set title of the opened title deed's pane
            deedPaneTitle.setText(p2NameLabel.getText() + "'s TitleDeeds");
            //if player has no propety(players' title deed array is empty)
            if(names.get(1).getTitleDeeds().size() == 0){
                deedPaneTitle.setText(p2NameLabel.getText() + " has no Property");
            }
            else{
                for(int i = 0; i< names.get(1).getTitleDeeds().size(); i++ ){
                    printedDeed = printedDeed + "\n" + names.get(1).getTitleDeeds().get(i).getPropName();
//
                }
                deedInfo.appendText(printedDeed);
                scrollPaneDeeds.setContent(deedInfo);

            }
            deedPane.setVisible(true);
        }else if(p3DeedButton.isFocused() && names.get(2) != null ){
            //set title of the opened title deed's pane
            deedPaneTitle.setText(p3NameLabel.getText() + "'s TitleDeeds");
            //if player has no propety(players' title deed array is empty)
            if(names.get(2).getTitleDeeds().size() == 0){
                deedPaneTitle.setText(p3NameLabel.getText() + " has no Property");
            }
            else{
                //print player's title deed in the scroll pane
                for(int i = 0; i< names.get(2).getTitleDeeds().size(); i++ ){
                    printedDeed = printedDeed + "\n" + names.get(2).getTitleDeeds().get(i).getPropName();
//
                }
                deedInfo.appendText(printedDeed);
                scrollPaneDeeds.setContent(deedInfo);

            }
            deedPane.setVisible(true);
        }else if(p3DeedButton.isFocused() && names.get(3) != null){
            //set title of the opened title deed's pane
            deedPaneTitle.setText(p4NameLabel.getText() + "'s TitleDeeds");
            //if player has no propety(players' title deed array is empty)
            if(names.get(3).getTitleDeeds().size() == 0){
                deedPaneTitle.setText(p4NameLabel.getText() + " has no Property");
            }
            else{
                //print player's title deed in the scroll pane
                for(int i = 0; i< names.get(3).getTitleDeeds().size(); i++ ){
                    printedDeed = printedDeed + "\n" + names.get(3).getTitleDeeds().get(i).getPropName();
//
                }
                deedInfo.appendText(printedDeed);
                scrollPaneDeeds.setContent(deedInfo);

            }
            //shows deedPane after inserting information
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
    void putJail() {
        jailPane.setVisible(false);
        int tempTurn = (turn + (names.size() - 1)) % names.size();
        if (currentPlayer.getPosition() == 30) {
            boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
            boardPane.add((tokens.get(tempTurn)).getImageView(), 0, 10);
            currentPlayer.setInJail();
        }else {
            currentPlayer.setInJail();
            currentPlayer.setPosition(20);
        }
    }

    @FXML
        //this method is to roll dice
        //token position is updated here
    int rollDice() throws Exception{
        //current player
        currentPlayer = names.get(turn);
        //initialize updated position
        int updatedPosition = currentPlayer.getPosition();


        if (currentPlayer.checkJail() && (currentPlayer.getJailDayCounter() != 3)) {
            int currentDay = currentPlayer.getJailDayCounter();
            currentPlayer.setJailDayCounter(currentDay + 1);
            turn = (turn + 1) % names.size();
        }
        else {
            currentPlayer.exitJail();

            int dice1 = (int) (Math.random() * 6 + 1);
            int dice2 = (int) (Math.random() * 6 + 1);
            totalDice = dice1 + dice2;
            int a = dice1 + dice2;

            labelDice1.setText("Dice 1 : "+dice1);
            labelDice2.setText("Dice 2 : "+dice2);

            updatedPosition = (currentPlayer.getPosition() + totalDice) %40;

            currentPlayer.setPosition(updatedPosition);

            boardPane.getChildren().remove((tokens.get(turn)).getImageView());

            //this part is to arrange movements of the tokens in the grid pane
            //add token to its new position by moving token according to total dice
            //mathematical calculations are done in if else statements
            try {
                if (updatedPosition <= 10) {
                    //add token to its new position by moving token according to total dice
                    boardPane.add((tokens.get(turn)).getImageView(), 10 - updatedPosition, 10);
                    //add token to its new position by moving token according to total dice
                    if (((updatedPosition - totalDice) < 0) || updatedPosition == 0)
                        currentPlayer.setBalance(currentPlayer.getBalance() + 1000);
                    changeTable();
                } else if (updatedPosition <= 20) {
                    boardPane.add((tokens.get(turn)).getImageView(), 0, 20 - updatedPosition);
                    //add token to its new position by moving token according to total dice
                } else if (updatedPosition <= 30) {
                    boardPane.add((tokens.get(turn)).getImageView(), updatedPosition - 20, 0);
                    //add token to its new position by moving token according to total dice
                } else {
                    boardPane.add((tokens.get(turn)).getImageView(), 10, updatedPosition - 30);
                }

            }
            catch(Exception e4){
                System.out.println("operation can not be done");
            }

            //if there exists a planet after movement of current planer
            //show the information so that player decide buy/build options
            //or rent
            if(planets[updatedPosition] != null){
                //open the information of planet about the current player's new location
                showProperty();
            }

            //increment turn and take mod
            turn = (turn + 1) % names.size();

            if (!currentPlayer.checkJail() && (currentPlayer.getPosition() == 30 || currentPlayer.getPosition() == 20))  {
                if (currentPlayer.getPosition() == 20) {
                    Image image = new Image(getClass().getResourceAsStream("../img/blackhole.jpg"));
                    paneImage.setImage(image);
                    jailPane.setVisible(true);
                } else {
                    Image image = new Image(getClass().getResourceAsStream("../img/goToJail.jpg"));
                    paneImage.setImage(image);
                    jailPane.setVisible(true);
                }
            }

            //print new position at console
            for(int i = 0; i<names.size(); i++){

                String nameOfPlayer = names.get(i).getName();
                int curPos = names.get(i).getPosition();
                System.out.println(nameOfPlayer + "position: " + curPos );

            }
        }

        //show current player at the bottom of the game scene
        currentPlayerName.setText("Current Player : " + currentPlayer.getName());

        return updatedPosition;
    }



}