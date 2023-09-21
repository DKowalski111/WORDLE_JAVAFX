package com.example.elements;
/*
Class responsible for creating one button of virtual keyboard
 */

import com.example.wordlefx.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

import java.util.Objects;

public class KeyButton {
    private Button button;
    private boolean alreadyChecked = false;
    public KeyButton(String s){
        this.button = new Button(s);
        this.button.getStyleClass().add("key-button-default");
        EventHandler<ActionEvent> eventListener = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if(Objects.equals(button.getText(), "<")){
                    BlockGrid.getInstance().backspace();
                } else if(Objects.equals(button.getText(), "\u2192")){
                    MainController.checkWord();
                } else {
                    BlockGrid.getInstance().addLetter(KeyCode.getKeyCode(button.getText()));
                }
            }
        };
        button.setOnAction(eventListener);
    }
    public Button getButton(){
        return this.button;
    }
    public void setToCorrect(){
        if(!alreadyChecked){
            this.button.getStyleClass().add("key-button-correct");
            alreadyChecked = true;
        }
    }
    public void setToPresent(){
        if(!alreadyChecked){
            this.button.getStyleClass().add("key-button-present");
            alreadyChecked = true;
        }
    }
    public void setToWrong(){
        if(!alreadyChecked){
            this.button.getStyleClass().add("key-button-wrong");
            alreadyChecked = true;
        }
    }
}
