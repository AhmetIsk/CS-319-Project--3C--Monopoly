package sample;

public class NoBuildStrategy implements BuildStrategy {


    @Override
    public void build(Property property, Player player) {
        System.out.println("Nothing is built!");
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void getBuildMessage() {

    }


}