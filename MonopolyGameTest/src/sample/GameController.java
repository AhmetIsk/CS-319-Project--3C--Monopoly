//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameController implements Initializable{

    @FXML
    Button finishBtn;

    @FXML
    void closeGame(){
        // to make operation on the stage
        Stage stage = (Stage) finishBtn.getScene().getWindow();
        // to close window
        stage.close();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
