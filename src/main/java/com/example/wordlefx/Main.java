package com.example.wordlefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 760);

        mainStage.setTitle("Hello!");
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