package com.example.wordlefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 760);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        this.gameOver(stage);
    }
    public Stage getStage() {
        return stage;
    }

    public void gameOver(Stage stage){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameOver.fxml"));

            Parent popupContent = fxmlLoader.load();
            Scene popupScene = new Scene(popupContent);

            Popup popup = new Popup();
            popup.getContent().add(popupScene.getRoot());
            double ownerX = stage.getX();
            double ownerY = stage.getY();
            double ownerWidth = stage.getWidth();
            double ownerHeight = stage.getHeight();
            double popupWidth = 400;
            double popupHeight = 200;

            popup.show(stage, ownerX + (ownerWidth - popupWidth) / 2, ownerY + (ownerHeight - popupHeight) / 2);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}