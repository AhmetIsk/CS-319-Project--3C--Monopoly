package MonopolyLogicManager;

public interface BuildStrategy {
    void build(Property property, Player player);
    int getPrice();
    void getBuildMessage();
}
