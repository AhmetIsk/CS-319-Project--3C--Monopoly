package MonopolyLogicManager;

public class Alien {

    private int alienId;
    private String alienName;
    private String alienDuty;

    public Alien(int id, String name, String duty) {
        alienId = id;
        alienName = name;
        alienDuty = duty;
    }

    public int getAlienId() {
        return this.alienId;
    }

    /**
     *
     * @param alienId
     */
    public void setAlienId(int alienId) {
        this.alienId = alienId;
    }

    public String getAlienName() {
        return this.alienName;
    }

    /**
     *
     * @param alienName
     */
    public void setAlienName(String alienName) {
        this.alienName = alienName;
    }

    public String getAlienDuty() {
        return this.alienDuty;
    }

    /**
     *
     * @param duty
     */
    public void setAlienDuty(String duty) {
        this.alienDuty = duty;
    }

    public void alienInvasion(Player player) {
        if (this.getAlienId() == 1) {
            //put black hole
            player.setInJail();
            player.setPosition(20);
        }
        else if (this.getAlienId() == 2) {
            //change bank account
            int newBalance = (player.getBalance() - 200);
            player.setBalance(newBalance);
        }
        else if (this.getAlienId() == 3){
            //seize a property
        }
    }



}
