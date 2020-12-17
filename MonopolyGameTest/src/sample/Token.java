package sample;

import javafx.scene.image.ImageView;

public class Token {

    final String tokenName;
    final String directory;
    ImageView imageView;

    public Token(int id) {
        this.tokenName = "token" + String.valueOf(id);
        this.directory = "../img/" + tokenName + ".png";
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
