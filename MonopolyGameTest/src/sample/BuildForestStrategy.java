package sample;

public class BuildForestStrategy implements BuildStrategy {

    private int forestPrice;
    private int forestRentPrice;

    public BuildForestStrategy(){
        forestPrice = 200;
        forestRentPrice = 150;
    }
    public void build() {
        System.out.println("Forest is built!");
    }

    @Override
    public int getPrice() {
        return forestPrice;
    }

    @Override
    public int getRentPrice() {
        return forestRentPrice;
    }

    public int getForestPrice() {
        return this.forestPrice;
    }

    public int getForestRentPrice() {
        return this.forestRentPrice;
    }

}
