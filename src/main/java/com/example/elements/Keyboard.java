package com.example.elements;

/*
Class, singleton, responsible for creating a whole keyboard made of KeyButtons
 */

import com.example.wordlefx.MainController;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.security.Key;

public class Keyboard {
    private static Keyboard instance;
    private KeyButton[] keyboardGrid;
    private static final String[] letters = new String[]{
            "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
            "A", "S", "D", "F", "G", "H", "J", "K", "L",
            "\u2192", "Z", "X", "C", "V", "B", "N", "M", "<"
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
        for(int i = 0; i < letters.length; i++){
            KeyButton newKeyButton = new KeyButton(letters[i]);
            int rowNumber = (i < 10) ? 0 : (i < 19) ? 1 : 2;
            int columnNumber = (rowNumber == 0) ? i : (rowNumber == 1) ? i - 10 : i - 19;
            gridPane.add(newKeyButton.getButton(), columnNumber, rowNumber );
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
        for(KeyButton keyButton : keyboardGrid){
            keyButton.stopGame();
        }
    }
    public void resetGame(){
        for(KeyButton keyButton : keyboardGrid){
            keyButton.resetGame();
        }
    }
}
