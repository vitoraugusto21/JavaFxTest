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
    private static Scene registerScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        // Carregar arquivo sceneBuilder
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL xmlURLMain = getClass().getResource("MainWindow.fxml");
        fxmlLoader.setLocation(xmlURLMain);
        Parent parentMain = fxmlLoader.load();
        mainScene = new Scene(parentMain);

        FXMLLoader attendantLoader = new FXMLLoader();
        URL xmlURLAttendant = getClass().getResource("AttendantWindow.fxml");
        attendantLoader.setLocation(xmlURLAttendant);
        Parent parentAttendant = attendantLoader.load();
        attendantScene = new Scene(parentAttendant);

        FXMLLoader tecLoader = new FXMLLoader();
        URL xmlURLTec = getClass().getResource("TecWindow.fxml");
        tecLoader.setLocation(xmlURLTec);
        Parent parentTec = tecLoader.load();
        tecScene = new Scene(parentTec);

        FXMLLoader managerLoader = new FXMLLoader();
        URL xmlURLManager = getClass().getResource("ManagerWindow.fxml");
        managerLoader.setLocation(xmlURLManager);
        Parent parentManager = managerLoader.load();
        managerScene = new Scene(parentManager);

        FXMLLoader registerLoader = new FXMLLoader();
        URL xmlURLRegister = getClass().getResource("RegisterWindow.fxml");
        registerLoader.setLocation(xmlURLRegister);
        Parent parentRegister = registerLoader.load();
        registerScene = new Scene(parentRegister);

        stage.setScene(mainScene);
        stage.show();
    }

    public static void changeScreen(String screen) {
        switch (screen) {
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
            case "register":
                stage.setScene(registerScene);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
