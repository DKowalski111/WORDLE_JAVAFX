package com.example.elements;

/*
Class responsible for creating a whole keyboard made of KeyButtons
 */

import javafx.scene.layout.GridPane;

public class Keyboard {
    private GridPane parent;
    private static Keyboard instance;
    private final KeyButton[] keyboardGrid;
    private static final String[] letters = new String[]{
            "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
            "A", "S", "D", "F", "G", "H", "J", "K", "L",
            "→", "Z", "X", "C", "V", "B", "N", "M", "<"
    };
    private Keyboard(){
        this.keyboardGrid = new KeyButton[28];
    }
    public static Keyboard getInstance() {
        if(instance == null){
            instance = new Keyboard();
        }
        return instance;
    }
    public void createGrid(GridPane gridPane){
        this.parent = gridPane;
        this.parent.getStyleClass().add("keyboard-grid-pane");
        for(int i = 0; i < letters.length; i++){
            KeyButton newKeyButton = new KeyButton(letters[i]);
            int rowNumber = (i < 10) ? 0 : (i < 19) ? 1 : 2;
            int columnNumber = (rowNumber == 0) ? i : (rowNumber == 1) ? i - 10 : i - 19;
            parent.add(newKeyButton.getButton(), columnNumber, rowNumber );
            keyboardGrid[i] = newKeyButton;
        }
    }
    public void updateKeyButtons(String enteredWord, String password){
        for(int i = 4; i >= 0; i--){
            KeyButton keyButton = getKeyButton(String.valueOf(enteredWord.charAt(i)));
            if(password.charAt(i) == enteredWord.toLowerCase().charAt(i)){
                keyButton.setKeyButtonState("correct");
            } else if(password.contains(String.valueOf(enteredWord.toLowerCase().charAt(i)))){
                keyButton.setKeyButtonState("present");
            } else {
                keyButton.setKeyButtonState("wrong");
            }
        }
    }
    public KeyButton getKeyButton(String letter){
        int indexOfLetter = 0;
        for( int i = 0; i < letters.length; i++){
            if(letter.equals(letters[i])){
                indexOfLetter = i;
                break;
            }
        }
        return keyboardGrid[indexOfLetter];
    }
    public void stopGame(){
        parent.setOpacity(0.5);
        for(KeyButton keyButton : keyboardGrid){
            keyButton.stopGame();
        }
    }
    public void resetGame(){
        parent.setOpacity(1);
        for(KeyButton keyButton : keyboardGrid){
            keyButton.resetGame();
        }
    }
}
