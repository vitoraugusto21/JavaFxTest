package com.example.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {
    private static Stage stage;
    private static Scene attendantScene;
    private static Scene ClientScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        //carregar arquivo sceneBuilder
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL xmlURLMain = getClass().getResource("MainWindow.fxml");
        fxmlLoader.setLocation(xmlURLMain);
        Parent parentMain = fxmlLoader.load();
        Scene scene = new Scene(parentMain);

        Parent parentAttendant = fxmlLoader.load(getClass().getResource("AttendantWindow.fxml"));
        attendantScene = new Scene(parentAttendant);
        stage.setScene(scene);
        stage.show();



    }
    public static void changeScreen(String screen){
        switch (screen){
            case "attendant":
                stage.setScene(attendantScene);
                break;
            case "tec":
                break;
            case "manager":
                break;
        }
    }



    public static void main(String[] args) {
        launch();
    }
}