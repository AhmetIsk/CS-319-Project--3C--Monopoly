package sample;

public abstract class Card {
    String content;
    int id;
    Player takenBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Player getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(Player player) {
        takenBy = player;
    }

    public abstract void duty(Player player);
}
