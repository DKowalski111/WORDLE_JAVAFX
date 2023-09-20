package com.example.wordlefx;

import com.example.elements.BlockGrid;
import com.example.elements.Keyboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class MainController {
    private BlockGrid blockGrid = BlockGrid.getInstance();
    private Keyboard keyboard = Keyboard.getInstance();
    @FXML
    private GridPane mainGridPane;
    @FXML
    private GridPane keyboardGridPane;

    public void initialize(){
        createGrid();
    }
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent){
        BlockGrid.getInstance().addLetter(keyEvent.getCode());
    }
    private void createGrid(){
        blockGrid.createGrid(mainGridPane);
        keyboard.createGrid(keyboardGridPane);
    }
}