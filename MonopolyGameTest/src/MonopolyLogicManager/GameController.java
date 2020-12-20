//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package MonopolyLogicManager;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;
import java.lang.Math;
import javafx.scene.layout.GridPane;

public class GameController implements Initializable{


    final int PLANET_NUMBER = 22;
    final int LOCATION_NUMBER = 40;

    ///comment
    //comment push

    ArrayList<Token> tokens;
    ArrayList<Player> names;

    ArrayList<Token> tokensForReplay;
    ArrayList<Player> namesForReplay;

    String [] planetsNames;
    Integer [] planetsPositions;
    Integer [] planetsPrices;
    Integer [] planetsMortgagePrices;
    Integer [] planetsRentPrices;

    //Planet properties and actions-----
    MortgageStrategy ms;
    BuildStrategy bs;


    Planet[] planets = new Planet[LOCATION_NUMBER];

    //4 space ship we have

    String [] SpaceshipsNames;
    Integer [] SpaceshipsPositions;
    Integer [] SpaceshipsPrices;
    Integer [] SpaceshipsRentPrices;


    Spaceship [] spaceships = new Spaceship [LOCATION_NUMBER];

    @FXML
    Label builtMessageLabel;

    @FXML
    Button buildForestButton;

    @FXML
    Button buildHotelButton;

    @FXML
    Button buildHouseButton;

    @FXML
    Button closeBuildPaneButton;

    @FXML
    AnchorPane buildStructurePane;


    @FXML
    public void showBuildStructure(){
        buildForestButton.setVisible(true);
        buildHotelButton.setVisible(true);
        buildHouseButton.setVisible(true);

        buildStructurePane.setVisible(true);

        //check player's balance conditions to build structures
        if( currentPlayer.getBalance() > 100 && currentPlayer.getBalance() < 150){
            buildHotelButton.setDisable(true);
            buildForestButton.setDisable(true);
        }
        if( currentPlayer.getBalance() >= 150 && currentPlayer.getBalance() < 200){
            buildForestButton.setDisable(true);
        }

        if(buildHouseButton.isFocused()){
            planets[currentPlayer.getPosition()].performBuild(new BuildHouseStrategy());
            builtMessageLabel.setText("A house is built!");
            changeTable();

            propertyFeature.setText( planets[currentPlayer.getPosition()].getPropName() + "\nPrice is: " + planets[currentPlayer.getPosition()].getPrice()
                    + "\nRent is " +planets[currentPlayer.getPosition()].getRentPrice()
                    + "\nHouse:" + planets[currentPlayer.getPosition()].getNumHouses()
                    + " Hotel:" + planets[currentPlayer.getPosition()].getNumHotels()
                    + " Forest:" + planets[currentPlayer.getPosition()].getNumForests());

            buildForestButton.setVisible(false);
            buildHotelButton.setVisible(false);
            buildHouseButton.setVisible(false);
            closeBuildPaneButton.setVisible(true);
        }
        if(buildHotelButton.isFocused()){
            planets[currentPlayer.getPosition()].performBuild(new BuildHotelStrategy());
            builtMessageLabel.setText("A hotel is built!");
            changeTable();

            propertyFeature.setText( planets[currentPlayer.getPosition()].getPropName() + "\nPrice is: " + planets[currentPlayer.getPosition()].getPrice()
                    + "\nRent is " +planets[currentPlayer.getPosition()].getRentPrice()
                    + "\nHouse:" + planets[currentPlayer.getPosition()].getNumHouses()
                    + " Hotel:" + planets[currentPlayer.getPosition()].getNumHotels()
                    + " Forest:" + planets[currentPlayer.getPosition()].getNumForests());

            buildForestButton.setVisible(false);
            buildHotelButton.setVisible(false);
            buildHouseButton.setVisible(false);
            closeBuildPaneButton.setVisible(true);
        }
        if(buildForestButton.isFocused()){
            planets[currentPlayer.getPosition()].performBuild(new BuildForestStrategy());
            builtMessageLabel.setText("A forest is built!");
            changeTable();

            propertyFeature.setText( planets[currentPlayer.getPosition()].getPropName() + "\nPrice is: " + planets[currentPlayer.getPosition()].getPrice()
                    + "\nRent is " +planets[currentPlayer.getPosition()].getRentPrice()
                    + "\nHouse:" + planets[currentPlayer.getPosition()].getNumHouses()
                    + " Hotel:" + planets[currentPlayer.getPosition()].getNumHotels()
                    + " Forest:" + planets[currentPlayer.getPosition()].getNumForests());

            buildForestButton.setVisible(false);
            buildHotelButton.setVisible(false);
            buildHouseButton.setVisible(false);
            closeBuildPaneButton.setVisible(true);
        }


        planets[currentPlayer.getPosition()].getCurrentInfoStructures();
        System.out.println("-------------------");


    }

    @FXML
    public void closeBuildStructurePane(){
        //make build structure pane unvisible
        buildStructurePane.setVisible(false);
    }

    @FXML
    Button buyShip;

    @FXML
    Button rentShipButton;

    @FXML
    Button closeShipButton;

    @FXML
    Button quitBtn;

    @FXML
    Button finishReplay;

    @FXML
    Label titleShipPaneL;

    @FXML
    Label infoShipLabel;

    @FXML
    Label rentShipLabel;

    @FXML
    AnchorPane shipPane;

