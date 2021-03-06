package MonopolyLogicManager;

import java.util.*;

public class Player {
    private final String name;
    private final int id;
    private int balance;
    private int position;
    private int numProperty;
    private boolean bankrupt;
    private int jailDayCounter;

    private ArrayList<Planet> titleDeeds;
    private ArrayList<Spaceship> spaceShipDeeds;
    //private final Token token; //???
    //comment

    private final boolean hasCards;

    private boolean inJail = false;
    private final boolean buyProperty;
    private final boolean buildStructure;
    private final boolean passFromStart;
    private final boolean loseGame;



    public Player(String name, int id){
        this.name = name;
        this.id = id;
        balance = 2000;
        position = 0;
        numProperty = 0;
        jailDayCounter = 0;
        titleDeeds = new ArrayList<Planet>();
        spaceShipDeeds = new ArrayList<Spaceship>();
        //token = new Token();

        hasCards = false;
        bankrupt = false;
        inJail = false;
        buyProperty = false;
        buildStructure = false;
        passFromStart = false;
        loseGame = false;


    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getNumProperty() {
        return this.numProperty;
    }


    /**
     *
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPosition() {
        return this.position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<Planet> getTitleDeeds() {
        return this.titleDeeds;
    }

    public ArrayList<Spaceship> getSpaceShipDeeds() {
        return this.spaceShipDeeds;
    }

    /**
     *
     * @param p
     */
    public void deleteTitleDeed(Property p) {
        if(titleDeeds.contains(p)){
            titleDeeds.remove(p);
            numProperty--;
        }
    }


    /**
     *
     * @param num
     */
    public void movePlayer(int num) {
        position = position + num;
        if(position > 39){
            position = position % 39;
        }
    }

    /**
     *
     * @param payment
     */
    public void getPaid(int payment) {
        balance = balance + payment;
    }

    public boolean checkJail() {
        return inJail;
    }

    public int getJailDayCounter() {
        return jailDayCounter;
    }

    public void setJailDayCounter(int jailDayCounter) {
        this.jailDayCounter = jailDayCounter;
    }

    public void setInJail() {
        inJail = true;
        this.setPosition(10);

    }

    public void exitJail() {
        inJail = false;
        jailDayCounter = 0;
    }

    public boolean checkBuyProperty() {
        return buyProperty;
    }

    public boolean getBankrupt(){return this.bankrupt;}

    public void setBankrupt(){this.bankrupt = true;}

    /**
     *
     * @param p
     */
    public void makePayment(Player p, int payment) {
        this.balance = balance - payment;
        p.getPaid(payment);
    }

    public void makePayment( int payment) {
        this.balance = balance - payment;
    }

    /**
     *
     * @param
     */
    public void buyProperty(Planet p) {
        if(!(titleDeeds.contains(p)) ) {

            titleDeeds.add(p);
            p.setHasOwner(true);
            this.setBalance(this.getBalance() - p.getPrice());
            numProperty++;
            //balance = balance - p.getPrice()
        }

    }

    /**
     *
     * @param
     */
    public void buySpaceShip(Spaceship s) {

        if(!(spaceShipDeeds.contains(s)) ) {
            spaceShipDeeds.add(s);
            s.setHasOwner(true);
            this.setBalance(this.getBalance() - s.getPrice());
            numProperty++;
        }
    }



    public boolean checkBuildStructure() {
        return buildStructure;
    }
}
