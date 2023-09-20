package com.example.elements;
/*
Class responsible for creating one button of virtual keyboard
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

import java.util.Objects;

public class KeyButton {
    private Button button;
    public KeyButton(String s){
        this.button = new Button(s);
        EventHandler<ActionEvent> eventListener = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if(Objects.equals(button.getText(), "<")){
                    BlockGrid.getInstance().backspace();
                } else if(Objects.equals(button.getText(), "\u2192")){
                    BlockGrid.getInstance().checkWord();
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
}
