package com.example.elements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.EventListener;

public class KeyButton {
    private Button button;
    public KeyButton(String s){
        this.button = new Button(s);
        EventHandler<ActionEvent> eventListener = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                System.out.println(button.getText());
            }
        };
        button.setOnAction(eventListener);
    }
    public Button getButton(){
        return this.button;
    }
}
