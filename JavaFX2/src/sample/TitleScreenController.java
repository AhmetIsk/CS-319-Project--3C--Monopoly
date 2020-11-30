package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class TitleScreenController {

    @FXML
    private Button playBtn;
    @FXML
    private Button quitBtn;
    @FXML
    private Button helpBtn;
    @FXML
    private Button muteBtn;

    public TitleScreenController(Button playBtn, Button quitBtn, Button helpBtn, Button muteBtn) {
        this.playBtn = playBtn;
        this.quitBtn = quitBtn;
        this.helpBtn = helpBtn;
        this.muteBtn = muteBtn;
    }

    public void playButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) playBtn.getScene().getWindow();
        stage.close();
    }

    public void helpButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) helpBtn.getScene().getWindow();
        stage.close();
    }

    public void quitButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
    }

    public void muteButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) muteBtn.getScene().getWindow();
        stage.close();
    }
}
