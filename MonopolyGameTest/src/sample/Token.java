package sample;

import javafx.scene.image.ImageView;

public class Token {

    final String tokenName;
    final String directory;
    final int id;
    ImageView imageView;

    public Token(int id) {
        this.id = id;
        this.tokenName = "token" + String.valueOf(id);
        this.directory = "../img/" + tokenName + ".png";
    }

    public int getId() {
        return id;
    }
    public String getTokenName() {
        return tokenName;
    }

    public String getDirectory() {
        return directory;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
