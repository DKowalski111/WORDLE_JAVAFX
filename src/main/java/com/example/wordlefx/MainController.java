package com.example.wordlefx;

import com.example.elements.Block;
import com.example.elements.BlockGrid;
import com.example.elements.Database;
import com.example.elements.Keyboard;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainController {
    private BlockGrid blockGrid = BlockGrid.getInstance();
    private Keyboard keyboard = Keyboard.getInstance();
    private static boolean isGameOver;
    @FXML
    private GridPane blockGridPane;
    @FXML
    private GridPane keyboardGridPane;
    @FXML
    private BorderPane mainPane;
    public void initialize(){
        isGameOver = false;
        Database.getInstance();
        createGrid();
        Platform.runLater(() -> blockGridPane.requestFocus());
    }
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent){
        if(!isGameOver){
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                checkWord();
            } else if(keyEvent.getCode().equals(KeyCode.BACK_SPACE)){
                BlockGrid.getInstance().backspace();
            } else{
                BlockGrid.getInstance().addLetter(keyEvent.getCode());
            }
        }
    }
    private void createGrid(){
        blockGrid.createGrid(blockGridPane);
        keyboard.createGrid(keyboardGridPane);
    }
    public static void checkWord(){
        if(BlockGrid.getInstance().getCurrentColumn() == 5){
            String currentWord = BlockGrid.getInstance().getWordFromRow();
            if(Database.getInstance().checkIfExists(currentWord)){
                String password = Database.getInstance().getPassword();
                BlockGrid.getInstance().updateBlocks(currentWord, password);
                if(Database.getInstance().checkWord(currentWord)){
                    Stage mainStage = Main.getMainStage();
                    GameOver gameOver = new GameOver();
                    gameOver.generateGameOverPopup(mainStage);
                    isGameOver = true;
                }
            }
        }
    }
    public static boolean isGameOver(){
        return isGameOver;
    }
}