package com.example.elements;

import javafx.scene.control.Label;

public class Block {
    private Label label;
    private String blockState;
    public Block(){
        this.label = new Label();
        this.label.setText("");
        this.label.getStyleClass().add("block-default");
    }
    public Label getLabel(){
        return this.label;
    }
    public void setBlockState(String blockState){
        this.blockState = blockState;
        this.label.getStyleClass().add(String.format("block-%s", blockState));
    }
    public void stopGame(){
        this.label.setOpacity(0.5);
    }
    public void resetGame(){
        this.label.setText("");
        this.label.getStyleClass().remove(String.format("block-%s", blockState));
        this.label.getStyleClass().add("block-default");
        this.label.setOpacity(1);
    }
}
