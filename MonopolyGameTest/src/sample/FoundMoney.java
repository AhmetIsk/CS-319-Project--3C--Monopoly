package sample;

public class FoundMoney extends CardDecorator{

    public FoundMoney(){

    }
    Card card;

    public FoundMoney(Card card){
        this.card = card;
    }

    @Override
    public String getContent() {
        return card.getContent() + "You found 150M in Space ";
    }

    @Override
    public void duty(Player player) {
        int newBalance = (player.getBalance() + 150);
        player.setBalance(newBalance);
    }
}
