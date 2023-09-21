package com.example.wordlefx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GameOver {
    private static boolean isGameOver = false;
    private Popup popup;
    public void generateGameOverPopup(Stage stage){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameOver.fxml"));

            Parent popupContent = fxmlLoader.load();
            Scene popupScene = new Scene(popupContent);

            popup = new Popup();
            popup.getContent().add(popupScene.getRoot());
            popup.show(stage, stage.getX() + 7, stage.getY() + 30);

            stage.xProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    double ownerX = newValue.doubleValue();
                    double ownerY = stage.getY();
                    popup.setX(ownerX + 7); // Adjust the offset as needed
                    popup.setY(ownerY + 30); // Adjust the offset as needed
                }
            });

            stage.yProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    double ownerX = stage.getX();
                    double ownerY = newValue.doubleValue();
                    popup.setX(ownerX + 7); // Adjust the offset as needed
                    popup.setY(ownerY + 30); // Adjust the offset as needed
                }
            });

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static boolean isIsGameOver() {
        return isGameOver;
    }

    public static void setIsGameOver(boolean isGameOver) {
        GameOver.isGameOver = isGameOver;
    }
}
