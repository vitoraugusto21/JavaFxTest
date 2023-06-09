package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainWindow {

    @FXML
    private Button BtnAttendant;

    @FXML
    private Button BtnManager;

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
    void BtnTecAction(ActionEvent event) {

    }

}
