package sample;

public class Token {

    final String tokenName;
    final String directory;

    public Token(String tokenName) {
        this.tokenName = tokenName;
        this.directory = "@../img/" + tokenName + ".png";
    }

    public String getTokenName() {
        return tokenName;
    }

    public String getDirectory() {
        return directory;
    }
}
