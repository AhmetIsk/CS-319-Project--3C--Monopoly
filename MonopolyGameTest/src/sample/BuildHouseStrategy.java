package sample;

import java.util.PropertyPermission;

public class BuildHouseStrategy implements BuildStrategy {

    private final int housePrice;
    private final int houseRentPrice;

    public BuildHouseStrategy(){
        housePrice = 100;
        houseRentPrice = 50;
    }

    @Override
    public void build(Property property, Player player) {
        System.out.println("House is built!" );
        player.makePayment(housePrice);
        property.setRentPrice(property.getRentPrice() + houseRentPrice);
    }

    public int getHousePrice() {
        return this.housePrice;
    }

    public int getHouseRentPrice() {
        return this.houseRentPrice;
    }



    @Override
    public int getPrice() {
        return housePrice;
    }

}
