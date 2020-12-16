package sample;

public class BuildForestStrategy implements BuildStrategy {

    private int forestPrice;
    private int forestRentPrice;

    public BuildForestStrategy(){
        forestPrice = 200;
        forestRentPrice = 150;
    }
    public void build() {
        // TODO - implement BuildForestStrategy.build
        throw new UnsupportedOperationException();
    }

    public int getForestPrice() {
        return this.forestPrice;
    }

    public int getForestRentPrice() {
        return this.forestRentPrice;
    }

}
