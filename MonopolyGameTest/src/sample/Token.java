package sample;

public class Token {

    final String tokenName;
    final String directory;

    public Token(int id) {
        this.tokenName = "token" + String.valueOf(id);
        this.directory = "@../img/" + tokenName + ".png";
    }

    public String getTokenName() {
        return tokenName;
    }

    public String getDirectory() {
        return directory;
    }
}
