package com.example.elements;
/*
Class responsible for creating one button of virtual keyboard
 */

import com.example.wordlefx.Main;
import com.example.wordlefx.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

import java.util.Objects;

public class KeyButton {
    private Button button;
    private EventHandler<ActionEvent> eventListener;
    private boolean alreadyChecked = false;
    private String keyState = "default";
    public KeyButton(String s){
        this.button = new Button(s);
        this.button.getStyleClass().add("key-button-default");
        eventListener = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if(!MainController.isGameOver()){
                    if(Objects.equals(button.getText(), "<")){
                        BlockGrid.getInstance().backspace();
                    } else if(Objects.equals(button.getText(), "\u2192")){
                        MainController.checkWord();
                    } else {
                        BlockGrid.getInstance().addLetter(KeyCode.getKeyCode(button.getText()));
                    }
                }
            }
        };
        button.setOnAction(eventListener);
    }
    public Button getButton(){
        return this.button;
    }
    public void updateKeyButton(String keyState){
        if(!alreadyChecked){
            this.keyState = keyState;
            this.button.getStyleClass().add(String.format("key-button-%s", keyState));
            alreadyChecked = true;
        }
    }
    public void stopGame(){
        this.button.getStyleClass().add("key-button-"+keyState+"-disabled");
    }
}
