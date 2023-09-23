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
    private static Popup popup;
    public static void generateGameOverPopup(Stage stage, boolean result){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(GameOver.class.getResource("gameOver.fxml"));

            Parent popupContent = fxmlLoader.load();
            Scene popupScene = new Scene(popupContent);

            popup = new Popup();
            popup.getContent().add(popupScene.getRoot());
            popup.show(stage);
            popup.setX(stage.getX() + stage.getWidth() / 2 - popup.getWidth() / 2);
            popup.setY(stage.getY() + stage.getHeight() / 2 - popup.getHeight() / 2);

            stage.xProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    popup.setX(stage.getX() + stage.getWidth() / 2 - popup.getWidth() / 2);
                    popup.setY(stage.getY() + stage.getHeight() / 2 - popup.getHeight() / 2);
                }
            });

            stage.yProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    popup.setX(stage.getX() + stage.getWidth() / 2 - popup.getWidth() / 2);
                    popup.setY(stage.getY() + stage.getHeight() / 2 - popup.getHeight() / 2);
                }
            });

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void resetGame(){
        popup.hide();
        MainController.resetGame();
    }
}
