package com.example.wordlefx;

import com.example.elements.BlockGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainController {
    private BlockGrid blockGrid = BlockGrid.getInstance();
    @FXML
    private GridPane mainGridPane;
    @FXML
    private Label welcomeText;

    public void initialize(){
        createGrid(mainGridPane);
    }
    private void createGrid(GridPane gridPane){
        blockGrid.createGrid(gridPane);
    }
}