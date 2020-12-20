package MonopolyLogicManager;

public abstract class Property {
    private BuildStrategy buildStrategy;
    private MortgageStrategy mortgageStrategy;
    private int price;
    private boolean hasOwner;
    private int position;
    private int mortgagePrice;
    private boolean isMortgaged;
    private Player owner;
    private int rentPrice;
    private String propName;
    private int defaultMortgagePrice;
    private int defaultRentPrice;



    public Property(String propName, MortgageStrategy ms, int price, int position,
                    int mortgagePrice, int rentPrice){
        this.propName = propName;
        buildStrategy = new NoBuildStrategy(); //nothing is built yet
        mortgageStrategy = ms;
        this.price = price;
        this.position = position;
        this.mortgagePrice = mortgagePrice;
        this.rentPrice = rentPrice;
        this.defaultMortgagePrice = mortgagePrice;
        this.defaultRentPrice = rentPrice;

        hasOwner = false;
        isMortgaged = false;
    }

    public void setHasOwner(boolean set){
        this.hasOwner = set;
    }
    public String getPropName() {
        return propName;
    }

    public void givePlayer(Player p){
        owner = p;
        hasOwner = true;
    }


    public abstract void performMortgage();


    /**
     *
     * @param rentPrice
     */
    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
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

    public int getMortgagePrice() {
        return this.mortgagePrice;
    }

    /**
     *
     * @param mortgagePrice
     */
    public void setMortgagePrice(int mortgagePrice) {
        this.mortgagePrice = mortgagePrice;
    }

    public boolean checkMortgaged() {
        return isMortgaged;
    }

    public boolean checkHasOwner() {
        return hasOwner;
    }

    public String getOwnerName() {
        if (owner == null)
            return "";
        return owner.getName();
    }

    /**
     *
     * @param owner
     */
    public void setOwner(Player owner) {

        this.owner = owner;
        hasOwner = true;
    }

    public Player getOwner(){
        return owner;
    }

    public int getPrice() {
        return this.price;
    }

    public int getRentPrice() {
        return this.rentPrice;
    }

    public   MortgageStrategy getMortgageStrategy(){
        return mortgageStrategy;
    }

    public void setIsMortgage(boolean set){
        isMortgaged = set;
    }

    public int getDefaultMortgagePrice() {
        return defaultMortgagePrice;
    }

    public int getDefaultRentPrice() {
        return defaultRentPrice;
    }
}
