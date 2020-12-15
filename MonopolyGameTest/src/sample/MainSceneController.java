package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

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

   //@FXML
   public void showHelp() throws Exception {


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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlayerInfo.fxml"));
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
