package com.example.elements;

import javafx.scene.control.Label;

public class Block {
    Label label;
    public Block(){
        this.label = new Label();
        this.label.setText(" ");
    }
    public void setLabel(String s){
        this.label.setText(s);
    }
    public Label getLabel(){
        return this.label;
    }
}
