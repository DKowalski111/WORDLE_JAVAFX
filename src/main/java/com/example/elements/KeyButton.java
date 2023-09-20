package com.example.elements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

import java.util.EventListener;
import java.util.Objects;

public class KeyButton {
    private Button button;
    public KeyButton(String s){
        this.button = new Button(s);
        EventHandler<ActionEvent> eventListener = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if(Objects.equals(button.getText(), "<")){
                    BlockGrid.getInstance().addLetter(KeyCode.BACK_SPACE);
                } else if(Objects.equals(button.getText(), "\u2192")){
                    BlockGrid.getInstance().addLetter(KeyCode.ENTER);
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
