package sample;

public class Spaceship extends Property{
    public Spaceship(String shipName,BuildStrategy bs, MortgageStrategy ms, int price, int position,
                     int mortgagePrice, int rentPrice) {
        super(shipName,bs, ms, price, position, mortgagePrice, rentPrice);
    }
}
