package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


       /* Card card2 = new ChanceCard(1);
        card2 = new AlienAttack(card2);
        System.out.println(card2.getContent());*/

        Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));

        primaryStage.setTitle("Monopoly Space Edition");
        primaryStage.setScene(new Scene(root, 1024 , 768));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
