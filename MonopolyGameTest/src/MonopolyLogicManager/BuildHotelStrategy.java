package MonopolyLogicManager;

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
    }


    @Override
    public int getPrice() {
        return hotelPrice;
    }

    @Override
    public void getBuildMessage() {
        System.out.println("Hotel is built!");
    }


    public int getHotelPrice() {
        return this.hotelPrice;
    }

    public int getHotelRentPrice() {
        return this.hotelRentPrice;
    }

}