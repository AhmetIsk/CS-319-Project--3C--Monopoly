package MonopolyLogicManager;

public class ChangeBankAccount extends CardDecorator{

    public ChangeBankAccount(){

    }
    Card card;
    public ChangeBankAccount(Card card){
        this.card = card;
    }

    @Override
    public String getContent() {
        return card.getContent() + "Your Bank Account will be changed.";
    }

    @Override
    public void duty(Player player) {
        card.duty(player);
        int newBalance = (player.getBalance() - 100);
        player.setBalance(newBalance);
    }
}
