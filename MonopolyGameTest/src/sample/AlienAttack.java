package sample;

public class AlienAttack extends CardDecorator{
    public AlienAttack() {
    }

    Card card;

    public AlienAttack(Card card){
        this.card = card;
    }

    @Override
    public String getContent() {

        return card.getContent() + "Alien Attack.";
    }

    @Override
    public void duty(Player player) {

        int[] alienPositonArray = new int[]{4,12,28,38};
        int randomNum = (int)((1 + Math.random()*4) - 1);
        System.out.println("*******************" + alienPositonArray[randomNum]);
        player.setPosition(alienPositonArray[randomNum]);

    }


}
