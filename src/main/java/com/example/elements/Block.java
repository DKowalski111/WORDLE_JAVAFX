package com.example.elements;

import javafx.scene.control.Label;

public class Block {
    Label label;
    public Block(){
        this.label = new Label();
        this.label.setText("");
        this.label.getStyleClass().add("block-default");
    }
    public Label getLabel(){
        return this.label;
    }
    public void setToCorrect(){
        this.label.getStyleClass().add("block-correct");
    }
    public void setToPresent(){
        this.label.getStyleClass().add("block-present");
    }
    public void setToWrong(){
        this.label.getStyleClass().add("block-wrong");
    }
}
