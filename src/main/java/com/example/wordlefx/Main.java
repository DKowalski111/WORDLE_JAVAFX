package com.example.wordlefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1050, 800);

        mainStage.setTitle("WORDLE!");
        mainStage.setScene(scene);
        mainStage.show();
    }
    public static Stage getMainStage() {
        return mainStage;
    }
    public static void main(String[] args) {
        launch();
    }
}