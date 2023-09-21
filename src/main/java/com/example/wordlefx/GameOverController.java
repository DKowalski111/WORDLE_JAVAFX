package com.example.wordlefx;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class GameOverController {
    @FXML
    private BorderPane gameOverBorderPane;
    public void initialize(){
        gameOverBorderPane.getStyleClass().add("border-pane-disabled");
    }
}
