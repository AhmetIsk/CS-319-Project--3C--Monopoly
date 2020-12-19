package sample;

public class BuildForestStrategy implements BuildStrategy {

    private int forestPrice;
    private int forestRentPrice;

    public BuildForestStrategy(){
        forestPrice = 200;
        forestRentPrice = 150;
    }

    @Override
    public void build(Property property, Player player) {
        player.makePayment(forestPrice);
        property.setRentPrice(property.getRentPrice() + forestRentPrice);
        System.out.println("Forest is built!" );
    }

    @Override
    public int getPrice(){
        return this.forestPrice;
    }

    public int getForestPrice() {
        return this.forestPrice;
    }

    public int getForestRentPrice() {
        return this.forestRentPrice;
    }

}
