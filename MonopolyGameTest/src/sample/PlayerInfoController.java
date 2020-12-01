package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerInfoController implements Initializable{

    @FXML
    Button backBtn2;

    @FXML
    Button startBtn;

    //this function is to go to help page
    @FXML
    void closeToBack(){

        // to make operation on the stage
        Stage stage3 = (Stage) backBtn2.getScene().getWindow();
        // to close window
        stage3.close();
    }

    @FXML
    void startPlayPage(){
        try{
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("gameBoard.fxml"));
            Parent newRoot2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Monopoly Space EDITION - Enter Info");
            stage2.setScene(new Scene(newRoot2));
            stage2.show();
        } catch(Exception e2){
            System.out.println("operation can not be done");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
