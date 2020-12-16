package sample;

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

    public Property(BuildStrategy bs, MortgageStrategy ms, int price, int position,
                    int mortgagePrice, int rentPrice){
        buildStrategy = bs;
        mortgageStrategy = ms;
        this.price = price;
        this.position = position;
        this.mortgagePrice = mortgagePrice;
        this.rentPrice = rentPrice;

        hasOwner = false;
        isMortgaged = false;
    }

    public void performBuild() {
        // TODO - implement Property.performBuild
        throw new UnsupportedOperationException();
    }

    public void performMortgage() {
        // TODO - implement Property.performMortgage
        throw new UnsupportedOperationException();
    }

    public void setMortgageStrategy() {
        // TODO - implement Property.setMortgageStrategy
        throw new UnsupportedOperationException();
    }

    public void setBuildStrategy() {
        // TODO - implement Property.setBuildStrategy
        throw new UnsupportedOperationException();
    }

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
        return owner.getName();
    }

    /**
     *
     * @param owner
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return this.price;
    }

    public int getRentPrice() {
        return this.rentPrice;
    }
}