    @FXML
    ImageView spaceshipImg;

    @FXML
//this method opens a new window for SpaceShip
    public void showSpaceShip(){

        //first make buttons on ship pane visible,then change
        buyShip.setDisable(false);
        rentShipButton.setDisable(false);
        rollDiceBtn.setDisable(true);
        rollDiceBtn.setText("");
        rentShipLabel.setText("rent:\n"+spaceships[currentPlayer.getPosition()].getRentPrice());

        Image image = new Image(getClass().getResourceAsStream("../img/" + spaceships[currentPlayer.getPosition()].getPropName() +  ".jpg"));
        spaceshipImg.setImage(image);

        Spaceship currentShip;

        //set the label at the top of the pane
        titleShipPaneL.setText("" + spaceships[currentPlayer.getPosition()].getPropName()
                + "\nprice:" +spaceships[currentPlayer.getPosition()].getPrice() );
        shipPane.setVisible(true);


        //case1: player comes to a spaceship that has no owner
        if( !(spaceships[currentPlayer.getPosition()].checkHasOwner()) ){

            rentShipButton.setDisable(true);
            //player has no enough money to buy ship
            if(currentPlayer.getBalance()<spaceships[currentPlayer.getPosition()].getPrice()){
                infoShipLabel.setText("You don't have money \n to buy ");
                buyShip.setDisable(true);
                closeShipButton.setDisable(false);

            }
            else {
                //no owher, so there is no pay option
                rentShipButton.setDisable(true);
                infoShipLabel.setText("Ship has no owner." +
                        "\n Do you want to have a space ship?" +
                        " \n This will be cool!");
                closeShipButton.setDisable(false);
            }

        }

        //case2: player comes to a spaceship that has owner
        if( (spaceships[currentPlayer.getPosition()].checkHasOwner()) ){

            buyShip.setDisable(true);
            //case 2.1 : player comes to his/her own space ship
            if(spaceships[currentPlayer.getPosition()].getOwnerName() == currentPlayer.getName()){
                //player does not pay rent for his ship
                rentShipButton.setDisable(true);
                infoShipLabel.setText("Owner:" +  spaceships[currentPlayer.getPosition()].getOwnerName() +
                        "\nWelcome to your Space Ship\n" +
                        spaceships[currentPlayer.getPosition()].getPropName());
            }
            //case 2.1 player comes to other players space ship
            else{

                infoShipLabel.setText("Owner:" + spaceships[currentPlayer.getPosition()].getOwnerName() +
                        "\nYou have to pay rent "
                        + "\nRent: " + spaceships[currentPlayer.getPosition()].getRentPrice());
                //make close button diasable so that player can not go out without payment
                closeShipButton.setDisable(true);
                rentShipButton.setDisable(false);
                buyShip.setDisable(true);
                //pay rent action will be handled in the payShip method

                //////MORTGAGE FOR SPACESHIP
                buyShip.setDisable(true);

                //1-----------------MORTGAGE completed
                //1-isMortgaged olayını check edicez (player kira vericek mi diye?
                if(spaceships[currentPlayer.getPosition()].checkMortgaged()){
                    rentShipButton.setDisable(true);
                    closeShipButton.setDisable(false);
                    infoShipLabel.setText( spaceships[currentPlayer.getPosition()].getPropName() +
                            "\nThis spaceship is mortgaged");

                }



            }

        }

    }

    @FXML
    public void buySpaceShip(){

        if(! (spaceships[currentPlayer.getPosition()].checkHasOwner()) ){
            //current player buy the space ship
            //player's account and title deeds for spaceship is changed
            currentPlayer.buySpaceShip(spaceships[currentPlayer.getPosition()]);

            //make spaceship has owner true
            spaceships[currentPlayer.getPosition()].setHasOwner(true);
            //buy button will be invisible, since it has owner now
            buyShip.setDisable(true);


            //set owner of the spaceship to current player
            spaceships[currentPlayer.getPosition()].setOwner(currentPlayer);


            infoShipLabel.setText("You Bought This Spaceship !");
            System.out.println(currentPlayer.getName() + " buy "
                    +currentPlayer.getSpaceShipDeeds().get(0).getPropName());
            //update bank account in bank account table
            changeTable(); //change bank account in the table of player
        }
    }

