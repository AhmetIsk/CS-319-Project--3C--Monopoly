package sample;

public class ChangePosition extends CardDecorator{

    Card card;
    public ChangePosition(Card card){
        this.card = card;
    }

    @Override
    public String getContent() {
        return card.getContent() + "Move to ...";
    }

    @Override
    public void duty() {

    }
}
