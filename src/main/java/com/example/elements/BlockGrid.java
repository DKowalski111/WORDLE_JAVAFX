package com.example.elements;

import javafx.scene.layout.GridPane;

import java.util.List;

public class BlockGrid {
    private static BlockGrid instance;
    private Block[][] blockGrid;
    private int currentRow;
    private int currentIndex;
    private BlockGrid(){
        this.blockGrid = new Block[6][5];
        this.currentIndex = 0;
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
                blockGrid[i][j] = newBlock;
                newBlock.getLabel().getStyleClass().add("block-default");
                gridPane.add(newBlock.getLabel(), j, i);
            }
        }
    }
}
