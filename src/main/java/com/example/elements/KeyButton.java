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
    public void setKeyButtonState(String keyState){
        if(this.keyState == "present" && keyState == "correct"){
            this.button.getStyleClass().remove(String.format("key-button-%s", this.keyState));
            this.button.getStyleClass().add(String.format("key-button-%s", keyState));
            this.keyState = keyState;
            return;
        } else if(this.keyState == "present" && (keyState == "wrong" || keyState == "present")
                || this.keyState == "correct"){
            return;
        }
        this.keyState = keyState;
        this.button.getStyleClass().add(String.format("key-button-%s", keyState));
    }
    public void stopGame(){
        this.button.setOpacity(0.5);
    }
    public void resetGame(){
        this.button.getStyleClass().remove("key-button-"+keyState);
        this.button.getStyleClass().add("key-button-default");
        this.button.setOpacity(1);
    }
}
