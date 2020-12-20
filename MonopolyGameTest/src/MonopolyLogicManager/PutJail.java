package MonopolyLogicManager;

public class PutJail extends CardDecorator{

    public PutJail(){

    }

    Card card;
    public PutJail(Card card){
        this.card = card;
    }

    @Override
    public String getContent() {
        return card.getContent() + "Go To Jail.";
    }

    @Override
    public void duty(Player player) {
        player.setInJail();
    }

}