    @FXML
    public void payRentShip(){

        //spaceship's rent  that is at the currentPlayer's location
        int temp1 = spaceships[currentPlayer.getPosition()].getRentPrice();

        //MORTGAGE
        //22222222-eğer current playerin balance < spaceship.rent--->mortgage (currentPlayer'a yap)
        if(currentPlayer.getBalance() < temp1){

            //1-open new pane for mortgage
            //2-methodu çağırmadan gerekli olanlar
            okMortgageButton.setDisable(false); //okMortgage is available
            closeMortgageButton.setDisable(true); //close is available after mortgage
            mortgagePane.setVisible(true);


            //---------MORTGAGE FOR PAY RENT FOR PLANET-----------
            ArrayList<String> mortgagedPropertiesNames = new ArrayList<String>();
           // mortgageOperation(mortgagedPropertiesNames);
            mortgageSpaceShip(mortgagedPropertiesNames);
            String nameOfMortgaged = "";
            for(int i =0; i < mortgagedPropertiesNames.size() ; i++){

                nameOfMortgaged += "\nYour planet\n" + mortgagedPropertiesNames.get(i)
                        + " is mortgaged";


            }
            showMortgagedPLabel.setText(nameOfMortgaged + "\n Now you cant receive rent payments");

            //3- call a method that makes mortgage(this process is handled in pane with "ok" button)
            //mortgageOperation()

        }
        else {

            //temp2 = currentPlayers bank account after payment
            int temp2 = currentPlayer.getBalance() - temp1;
            //set current players bank account after payment for rent
            currentPlayer.setBalance(temp2);
        }
        String tempName =spaceships[currentPlayer.getPosition()].getOwnerName();
        //change bank account of the owner of the planet and show in the bank table
        for(int i = 0; i<names.size(); i++){
            if( names.get(i).getName()==tempName){
                //set owner's bank account
                names.get(i).setBalance(names.get(i).getBalance() + temp1);
                changeTable(names.get(i)); //change account of owner of ship in table
                System.out.println(tempName + "balance " + names.get(i).getBalance());
            }
        }
        //update bank account of current player after payment in bank account table
        changeTable();
        //after payment, make pay button unvisible to avoid multiple payment
        if(rentShipButton.isFocused()){
            rentShipButton.setDisable(true);
            closeShipButton.setDisable(false); //make close visible
        }

        //message in the label that indicates payment is done
        rentLabel.setText("payment \n done!");

    }


    public void mortgageSpaceShip(ArrayList<String> mortgagedPropertiesNames){
        int totalAmountNeeded = 0;
        //iterate planets
        if(currentPlayer.getTitleDeeds().size() > 0){
            for(int i = 0; i < currentPlayer.getTitleDeeds().size(); i++){
                if(!(currentPlayer.getTitleDeeds().get(i).checkMortgaged())){
                    currentPlayer.getTitleDeeds().get(i).performMortgage();
                    totalAmountNeeded = totalAmountNeeded + currentPlayer.getTitleDeeds().get(i).getMortgagePrice();
                    mortgagedPropertiesNames.add(currentPlayer.getTitleDeeds().get(i).getPropName());
                    if( totalAmountNeeded >= spaceships[currentPlayer.getPosition()].getRentPrice() ){
                        break;
                    }
                }
            }
        }

        //iterate ships
        if(currentPlayer.getSpaceShipDeeds().size() > 0 && totalAmountNeeded
                < spaceships[currentPlayer.getPosition()].getRentPrice()){
            for(int i = 0; i < currentPlayer.getSpaceShipDeeds().size(); i++){
                if(!(currentPlayer.getSpaceShipDeeds().get(i).checkMortgaged())){
                    currentPlayer.getSpaceShipDeeds().get(i).performMortgage();
                    totalAmountNeeded = totalAmountNeeded + currentPlayer.getSpaceShipDeeds().get(i).getMortgagePrice();
                    mortgagedPropertiesNames.add(currentPlayer.getSpaceShipDeeds().get(i).getPropName());
                    if (totalAmountNeeded >= spaceships[currentPlayer.getPosition()].getRentPrice() ){
                        break;
                    }
                }
            }
        }
        // player is bankrupt
        if(totalAmountNeeded < spaceships[currentPlayer.getPosition()].getRentPrice()){
            //declare player as bankrupt
            System.out.println("GO BANKRUPT");
        }
    }

    public void mortgageOperation(ArrayList<String> mortgagedPropertiesNames){
        int totalAmountNeeded = 0;
        //iterate planets
        if(currentPlayer.getTitleDeeds().size() > 0){
            for(int i = 0; i < currentPlayer.getTitleDeeds().size(); i++){
                if(!(currentPlayer.getTitleDeeds().get(i).checkMortgaged())){
                    currentPlayer.getTitleDeeds().get(i).performMortgage();
                    totalAmountNeeded = totalAmountNeeded + currentPlayer.getTitleDeeds().get(i).getMortgagePrice();
                    mortgagedPropertiesNames.add(currentPlayer.getTitleDeeds().get(i).getPropName());
                    if( totalAmountNeeded >= planets[currentPlayer.getPosition()].getRentPrice() ){
                        break;
                    }
                }
            }
        }

        //iterate ships
        if(currentPlayer.getSpaceShipDeeds().size() > 0 && totalAmountNeeded
                < planets[currentPlayer.getPosition()].getRentPrice()){
            for(int i = 0; i < currentPlayer.getSpaceShipDeeds().size(); i++){
                if(!(currentPlayer.getSpaceShipDeeds().get(i).checkMortgaged())){
                    currentPlayer.getSpaceShipDeeds().get(i).performMortgage();
                    totalAmountNeeded = totalAmountNeeded + currentPlayer.getSpaceShipDeeds().get(i).getMortgagePrice();
                    mortgagedPropertiesNames.add(currentPlayer.getSpaceShipDeeds().get(i).getPropName());
                    if (totalAmountNeeded >= planets[currentPlayer.getPosition()].getRentPrice() ){
                        break;
                    }
                }
            }
        }
        // player is bankrupt
        if(totalAmountNeeded < planets[currentPlayer.getPosition()].getRentPrice()){
            //declare player as bankrupt
            System.out.println("GO BANKRUPT");
        }
    }


