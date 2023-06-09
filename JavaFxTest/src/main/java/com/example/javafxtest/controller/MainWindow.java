package com.example.javafxtest.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.javafxtest.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnAttendant;

    @FXML
    private Button BtnManager;

    @FXML
    private Button BtnRegisterAction;

    @FXML
    private Button BtnTec;

    @FXML
    void BtnAttendantAction(ActionEvent event) {
        MainApplication.changeScreen("attendant");
    }

    @FXML
    void BtnManagerAction(ActionEvent event) {

    }

    @FXML
    void BtnRegister(ActionEvent event) {

    }

    @FXML
    void BtnTecAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BtnAttendant != null : "fx:id=\"BtnAttendant\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert BtnManager != null : "fx:id=\"BtnManager\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert BtnRegisterAction != null : "fx:id=\"BtnRegisterAction\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert BtnTec != null : "fx:id=\"BtnTec\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }

}
