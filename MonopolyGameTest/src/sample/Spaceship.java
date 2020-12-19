package sample;

public class Spaceship extends Property{
    public Spaceship(String shipName, MortgageStrategy ms, int price, int position,
                     int mortgagePrice, int rentPrice) {
        super(shipName,ms, price, position, mortgagePrice, rentPrice);
    }



    @Override
    public void performMortgage() {
        if(!super.checkMortgaged()){
            super.setMortgagePrice(super.getPrice());
            super.getMortgageStrategy().mortgage();
            super.setIsMortgage(true);
            super.getOwner().deleteTitleDeed(this);
        }

    }
}