    @FXML
    //this method opens a new window for Property
    //BUNU PLANET YAP----------------
    public void showProperty(){

        //first make buttons visible, they will be unvisible if neccessary
        buyButton.setDisable(false);
        payRentButton.setDisable(false);
        buildButton.setDisable(false);
        rollDiceBtn.setDisable(true);
        rollDiceBtn.setText("");
        mortgageShowLabel.setText("-----------");
        //set text at the top of the pane to show information at current player's location
        //price-rent and planet name will be shown
        propertyFeature.setText( planets[currentPlayer.getPosition()].getPropName()
                + "\nPrice is: " + planets[currentPlayer.getPosition()].getPrice()
                + "\nRent is: " +planets[currentPlayer.getPosition()].getRentPrice());

        //show rent price of the planet
        rentLabel.setText("Rent :" + planets[currentPlayer.getPosition()].getRentPrice());

        //if planet has mortgage on it, show in the pane
        if(planets[currentPlayer.getPosition()].checkMortgaged()){
            mortgageShowLabel.setText("Planet has mortgage on it");
        }
        //show pane that shows information of property
        propertyPane.setVisible(true);

        //CASE1 player comes other player's planet
        //if planet at current player's location has owner,
        //and owner is not current player
        //buy button will be unvisible since buy option is not available
        if( planets[currentPlayer.getPosition()].checkHasOwner()
                && (planets[currentPlayer.getPosition()].getOwnerName() != currentPlayer.getName())){

            System.out.println(planets[currentPlayer.getPosition()].checkHasOwner());
            buyButton.setDisable(true);
            buildButton.setDisable(true);
            closePropButton.setDisable(true);
            //show information about planet, by adding owner player name
            propertyFeature.setText( planets[currentPlayer.getPosition()].getPropName()
                    + "\nOwner: " + planets[currentPlayer.getPosition()].getOwnerName()
                    + "\nRent is: " +planets[currentPlayer.getPosition()].getRentPrice());

            //1-----------------MORTGAGE
            //1-isMortgaged check to avoid pay rent for mortgaged planet
            if(planets[currentPlayer.getPosition()].checkMortgaged()){
                payRentButton.setDisable(true);
                closePropButton.setDisable(false);
            }

        }

        //if player comes to his/her own property
        if( planets[currentPlayer.getPosition()].checkHasOwner()
                && (planets[currentPlayer.getPosition()].getOwnerName() == currentPlayer.getName())){

            buyButton.setDisable(true);
            buildButton.setDisable(false);
            payRentButton.setDisable(true);
            //show information about planet, by adding owner player name
            propertyFeature.setText("Welcome to your planet\n"
                    + planets[currentPlayer.getPosition()].getPropName());


            //added here
            if(currentPlayer.getBalance() >= 100 && buildButton.isFocused()){
                //buildButton.setDisable(false);
                buildForestButton.setDisable(false);
                buildHotelButton.setDisable(false);
                buildHouseButton.setDisable(false);
                builtMessageLabel.setText("");
                showBuildStructure();
            }

            if(currentPlayer.getBalance() < 100){
                buildButton.setDisable(true);
                propertyFeature.setText("Welcome to your planet \n"+
                        planets[currentPlayer.getPosition()].getPropName()
                        + " \n Your money is not enough" +
                        " \n for build operation");
            }



        }

        //if planet has no owner, pay rent button is not visible
        //because pay rent is not available for planets that has no owner
        if( !(planets[currentPlayer.getPosition()].checkHasOwner())){

            //if player has no enough money, but button is disabled
            if(currentPlayer.getBalance() < planets[currentPlayer.getPosition()].getPrice()){
                buyButton.setDisable(true);
                //planet can not be mortgaged so change this label
                //to indicate player cant buy planet
                mortgageShowLabel.setText("You don't have money to buy");
            }

            payRentButton.setDisable(true);
            buildButton.setDisable(true);
            closePropButton.setDisable(false);

        }
        /*if(buildButton.isFocused()){
            builtMessageLabel.setText("");
            showBuildStructure();
        }*/
    }

    @FXML
    public void buyPlanet(){
        if(buyButton.isFocused()){
            //if planet has no owner, add it to players title list
            if(!planets[currentPlayer.getPosition()].checkHasOwner()){
                //player buy the planet with buy property method
                currentPlayer.buyProperty(planets[currentPlayer.getPosition()]);

                //make planet hasOwner true
                planets[currentPlayer.getPosition()].setHasOwner(true);
                //buy button will be invisible, since it has owner now

                buyButton.setDisable(true);
                //set owner of the planet

                planets[currentPlayer.getPosition()].setOwner(currentPlayer);

                //indicate planet buy operation is done
                mortgageShowLabel.setText("You Bought This Planet!");
                System.out.println(currentPlayer.getName() + " buy " +currentPlayer.getTitleDeeds().get(0).getPropName());
                //update bank account in bank account table
                changeTable();
            }
        }
    }

    @FXML
    public void closePropertyPane(){
        //make property pane unvisible
        rollDiceBtn.setDisable(false);
        rollDiceBtn.setText("");
        propertyPane.setVisible(false);
        shipPane.setVisible(false);
    }

    @FXML
    AnchorPane mortgagePane;

    @FXML
    Button closeMortgageButton;

    @FXML
    Button okMortgageButton;

    @FXML
    Label showMortgagedPLabel;


