package sample;

public class Planet extends Property {

    private int totalRent;
    private int numHouses;
    private int numHotels;
    private int numForests;


    public Planet(String planetName,BuildStrategy bs, MortgageStrategy ms, int price, int position,
                  int mortgagePrice, int rentPrice ){
        super(planetName,bs, ms, price, position, mortgagePrice, rentPrice);

        totalRent = 0;
        numHotels = 0;
        numHouses = 0;
        numForests = 0;
    }




    public int getTotalRent() {
        return this.totalRent;
    }

    /**
     *
     * @param totalRent
     */
    public void updateTotalRent(int totalRent) {
        this.totalRent = totalRent;
    }

}
