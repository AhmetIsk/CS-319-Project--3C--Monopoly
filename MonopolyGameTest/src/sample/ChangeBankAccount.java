package sample;

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
    public void duty() {
        int newBalance = (takenBy.getBalance() - 100);
        takenBy.setBalance(newBalance);
    }
}
