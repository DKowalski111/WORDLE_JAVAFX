package com.example.elements;

/*
Class responsible for creating a whole grid of Blocks
 */

import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;

public class BlockGrid {
    private static BlockGrid instance;
    private Block[][] blockGrid;
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
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                Block newBlock = new Block();
                blockGrid[j][i] = newBlock;
                newBlock.getLabel().getStyleClass().add("block-default");
                gridPane.add(newBlock.getLabel(), j, i);
            }
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
    public void checkWord(){
        if(currentColumn == 5){
            String[] tempArray = new String[5];
            for(int i = currentColumn - 1; i >= 0; i--){
                tempArray[i] = blockGrid[i][currentRow].getLabel().getText();
            }
            String enteredWord = String.join("", tempArray);
            System.out.println(Database.getInstance().checkWord(enteredWord));
            currentColumn = 0;
            currentRow++;
        }
    }
}
