package sample;

public class BuildHotelStrategy implements BuildStrategy {

    private final int hotelPrice;
    private final int hotelRentPrice;

    public BuildHotelStrategy(){
        hotelPrice = 150;
        hotelRentPrice = 100;
    }

    @Override
    public void build(Property property, Player player) {
        player.makePayment(hotelPrice);
        property.setRentPrice(property.getRentPrice() + hotelRentPrice);
        System.out.println("Hotel is built!");
    }


    @Override
    public int getPrice() {
        return hotelPrice;
    }


    public int getHotelPrice() {
        return this.hotelPrice;
    }

    public int getHotelRentPrice() {
        return this.hotelRentPrice;
    }

}