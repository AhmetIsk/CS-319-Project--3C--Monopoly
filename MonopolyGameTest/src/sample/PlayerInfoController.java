package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayerInfoController implements Initializable{


    //this function is to go to help page
    @FXML
    public void keepNames() {

    }

    @FXML
    void closeToBack() throws Exception{

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
            Parent newRoot = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Monopoly Space Edition");
            stage.setScene(new Scene(newRoot));
            stage.setResizable(false);
            stage.show();

            // to make operation on the stage
            Stage stage2 = (Stage) backBtn2.getScene().getWindow();
            // to close window
            stage2.close();

        } catch(Exception e){
            System.out.println("operation can not be done");
        }
    }

    @FXML
    void getContentsOfFirstPlayer() {
        if (pane1.isVisible()) {
            pane1.setVisible(false);
        }
        else {
            pane1.setVisible(true);
        }
    }

    @FXML
    void getContentsOfSecondPlayer() {
        if (pane2.isVisible()) {
            pane2.setVisible(false);
        }
        else if (radioBtn1.isSelected()){
            pane2.setVisible(true);
        }
    }

    @FXML
    void getContentsOfThirdPlayer() {
        if (pane3.isVisible()) {
            pane3.setVisible(false);
        }
        else if (radioBtn1.isSelected() && radioBtn2.isSelected()){
            pane3.setVisible(true);
        }
    }

    @FXML
    void getContentsOfLastPlayer() {
        if (pane4.isVisible()) {
            pane4.setVisible(false);
        }
        else if (radioBtn1.isSelected() && radioBtn2.isSelected() && radioBtn3.isSelected()){
            pane4.setVisible(true);
        }
    }

    @FXML
    void getTokenOfPlayers() {

    }


    @FXML
    void startPlayPage(){
        ToggleButton[] toggleButtons1 = new ToggleButton[]{btn1, btn2, btn3, btn4, btn5};
        ToggleButton[] toggleButtons2 = new ToggleButton[]{btn11, btn21, btn31, btn41, btn51};
        ToggleButton[] toggleButtons3 = new ToggleButton[]{btn111, btn211, btn311, btn411, btn511};
        ToggleButton[] toggleButtons4 = new ToggleButton[]{btn1111, btn2111, btn3111, btn4111, btn5111};

        ArrayList<Token> tokens = new ArrayList<Token>();
        ArrayList<String> names = new ArrayList<String>();

        if (pane1.isVisible() && !pane2.isVisible()) {
            names.add(textField1.getText());
            for (int i = 0; i < 5; i++) {
                System.out.println();
                if (toggleButtons1[i] == group1.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
//                    System.out.println(token.getDirectory());
                }
            }
        }
        else if (pane2.isVisible() && !pane3.isVisible()) {
            names.add(textField1.getText());
            names.add(textField2.getText());

            for (int i = 0; i < 5; i++) {
                if (toggleButtons1[i] == group1.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
                    // System.out.println(token.getDirectory());
                }
            }
            for (int i = 0; i < 5; i++) {
                if (toggleButtons2[i] == group11.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
                    // System.out.println(token.getDirectory());
                }
            }
        }
        else if (pane3.isVisible() && !pane4.isVisible()) {
            names.add(textField1.getText());
            names.add(textField2.getText());
            names.add(textField3.getText());

            for (int i = 0; i < 5; i++) {
                if (toggleButtons1[i] == group1.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
//                     System.out.println(token.getDirectory());
                }
            }
            for (int i = 0; i < 5; i++) {
//                System.out.println("buraya geldi");
                if (toggleButtons2[i] == group11.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
//                     System.out.println(token.getDirectory());
                }
            }
            for (int i = 0; i < 5; i++) {
                if (toggleButtons3[i] == group111.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
//                     System.out.println(token.getDirectory());
                }
            }
        }
        else if (pane4.isVisible()){
            names.add(textField1.getText());
            names.add(textField2.getText());
            names.add(textField3.getText());
            names.add(textField4.getText());

            for (int i = 0; i < 5; i++) {
                if (toggleButtons1[i] == group1.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
                    // System.out.println(token.getDirectory());
                }
            }
            for (int i = 0; i < 5; i++) {
                if (toggleButtons2[i] == group11.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
                    // System.out.println(token.getDirectory());
                }
            }
            for (int i = 0; i < 5; i++) {
                if (toggleButtons3[i] == group111.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
                    // System.out.println(token.getDirectory());
                }
            }
            for (int i = 0; i < 5; i++) {
                if (toggleButtons4[i] == group1111.getSelectedToggle()) {
                    Token token = new Token(i + 1);
                    tokens.add(token);
                    // System.out.println(token.getDirectory());
                }
            }
        }

        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("gameBoard.fxml"));
            Parent playerInfoParent = loader.load();

            Scene PlayerInfo = new Scene(playerInfoParent);

            GameController controller = loader.getController();
            controller.initial(names, tokens);

//            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("gameBoard.fxml"));
            //GameController gameController = new GameController(names, tokens);
//            Parent newRoot2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Monopoly Space EDITION - Enter Info");
            stage2.setScene(PlayerInfo);
            stage2.setResizable(false);
            stage2.show();

            // closes the current stage
            Stage stage = (Stage) startBtn.getScene().getWindow();
            stage.close();


        } catch(Exception e2){
            System.out.println("operation can not be done");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    ToggleButton btn1;
    @FXML
    ToggleButton btn2;
    @FXML
    ToggleButton btn3;
    @FXML
    ToggleButton btn4;
    @FXML
    ToggleButton btn5;
    @FXML
    ToggleButton btn11;
    @FXML
    ToggleButton btn21;
    @FXML
    ToggleButton btn31;
    @FXML
    ToggleButton btn41;
    @FXML
    ToggleButton btn51;
    @FXML
    ToggleButton btn111;
    @FXML
    ToggleButton btn211;
    @FXML
    ToggleButton btn311;
    @FXML
    ToggleButton btn411;
    @FXML
    ToggleButton btn511;
    @FXML
    ToggleButton btn1111;
    @FXML
    ToggleButton btn2111;
    @FXML
    ToggleButton btn3111;
    @FXML
    ToggleButton btn4111;
    @FXML
    ToggleButton btn5111;

    @FXML
    ToggleGroup group1;

    @FXML
    ToggleGroup group11;

    @FXML
    ToggleGroup group111;

    @FXML
    ToggleGroup group1111;

    @FXML
    Button backBtn2;

    @FXML
    RadioButton radioBtn1;

    @FXML
    RadioButton radioBtn2;

    @FXML
    RadioButton radioBtn3;

    @FXML
    RadioButton radioBtn4;

    @FXML
    Button startBtn;

    @FXML
    DialogPane dialogPane;

    @FXML
    Pane pane1;

    @FXML
    Pane pane2;

    @FXML
    Pane pane3;

    @FXML
    Pane pane4;

    @FXML
    TextField textField1;

    @FXML
    TextField textField2;

    @FXML
    TextField textField3;

    @FXML
    TextField textField4;

    @FXML
    ImageView imageView;
    @FXML
    GridPane gridPane;
}
