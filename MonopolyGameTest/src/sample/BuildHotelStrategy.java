package sample;

public class BuildHotelStrategy implements BuildStrategy {

    private final int hotelPrice;
    private final int hotelRentPrice;

    public BuildHotelStrategy(){
        hotelPrice = 150;
        hotelRentPrice = 100;
    }
    public void build() {
        // TODO - implement BuildHotelStrategy.build
        throw new UnsupportedOperationException();
    }

    public int getHotelPrice() {
        return this.hotelPrice;
    }

    public int getHotelRentPrice() {
        return this.hotelRentPrice;
    }

}