    @FXML
    //this method is to make payment for rent of the planets
    public void payRent(){

        //planet's rent  that is at the currentPlayer's location
        int temp1 = planets[currentPlayer.getPosition()].getRentPrice();

        //MORTGAGE
        //22222222-eğer current playerin balance < planet.rent--->mortgage (currentPlayer'a yap)
        if(currentPlayer.getBalance() < temp1){

            //1-open new pane for mortgage
            //2-methodu çağırmadan gerekli olanlar
            okMortgageButton.setDisable(false); //okMortgage is available
            closeMortgageButton.setDisable(true); //close is available after mortgage
            mortgagePane.setVisible(true);

            //---------MORTGAGE FOR PAY RENT FOR PLANET-----------
            ArrayList<String> mortgagedPropertiesNames = new ArrayList<String>();
            mortgageOperation(mortgagedPropertiesNames);
            String nameOfMortgaged = "";
            for(int i =0; i < mortgagedPropertiesNames.size() ; i++){

                nameOfMortgaged += "\nYour planet\n" + mortgagedPropertiesNames.get(i)
                        + " is mortgaged";


            }
            showMortgagedPLabel.setText(nameOfMortgaged + "\n Now you cant receive rent payments");


        }

        else {

            //temp2 = currentPlayers bank account after payment
            int temp2 = currentPlayer.getBalance() - temp1;
            //set current players bank account after payment for rent
            currentPlayer.setBalance(temp2);
        }

        String tempName =planets[currentPlayer.getPosition()].getOwnerName();

        //change bank account of the owner of the planet and show in the bank table
        for(int i = 0; i<names.size(); i++){
            if( names.get(i).getName()==tempName){
                //set owner's bank account
                names.get(i).setBalance(names.get(i).getBalance() + temp1);
                changeTable(names.get(i));
                System.out.println(tempName + "balance " + names.get(i).getBalance());
            }
        }

        System.out.println("After payment." + currentPlayer.getName()
                + "'s balance " +currentPlayer.getBalance());
        //update bank account of current player after payment in bank account table
        changeTable();
        //after payment, make pay button unvisible to avoid multiple payment
        if(payRentButton.isFocused()) {
            payRentButton.setDisable(true);
            closePropButton.setDisable(false);
        }
        //message in the label that indicates payment is done
        rentLabel.setText("payment is \n done!");

    }





    @FXML
    Button fakeCodeButton1;

    public void fakeTestMortgage(){

        names.get(0).setBalance(0);
        changeTable();


    }

    @FXML
    public void acceptMortgage(){

        if(okMortgageButton.isFocused()){
            okMortgageButton.setDisable(true);
            closeMortgageButton.setDisable(false);
            closePropButton.setDisable(false);
        }
        if(closeMortgageButton.isFocused()){
            mortgagePane.setVisible(false);
        }
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
        this.namesForReplay = new ArrayList<Player>();
        this.tokensForReplay = new ArrayList<Token>();
        this.names = names;
        this.tokens = tokens;
        int locationCounter = 0;
        boolean equal = false;
        int locationCounter1 = 0;
        boolean equal1 = false;

        planetsNames = GameInfoReader.getPropertiesNames("PlanetNamesUpdate");
        planetsPositions = GameInfoReader.getPropertiesPositions("PlanetsPositions");
        planetsPrices = GameInfoReader.getPropertiesPrice("PlanetsPrices");
        planetsRentPrices = GameInfoReader.getPropertiesRentPrice("PlanetsRentPrices");
        planetsMortgagePrices = GameInfoReader.getPlanetsMortgagePrice();

        SpaceshipsNames = GameInfoReader.getPropertiesNames("SpaceshipsNames");
        SpaceshipsPositions = GameInfoReader.getPropertiesPositions("SpaceshipsPositions");
        SpaceshipsPrices = GameInfoReader.getPropertiesPrice("SpaceshipsPrices");
        SpaceshipsRentPrices = GameInfoReader.getPropertiesRentPrice("SpaceshipsRentPrices");


        for (int i = 0; i < LOCATION_NUMBER; i++) {
            if ( planetsPositions[locationCounter] == i) {
                equal = true;
                planets[i] = new Planet(planetsNames[locationCounter], new PlanetMortgageStrategy(), planetsPrices[locationCounter],
                        planetsPositions[locationCounter], planetsMortgagePrices[locationCounter], planetsRentPrices[locationCounter]);
            }
            if (equal) {
                locationCounter++;
                equal = false;
            }

            if ( SpaceshipsPositions[locationCounter1] == i) {
                equal1 = true;
                spaceships[i] = new Spaceship(SpaceshipsNames[locationCounter1], new ShipMortgageStrategy(), SpaceshipsPrices[locationCounter1],
                        SpaceshipsPositions[locationCounter1], SpaceshipsPrices[locationCounter1], SpaceshipsRentPrices[locationCounter1]);
            }
            if (equal1) {
                if (locationCounter1 != 3)
                    locationCounter1++;
                equal1 = false;
            }
        }

//        System.out.println(SpaceshipsNames[3]);
//        System.out.println(SpaceshipsPositions[3]);
//        System.out.println(SpaceshipsPrices[3]);
//        System.out.println(SpaceshipsRentPrices[3]);
//
//        System.out.println(spaceships[5].getPropName());
//        System.out.println(spaceships[5].getPosition());
//        System.out.println(spaceships[5].getPrice());
//        System.out.println(spaceships[5].getRentPrice());

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

    //Aliens
    Alien blackHoleAlien = new Alien(1, "Black Hole Alien", "Alien is throwing you into black hole");
    Alien moneyThiefAlien = new Alien(2, "Money Thief Alien", "Alien is stealing your 200M");
    Alien planetThiefAlien = new Alien(3,"Planet Thief Alien", "Alien is seizing a random planet");
    Alien[] aliens = new Alien[]{blackHoleAlien, moneyThiefAlien, planetThiefAlien};

    //Chance cards
    CardDecorator card1 = new AlienAttack(new ChanceCard(1));
    CardDecorator card2 = new PutJail(new ChanceCard(2));
    CardDecorator card3 = new ChangeBankAccount(new ChanceCard(3));
    CardDecorator card4 = new ChangePosition(new ChanceCard(4));
    CardDecorator card5 = new ChangePosition(new ChangeBankAccount(new ChanceCard(5)));
    CardDecorator[] chanceCardsArray =  new CardDecorator[]{card1, card2, card3, card4, card5};

    CardDecorator card6 = new FoundMoney(new ChestCard(6));
    CardDecorator card7 = new FoundMoney(new ChangePosition(new ChestCard(7)));
    CardDecorator card8 = new CovidHelp(new ChestCard(8));
    CardDecorator card9 = new FoundMoney(new CovidHelp(new ChestCard(9)));
    CardDecorator[] chestCardsArray =  new CardDecorator[]{card6, card7, card8, card9};

    public CardDecorator getRandomCard(int num, CardDecorator[] cd) {
        int randomNum = (int)((1 + Math.random()*num) - 1);
        return cd[randomNum];
    }

    int totalDice;

    //turn number
    //if there are 4 players turns is between 0-3
    int turn = 0;
    Player currentPlayer;

    @FXML
    Pane finishPane;

    @FXML
    Button bankruptButton;

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
    Label nextPlayerName;
    @FXML
    Button jailButton;
    @FXML
    Pane jailPane;
    @FXML
    ImageView paneImage;

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
    @FXML
    Label mortgageShowLabel;
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
    //bank account table
    @FXML
    TextArea deedInfo;
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
    Button yesButton;
    @FXML
    Button noButton;
    @FXML
    Pane replayPane;
    //alien
    @FXML
    Pane alienPane;
    @FXML
    Button closeAlien;
    @FXML
    Label alienLabel;
    @FXML
    Label alienNameLabel;
    @FXML
    Label alienDutyLabel;
    @FXML
    Button alienOk;
    @FXML
    Label alienDutyLabel1;


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
        replayPane.setVisible(true);
    }

