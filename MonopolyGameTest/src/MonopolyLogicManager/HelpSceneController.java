package MonopolyLogicManager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelpSceneController implements Initializable{


    @FXML
    Button backBtn;

    @FXML
    Button playBtn;

    @FXML
    Button quitBtn;


    //this function is to go to main page
    @FXML
    void closeToBackMain() throws Exception {

        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
        Parent newRoot = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Monopoly Space Edition");
        stage.setScene(new Scene(newRoot));
        stage.setResizable(false);
        stage.show();

        // to make operation on the stage
        Stage stage2 = (Stage) backBtn.getScene().getWindow();
        // to close window
        stage2.close();

        } catch(Exception e){
            System.out.println("operation can not be done");
        }
    }

    //this function is to close the help page window
    //same as the function above
    @FXML
    void quitScene(){

        // to make operation on the stage
        Stage stage2 = (Stage) quitBtn.getScene().getWindow();
        // to close window
        stage2.close();
    }

    @FXML
    void goToPlayPage(){
        //l1.setText("Play button clicked");
        try{
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("PlayerInfo.fxml"));
            Parent newRoot2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Monopoly Space EDITION - Enter Info");
            stage2.setScene(new Scene(newRoot2));
            stage2.setResizable(false);
            stage2.show();
        } catch(Exception e2){
            System.out.println("operation can not be done");
        }

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
