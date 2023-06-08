package com.example.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //carregar arquivo sceneBuilder
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL xmlURL = getClass().getResource("MainWindow.fxml");
        fxmlLoader.setLocation(xmlURL);

        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    



    public static void main(String[] args) {
        launch();
    }
}