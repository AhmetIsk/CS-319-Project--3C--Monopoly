package sample;

public class BuildHouseStrategy implements BuildStrategy {

    private final int housePrice;
    private final int houseRentPrice;

    public BuildHouseStrategy(){
        housePrice = 100;
        houseRentPrice = 50;
    }

    public void build() {
        System.out.println("House is built!");
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

    @Override
    public int getRentPrice(){
        return houseRentPrice;
    }
}
