package sample;

public class ChangePosition extends CardDecorator{

    public ChangePosition(){

    }

    Card card;
    public ChangePosition(Card card){
        this.card = card;
    }

    @Override
    public String getContent() {
        return card.getContent() + "\nMove to Start Location";
    }

    @Override
    public void duty() {
        takenBy.setPosition(0);
    }
}
