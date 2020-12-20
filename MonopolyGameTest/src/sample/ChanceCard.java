package sample;

public class ChanceCard extends Card{

   // CardDecorator card;

    public ChanceCard(int id){
        //this.card=card;
        this.id=id;
        content = "Chance Card Duty: ";
    }


    @Override
    public void duty(Player player) {

    }
}
