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
    private static Scene tecScene;
    private static Scene managerScene;
    private static Scene mainScene;


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        //carregar arquivo sceneBuilder
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL xmlURLMain = getClass().getResource("MainWindow.fxml");
        fxmlLoader.setLocation(xmlURLMain);
        Parent parentMain = fxmlLoader.load();
        mainScene = new Scene(parentMain);

        Parent parentAttendant = fxmlLoader.load(getClass().getResource("AttendantWindow.fxml"));
        attendantScene = new Scene(parentAttendant);

        Parent parentTec = fxmlLoader.load(getClass().getResource("TecWindow.fxml"));
        tecScene = new Scene(parentTec);

        Parent parentManager = fxmlLoader.load(getClass().getResource("ManagerWindow.fxml"));
        managerScene = new Scene(parentManager);
        stage.setScene(mainScene);
        stage.show();



    }
    public static void changeScreen(String screen){
        switch (screen){
            case "main":
                stage.setScene(mainScene);
                break;
            case "attendant":
                stage.setScene(attendantScene);
                break;
            case "tec":
               stage.setScene(tecScene);
                break;
            case "manager":
                stage.setScene(managerScene);
                break;
        }
    }



    public static void main(String[] args) {
        launch();
    }
}