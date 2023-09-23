package com.example.elements;

import javafx.scene.control.Label;

/*
Class responsible for creating single block with a label representing single letter of an entered word
 */

public class Block {
    private final Label label;
    private String blockState;
    public Block(String blockState){
        this.blockState = blockState;
        this.label = new Label();
        this.label.setText("");
        this.label.getStyleClass().add(blockState);
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
        this.label.getStyleClass().remove(String.format("block-%s", this.blockState));
        this.label.getStyleClass().add("block-default");
        this.label.setOpacity(1);
    }
}
