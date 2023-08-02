package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AttendantWindow {

    @FXML
    private Button CancelOs;

    @FXML
    private Button EditClient;

    @FXML
    private Button Payment;

    @FXML
    private Button RegisterClient;

    @FXML
    private Button Return;

    @FXML
    void CancelOsAction(ActionEvent event) {

    }

    @FXML
    void EditClientAction(ActionEvent event) {
        MainApplication.changeScreen("editClient");
    }

    @FXML
    void PaymentAction(ActionEvent event) {
        MainApplication.changeScreen("payment");
    }

    @FXML
    void RegisterClientAction(ActionEvent event) {

    }

    @FXML
    void ReturnAction(ActionEvent event) {
        MainApplication.changeScreen("main");
    }

    public void createOsAction(ActionEvent actionEvent) {
        MainApplication.changeScreen("createOs");
    }
}
