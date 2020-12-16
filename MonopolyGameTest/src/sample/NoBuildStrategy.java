package sample;

public class NoBuildStrategy implements BuildStrategy {

    public void build() {
        // TODO - implement NoBuildStrategy.build
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getRentPrice() {
        return 0;
    }

}