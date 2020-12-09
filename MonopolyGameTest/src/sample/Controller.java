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

public class Controller implements Initializable {

    @FXML
    Button closeBtn;

    @FXML
    Button helpBtn;

    @FXML
    Button plyBtn;


    @FXML
    void closeView(){

        // to make operation on the stage
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        // to close window
        stage.close();
    }

   @FXML
   void showHelp()  {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HelpPage.fxml"));
            Parent newRoot = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Monopoly Space EDITION - Help Page");
            stage.setScene(new Scene(newRoot));
            stage.show();
       } catch(Exception e){
            System.out.println("operation can not be done");
       }

   }

    @FXML
    void goForPlay()  {
        try{
            //change the name
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EnterInfo.fxml"));
            Parent newRoot = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Monopoly Space EDITION - Enter Info Page");
            stage.setScene(new Scene(newRoot));
            stage.show();
        } catch(Exception e){
            System.out.println("operation can not be done");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
