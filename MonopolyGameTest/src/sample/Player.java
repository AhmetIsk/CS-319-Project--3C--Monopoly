package sample;

import java.util.*;

public class Player {
    private final String name;
    private final int id;
    private int balance;
    private int position;
    private int numProperty;
    private int numCards;

    private final ArrayList<Property> titleDeeds;
    private final ArrayList<Card> ownedCards; //added
    //private final Token token; //???

    private final boolean hasCards;
    private final boolean bankrupt;
    private boolean inJail;
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
        numCards = 0;

        titleDeeds = new ArrayList<Property>();
        ownedCards = new ArrayList<Card>();
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

    public int getNumCards() {
        return this.numCards;
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

    public ArrayList<Property> getTitleDeeds() {
        return this.titleDeeds;
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
     * @param p
     */
    public void addTitleDeeds(Property p) {
        if(!(titleDeeds.contains(p)) ){
            titleDeeds.add(p);
            numProperty++;
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

    public void setInJail() {
        inJail = true;
    }

    public boolean checkBuyProperty() {
        return buyProperty;
    }

    /**
     *
     * @param p
     */
    public void makePayment(Player p, int payment) {
        this.balance = balance - payment;
        p.getPaid(payment);
    }

    /**
     *
     * @param p
     */
    public void buyProperty(Property p) {
        if(buyProperty){
            titleDeeds.add(p);
            //balance = balance - p.getPrice()
        }
    }

    public boolean checkBuildStructure() {
        return buildStructure;
    }
}
