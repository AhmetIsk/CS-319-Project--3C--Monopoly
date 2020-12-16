package sample;

public class BuildHotelStrategy implements BuildStrategy {

    private final int hotelPrice;
    private final int hotelRentPrice;

    public BuildHotelStrategy(){
        hotelPrice = 150;
        hotelRentPrice = 100;
    }
    public void build() {
        System.out.println("Hotel is built!");
    }

    @Override
    public int getPrice() {
        return hotelPrice;
    }

    @Override
    public int getRentPrice() {
        return hotelRentPrice;
    }

    public int getHotelPrice() {
        return this.hotelPrice;
    }

    public int getHotelRentPrice() {
        return this.hotelRentPrice;
    }

}