    @FXML
    void giveUpReplay() {
        replayPane.setVisible(false);
    }

    @FXML
    void replay() throws IOException {
        replayPane.setVisible(false);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("gameBoard.fxml"));
        Parent playerInfoParent = loader.load();

        Scene PlayerInfo = new Scene(playerInfoParent);
        for (int i = 0; i < names.size(); i++) {
            Player player = new Player(names.get(i).getName(), names.get(i).getId());
            Token token = new Token(tokens.get(i).getId());
            namesForReplay.add(player);
            tokensForReplay.add(token);
        }

        GameController controller = loader.getController();
        controller.initial(namesForReplay, tokensForReplay);

        Stage stage2 = new Stage();
        stage2.setTitle("Monopoly Space EDITION - Game Board");
        stage2.setScene(PlayerInfo);
        stage2.setResizable(false);
        stage2.show();

        // closes the current stage
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }

    @FXML
        //this method is to show title Deeds of players
    void showDeeds() throws Exception{
        //if first players button is clicked, show players' title deed
        //String printedDeed = ""; //to print planet names as string
        if(p1DeedButton.isFocused()){
            String player1Props = "";
            //set title of the opened title deed's pane
            deedPaneTitle.setText(p1NameLabel.getText() + "'s Properties");

            if(names.get(0).getTitleDeeds().size()>0) {
                player1Props += "PLANETS\n";
                for (int i = 0; i < names.get(0).getTitleDeeds().size(); i++) {
                    player1Props = player1Props + "\n" + names.get(0).getTitleDeeds().get(i).getPropName();
                }
            }
            if(names.get(0).getSpaceShipDeeds().size()>0) {
                player1Props += "\nSPACESHIPS\n";
                for (int i = 0; i < names.get(0).getSpaceShipDeeds().size(); i++) {
                    player1Props = player1Props + "\n" + names.get(0).getSpaceShipDeeds().get(i).getPropName();
                }
            }

            deedInfo.clear();
            deedInfo.appendText(player1Props);
            scrollPaneDeeds.setContent(deedInfo);

            deedPane.setVisible(true);
        }
        else if(p2DeedButton.isFocused() && names.get(1) != null){
            //set title of the opened title deed's pane
            deedPaneTitle.setText(p2NameLabel.getText() + "'s TitleDeeds");
            String player2Props = "";
            //if player has no propety(players' title deed array is empty)

            if(names.get(1).getTitleDeeds().size()>0) {
                player2Props += "PLANETS\n";
                for (int i = 0; i < names.get(1).getTitleDeeds().size(); i++) {
                    player2Props = player2Props + "\n" + names.get(1).getTitleDeeds().get(i).getPropName();
//
                }
            }
            if(names.get(1).getSpaceShipDeeds().size()>0) {
                player2Props += "\nSPACESHIPS\n";
                for (int i = 0; i < names.get(1).getSpaceShipDeeds().size(); i++) {
                    player2Props = player2Props + "\n" + names.get(1).getSpaceShipDeeds().get(i).getPropName();
                }
            }
            deedInfo.clear();
            deedInfo.appendText(player2Props);
            scrollPaneDeeds.setContent(deedInfo);


            deedPane.setVisible(true);
        }else if(p3DeedButton.isFocused() && names.get(2) != null ){
            //set title of the opened title deed's pane
            deedPaneTitle.setText(p3NameLabel.getText() + "'s TitleDeeds");
            String player3Props = "";
            //if player has no propety(players' title deed array is empty)

            //print player's title deed in the scroll pane
            if(names.get(2).getTitleDeeds().size()>0) {
                player3Props += "PLANETS\n";
                for (int i = 0; i < names.get(2).getTitleDeeds().size(); i++) {
                    player3Props = player3Props + "\n" + names.get(2).getTitleDeeds().get(i).getPropName();
//
                }
            }
            if(names.get(2).getSpaceShipDeeds().size()>0) {
                player3Props += "\nSPACESHIPS\n";
                for (int i = 0; i < names.get(2).getSpaceShipDeeds().size(); i++) {
                    player3Props = player3Props + "\n" + names.get(2).getSpaceShipDeeds().get(i).getPropName();
                }
            }
            deedInfo.clear();
            deedInfo.appendText(player3Props);
            scrollPaneDeeds.setContent(deedInfo);


            deedPane.setVisible(true);
        }else if(p3DeedButton.isFocused() && names.get(3) != null){
            String player4Props = "";
            //set title of the opened title deed's pane
            deedPaneTitle.setText(p4NameLabel.getText() + "'s TitleDeeds");
            //if player has no propety(players' title deed array is empty)



            if(names.get(3).getTitleDeeds().size()>0) {
                player4Props += "PLANETS\n";
                for (int i = 0; i < names.get(3).getTitleDeeds().size(); i++) {
                    player4Props = player4Props + "\n" + names.get(3).getTitleDeeds().get(i).getPropName();
//
                }
            }
            if(names.get(3).getSpaceShipDeeds().size()>0) {
                player4Props += "\nSPACESHIPS\n";
                for (int i = 0; i < names.get(3).getSpaceShipDeeds().size(); i++) {
                    player4Props = player4Props + "\n" + names.get(3).getSpaceShipDeeds().get(i).getPropName();
                }
            }

            deedInfo.clear();
            deedInfo.appendText(player4Props);
            scrollPaneDeeds.setContent(deedInfo);


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
        // comment
    }

    @FXML
        //this method is called when the card is drawn
        // comment & displays a random card name
    void takeChanceCard() throws Exception{
        try{
            //When card is drawn card duty section comes
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Monopoly Space EDITION - Card");
            CardDecorator randomCard = getRandomCard(chanceCardsArray.length, chanceCardsArray);
            alert.setContentText(randomCard.getContent());
            Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("alertOkButton");

            //When ok button is clicked duty is done.

            okButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    randomCard.setTakenBy(currentPlayer);
                    randomCard.duty(currentPlayer);
                    int tempTurn = (turn + (names.size() - 1)) % names.size();
                    //Balance is changing
                    System.out.println(currentPlayer.getName());
                    System.out.println("bank account: " + currentPlayer.getBalance());

                    System.out.println("chanceCard alien invasion came");
                    if(randomCard.equals(card1)){
                        //alien invasion
                        alienPane.setVisible(true);
                        alienOk.setVisible(true);
                        closeAlien.setVisible(false);
                    }


                    System.out.println("inJail = " + currentPlayer.checkJail());
                    if (randomCard.equals(card2)) {
                        //token moves to jail
                        boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                        boardPane.add((tokens.get(tempTurn)).getImageView(), 0, 10);
                    }

                    if (randomCard.equals(card3)) {
                        changeTable();
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
                        boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                        boardPane.add((tokens.get(tempTurn)).getImageView(), 10, 10);
                        currentPlayer.setPosition(0);
                        changeTable();
                    }
                    System.out.println("current player position: " + currentPlayer.getPosition());
                    System.out.println();
                }
            });

            alert.show();

        } catch(Exception e3){
            System.out.println("operation can not be done");
        }
    }

    @FXML
        //this method is called when the card is drawn
        // comment & displays a random card name
    void takeChestCard() throws Exception{
        try{
            //When card is drawn card duty section comes
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Monopoly Space EDITION - Card");
            CardDecorator randomCard = getRandomCard(chestCardsArray.length, chestCardsArray);
            alert.setContentText(randomCard.getContent());
            Button okChestButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            okChestButton.setId("alertOkButton");

            //When ok button is clicked duty is done.

            okChestButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    randomCard.setTakenBy(currentPlayer);
                    randomCard.duty(currentPlayer);
                    int tempTurn = (turn + (names.size() - 1)) % names.size();
                    System.out.println(currentPlayer.getName());
                    System.out.println("bank account: " + currentPlayer.getBalance());

                    //found money
                    if (randomCard.equals(card6)) {
                        System.out.println("card6");
                        System.out.println("You found money in Space " + currentPlayer.getBalance());
                        changeTable();
                    }
                    //found money + change position
                    if (randomCard.equals(card7)) {
                        System.out.println("card7");
                        changeTable();
                        boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                        boardPane.add((tokens.get(tempTurn)).getImageView(), 10, 10);

                    }

                    //covid help
                    if(randomCard.equals(card8)) {
                        System.out.println("card8");
//                        currentPlayer.setPosition(3);
                        boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                        boardPane.add((tokens.get(tempTurn)).getImageView(), 7, 10);
                    }

                    //covid help + found money
                    if(randomCard.equals(card9)) {
                        System.out.println("card9");
                        boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                        boardPane.add((tokens.get(tempTurn)).getImageView(), 7, 10);
                        changeTable();
                    }
                    System.out.println("current player position: " + currentPlayer.getPosition());
                    System.out.println();
                }
            });

            alert.show();

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
        for (int i = 0; i < names.size(); i++) {
            (names.get(i)).setBalance(0);
            if (names.get(i).getNumProperty() == 0) {
                (names.get(i)).setBankrupt();
            }
        }
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
        else if (currentPlayer.getBankrupt()) {
            finishPane.setVisible(true);
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

            if(currentPlayer.getPosition() == 5 || currentPlayer.getPosition() == 15
                    ||currentPlayer.getPosition() == 25 || currentPlayer.getPosition() == 35){

                showSpaceShip();
            }

            if(currentPlayer.getPosition()==4 || currentPlayer.getPosition()==12 || currentPlayer.getPosition()==28 ||
                    currentPlayer.getPosition()==38){
                alienPane.setVisible(true);
                alienOk.setVisible(true);
                closeAlien.setVisible(false);
            }

            if(currentPlayer.getPosition()==7 || currentPlayer.getPosition()==22 || currentPlayer.getPosition()==36  ){
                takeChanceCard();
            }

            if(currentPlayer.getPosition()==2 || currentPlayer.getPosition()==17 || currentPlayer.getPosition()==33  ){
                takeChestCard();
            }

            turn = (turn + 1) % names.size();

            if (!currentPlayer.checkJail() && (currentPlayer.getPosition() == 30 || currentPlayer.getPosition() == 20))  {
                if (currentPlayer.getPosition() == 20) {
                    Image image = new Image(getClass().getResourceAsStream("../img/blackhole.jpeg"));
                    paneImage.setImage(image);
                    jailPane.setVisible(true);
                } else {
                    Image image = new Image(getClass().getResourceAsStream("../img/goToJail.jpeg"));
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
        nextPlayerName.setText("Next Player : " + names.get(turn).getName());

        return updatedPosition;
    }

    public Alien getRandomAlien() {
        int randomNum = (int)((1 + Math.random()*3) - 1);
        return aliens[randomNum];
    }

    @FXML
    public void showAlien() {
        int tempTurn = (turn + (names.size() - 1)) % names.size();

        Alien randomAlien = getRandomAlien();
        randomAlien.alienInvasion(currentPlayer);

        if(alienOk.isFocused()) {
            alienNameLabel.setText(randomAlien.getAlienName());
            alienDutyLabel.setText(randomAlien.getAlienDuty());

            //black hole alien
            if(randomAlien.getAlienId() == 1) {
                //token moves to black hole
                System.out.println("black hole alien came");
                boardPane.getChildren().remove((tokens.get(tempTurn)).getImageView());
                boardPane.add((tokens.get(tempTurn)).getImageView(), 0, 0);
                currentPlayer.setPosition(20);

            }
            //money thief alien (-200M)
            else if(randomAlien.getAlienId() == 2) {
                System.out.println("money thief alien came");
                changeTable();

            }
            //planet thief alien
            else if(randomAlien.getAlienId() == 3) {
                System.out.println("planet thief alien came \n");
                if ((currentPlayer.getTitleDeeds().size() != 0 )) {
                    int randomPlanet = (int)(1 + (Math.random()*(currentPlayer.getTitleDeeds()).size()) - 1);
                    Planet removed = (currentPlayer.getTitleDeeds()).get(randomPlanet);
                    int removedPlanetLocation = removed.getPosition();
//                    System.out.println(planets[removedPlanetLocation].checkHasOwner());
//                    System.out.println(planets[removedPlanetLocation].getRentPrice());
                    planets[removedPlanetLocation] = new Planet(removed.getPropName(), ms, removed.getPrice(), removed.getPosition(),
                             removed.getDefaultMortgagePrice(), removed.getDefaultRentPrice());
                    alienDutyLabel1.setText((removed.getPropName() + " is seized by aliens"));
                    System.out.println("Planet " + (removed.getPropName() + " is seized by aliens"));
//                    System.out.println(planets[removedPlanetLocation].checkHasOwner());
//                    System.out.println(planets[removedPlanetLocation].getRentPrice());
                    currentPlayer.deleteTitleDeed(removed);
                }
                else{
                    alienDutyLabel1.setText(("What a shame! You got no planet, Poor you!"));
                    System.out.println(" What a shame! Poor you! ");
                }
            }

            closeAlien.setVisible(true);
            alienOk.setVisible(false);

        }


    }

    @FXML
    void closeAlienPane(){
        alienNameLabel.setText("");
        alienDutyLabel.setText("");
        alienDutyLabel1.setText("");
        alienPane.setVisible(false);
    }

    @FXML
    void removePlayer() {
        Token currentToken = tokens.get(turn);
        names.remove(currentPlayer);
        boardPane.getChildren().remove((tokens.get(turn)).getImageView());
        tokens.remove(currentToken);
        turn = (turn + 1) % names.size();
        currentPlayer = names.get(turn);
        changeTable();
        finishPane.setVisible(false);
    }

}