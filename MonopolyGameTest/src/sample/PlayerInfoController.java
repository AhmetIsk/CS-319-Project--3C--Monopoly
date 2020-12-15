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

    Token token1;
    Token token2;
    Token token3;
    Token token4;

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
    void startPlayPage(){

        ArrayList<String> names = new ArrayList<String>();
        if (pane1.isVisible()) {
            names.add(textField1.getText());
        }
        else if (pane2.isVisible()) {
            names.add(textField1.getText());
            names.add(textField2.getText());
        }
        else if (pane3.isVisible()) {
            names.add(textField1.getText());
            names.add(textField2.getText());
            names.add(textField3.getText());
        }
        else if (pane4.isVisible()){
            names.add(textField1.getText());
            names.add(textField2.getText());
            names.add(textField3.getText());
            names.add(textField4.getText());
        }

        try{
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("gameBoard.fxml"));
            Parent newRoot2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Monopoly Space EDITION - Enter Info");
            stage2.setScene(new Scene(newRoot2));
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
}
