package com.example.wordlefx;

import com.example.elements.BlockGrid;
import com.example.elements.Database;
import com.example.elements.Keyboard;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainController {
    private BlockGrid blockGrid = BlockGrid.getInstance();
    private Keyboard keyboard = Keyboard.getInstance();
    @FXML
    private GridPane mainGridPane;
    @FXML
    private GridPane keyboardGridPane;

    public void initialize(){
        Database.getInstance();
        createGrid();
        Platform.runLater(() -> mainGridPane.requestFocus());
    }
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent){
        System.out.println(keyEvent);
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            BlockGrid.getInstance().checkWord();
        } else if(keyEvent.getCode().equals(KeyCode.BACK_SPACE)){
            BlockGrid.getInstance().backspace();
        } else{
            BlockGrid.getInstance().addLetter(keyEvent.getCode());
        }
    }
    private void createGrid(){
        blockGrid.createGrid(mainGridPane);
        keyboard.createGrid(keyboardGridPane);
    }
}