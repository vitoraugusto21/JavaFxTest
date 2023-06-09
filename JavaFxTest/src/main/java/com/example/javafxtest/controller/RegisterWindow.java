package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegisterWindow {

    @FXML
    private Button FinishRegister;

    @FXML
    private Button Return;

    @FXML
    void FinishRegisterAction(ActionEvent event) {

    }

    @FXML
    void ReturnAction(ActionEvent event) {
        MainApplication.changeScreen("main");
    }

}
