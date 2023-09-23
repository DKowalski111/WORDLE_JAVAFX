package com.example.wordlefx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class GameOverController {
    @FXML
    private Button gameOverYesButton;
    @FXML
    private Button gameOverNoButton;
    @FXML
    private Label gameOverHeader;
    @FXML
    private Label gameOverText;
    @FXML
    private BorderPane gameOverBorderPane;
    public void initialize(){
        if(MainController.getResult()) {
            gameOverBorderPane.getStyleClass().add("game-over-border-pane-win");
            gameOverHeader.getStyleClass().add("game-over-header-win");
            gameOverText.getStyleClass().add("game-over-text-win");
            gameOverYesButton.getStyleClass().add("game-over-yes-button");
            gameOverNoButton.getStyleClass().add("game-over-no-button");
            gameOverHeader.setText("You won!");
        } else {
            gameOverBorderPane.getStyleClass().add("game-over-border-pane-lose");
            gameOverHeader.getStyleClass().add("game-over-header-lose");
            gameOverText.getStyleClass().add("game-over-text-lose");
            gameOverYesButton.getStyleClass().add("game-over-yes-button");
            gameOverNoButton.getStyleClass().add("game-over-no-button");
            gameOverHeader.setText("You lost!");
        }
    }
    public void handleYesButtonClick(){
        GameOver.resetGame();
    }
    public void handleNoButtonClick(){
        System.exit(0);
    }
}
