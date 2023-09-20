package com.example.elements;

import javafx.scene.layout.GridPane;

import java.security.Key;

public class Keyboard {
    private static Keyboard instance;
    private static final String[] letters = new String[]{
            "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
            "A", "S", "D", "F", "G", "H", "J", "K", "L",
            "\u2192", "Z", "X", "C", "V", "B", "N", "M", "<"
    };
    private Keyboard(){
    }
    public static Keyboard getInstance() {
        if(instance == null){
            instance = new Keyboard();
        }
        return instance;
    }
    public void createGrid(GridPane gridPane){
        for(int i = 0; i < letters.length; i++){
            KeyButton newKeyButton = new KeyButton(letters[i]);
            newKeyButton.getButton().getStyleClass().add("key-button-default");
            int rowNumber = (i < 10) ? 0 : (i < 19) ? 1 : 2;
            int columnNumber = (rowNumber == 0) ? i : (rowNumber == 1) ? i - 10 : i - 19;
            gridPane.add(newKeyButton.getButton(), columnNumber, rowNumber );
        }
    }
}
