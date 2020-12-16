package sample;

public class BuildHouseStrategy implements BuildStrategy {

    private final int housePrice;
    private final int houseRentPrice;

    public BuildHouseStrategy(){
        housePrice = 100;
        houseRentPrice = 50;
    }

    public void build() {
        // TODO - implement BuildHouseStrategy.build
        throw new UnsupportedOperationException();
    }

    public int getHousePrice() {
        return this.housePrice;
    }

    public int getHouseRentPrice() {
        return this.houseRentPrice;
    }

}
