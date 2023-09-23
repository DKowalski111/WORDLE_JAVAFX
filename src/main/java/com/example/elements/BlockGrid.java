package com.example.elements;

/*
Class responsible for creating a whole grid of Blocks and a Title grid
 */
import com.example.wordlefx.MainController;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class BlockGrid {
    private GridPane parent;
    private static BlockGrid instance;
    private final Block[][] blockGrid;
    private int currentRow;
    private int currentColumn;
    private BlockGrid(){
        this.blockGrid = new Block[5][6];
        this.currentColumn = 0;
        this.currentRow = 0;
    }
    public static BlockGrid getInstance(){
        if(instance == null){
            instance = new BlockGrid();
        }
        return instance;
    }
    public void createGrid(GridPane gridPane){
        parent = gridPane;
        parent.getStyleClass().add("block-grid-pane");
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                Block newBlock = new Block("block-default");
                blockGrid[j][i] = newBlock;
                parent.add(newBlock.getLabel(), j, i);
            }
        }
    }
    public void createTitleGrid(HBox hbox){
        String[] title = {"W", "O", "R", "D", "L", "E"};
        String[] titleStates = {"title-correct", "title-wrong", "title-present", "title-default", "title-wrong", "title-present"};
        for(int i = 0; i < 6; i++){
            Block newBlock = new Block("block-" + titleStates[i]);
            newBlock.getLabel().setText(title[i]);
            hbox.getChildren().add(newBlock.getLabel());
        }
    }
    public void addLetter(KeyCode keyCode){
        if(currentColumn <= 4 && currentRow <= 5 && keyCode.getChar().length() == 1 &&
            64 < (int) keyCode.getChar().charAt(0) && (int) keyCode.getChar().charAt(0) < 91){

                    blockGrid[currentColumn][currentRow].getLabel().setText(keyCode.getChar());
                    currentColumn++;
        }
    }
    public void backspace() {
        if (currentColumn > 0) {
            currentColumn--;
            blockGrid[currentColumn][currentRow].getLabel().setText("");
        }
    }
    public void updateBlocks(String enteredWord, String password){
        for(int i = currentColumn - 1; i >= 0; i--){
            Block currentBlock = blockGrid[i][currentRow];
            if(password.charAt(i) == enteredWord.toLowerCase().charAt(i)){
                currentBlock.setBlockState("correct");
            }else if(password.contains(String.valueOf(enteredWord.toLowerCase().charAt(i)))){
                currentBlock.setBlockState("present");
            } else {
                currentBlock.setBlockState("wrong");
            }
        }
        currentColumn = 0;
        currentRow++;
    }
    public String getWordFromRow(){
        String[] tempArray = new String[5];
        for(int i = currentColumn - 1; i >= 0; i--){
            tempArray[i] = blockGrid[i][currentRow].getLabel().getText();
        }
        return String.join("", tempArray);
    }
    public int getCurrentColumn(){
        return this.currentColumn;
    }
    public int getCurrentRow() {
        return currentRow;
    }

    public void stopGame(){
        parent.setOpacity(0.5);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 6; j++){
                blockGrid[i][j].stopGame();
            }
        }
    }
    public void resetGame(){
        parent.setOpacity(1);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 6; j++){
                blockGrid[i][j].resetGame();
            }
        }
        this.currentColumn = 0;
        this.currentRow = 0;
    }
}
