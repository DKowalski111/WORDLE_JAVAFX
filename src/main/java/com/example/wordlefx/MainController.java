package com.example.wordlefx;

import com.example.elements.BlockGrid;
import com.example.elements.Database;
import com.example.elements.Keyboard;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private HBox titleWordlePane;
    @FXML
    private HBox mainTitlePane;
    @FXML
    private GridPane blockGridPane;
    @FXML
    private GridPane keyboardGridPane;
    private final BlockGrid blockGrid = BlockGrid.getInstance();
    private final Keyboard keyboard = Keyboard.getInstance();
    private static boolean isGameOver;
    private static boolean result; // true = win, false = lose
    public void initialize(){
        isGameOver = false;
        createGrid();
        Platform.runLater(() -> blockGridPane.requestFocus());
        titleWordlePane.getStyleClass().add("title-wordle-pane");
        mainTitlePane.getStyleClass().add("main-title-pane");
    }
    private void createGrid(){
        blockGrid.createTitleGrid(titleWordlePane);
        blockGrid.createGrid(blockGridPane);
        keyboard.createGrid(keyboardGridPane);
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
    public static void checkWord(){
        if(BlockGrid.getInstance().getCurrentColumn() == 5){
            String currentWord = BlockGrid.getInstance().getWordFromRow();
            if(Database.getInstance().checkIfExists(currentWord)){
                String password = Database.getInstance().getPassword();
                BlockGrid.getInstance().updateBlocks(currentWord, password);
                Keyboard.getInstance().updateKeyButtons(currentWord, password);
                if(Database.getInstance().checkWord(currentWord)){
                    result = true;
                    stopGame();
                } else if(BlockGrid.getInstance().getCurrentRow() == 6){
                    result = false;
                    stopGame();
                }
            }
        }
    }
    public static void stopGame(){
        Stage mainStage = Main.getMainStage();
        GameOver.generateGameOverPopup(mainStage, result);
        isGameOver = true;
        BlockGrid.getInstance().stopGame();
        Keyboard.getInstance().stopGame();
    }
    public static void resetGame(){
        isGameOver = false;
        BlockGrid.getInstance().resetGame();
        Keyboard.getInstance().resetGame();
        Database.getInstance().generateNewPassword();
    }
    public static boolean isGameOver(){
        return isGameOver;
    }
    public static boolean getResult(){
        return result;
    }
}