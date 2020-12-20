package MonopolyLogicManager;

public class Planet extends Property {

    private static final int FOREST_PRICE = 200;
    private static final int HOUSE_PRICE = 100;
    private static final int HOTEL_PRICE = 150;
    private int numHouses;
    private int numHotels;
    private int numForests;


    public Planet(String planetName, MortgageStrategy ms, int price, int position,
                  int mortgagePrice, int rentPrice ){
        super(planetName, ms, price, position, mortgagePrice, rentPrice);

        numHotels = 0;
        numHouses = 0;
        numForests = 0;
    }

    public int getNumHotels() {
        return numHotels;
    }

    public int getNumHouses() {
        return numHouses;
    }

    public int getNumForests() {
        return numForests;
    }

    @Override
    public void performMortgage() {
        if(!super.checkMortgaged() && super.checkHasOwner()){
            int addedMortgagePrice = 0;
            if( numHotels > 0 || numHouses > 0 || numForests > 0 ){
                addedMortgagePrice = ((numForests * FOREST_PRICE) + (numHotels * HOTEL_PRICE) +(numHouses * HOUSE_PRICE)) / 2;
            }

            super.setMortgagePrice(super.getPrice() + addedMortgagePrice);
            super.getMortgageStrategy().mortgage();
            super.setIsMortgage(true);
            //super.getOwner().deleteTitleDeed(this);
        }
    }

    public void getCurrentInfoStructures(){
        System.out.println("Houses: " + numHouses);
        System.out.println("Hotels: " + numHotels );
        System.out.println("Forests: " + numForests );
    }


    public void performBuild(BuildStrategy bs){
        if (super.checkHasOwner()){
            bs.build(this, super.getOwner());
            if(bs.getPrice() == FOREST_PRICE){
                numForests++;
            }
            if(bs.getPrice() == HOUSE_PRICE){
                numHouses++;
            }
            if(bs.getPrice() == HOTEL_PRICE){
                numHotels++;
            }
        }
    }


}
