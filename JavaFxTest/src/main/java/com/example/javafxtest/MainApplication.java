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
    private static Scene editClientScene;
    private static Scene paymentScene;
    private static Scene createOsWindowScene;

    /**
     * O método principal que inicia a aplicação JavaFX.
     *
     * @param primaryStage - O palco principal da aplicação.
     * @throws IOException - Exceção de entrada/saída ao carregar arquivos FXML.
     */

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

        FXMLLoader editClientLoader = new FXMLLoader();
        URL xmlURLEditClient = getClass().getResource("EditClientWindow.fxml");
        editClientLoader.setLocation(xmlURLEditClient);
        Parent parentEditClient = editClientLoader.load();
        editClientScene = new Scene(parentEditClient);

        FXMLLoader paymentLoader = new FXMLLoader();
        URL xmlURLPayment = getClass().getResource("PaymentWindow.fxml");
        paymentLoader.setLocation(xmlURLPayment);
        Parent parentPayment = paymentLoader.load();
        paymentScene = new Scene(parentPayment);

        FXMLLoader createOsWindowLoader = new FXMLLoader();
        URL xmlURLCreateOsWindow = getClass().getResource("CreateOsWindow.fxml");
        createOsWindowLoader.setLocation(xmlURLCreateOsWindow);
        Parent parentCreateOsWindow = createOsWindowLoader.load();
        createOsWindowScene = new Scene(parentCreateOsWindow);

        stage.setScene(mainScene);
        stage.show();
    }
    /**
     * Método estático para trocar a cena (screen) exibida no palco principal.
     *
     * @param screen - O nome da tela a ser exibida.
     */
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
            case "editClient":
                stage.setScene(editClientScene);
                break;
            case "payment":
                stage.setScene(paymentScene);
                break;
            case "createOs":
                stage.setScene(createOsWindowScene);
                break;
        }
    }

    /**
     * O método principal que inicia a aplicação JavaFX.
     *
     * @param args - Os argumentos da linha de comando.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
