package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import com.example.javafxtest.model.dao.ClientDAOImp;
import com.example.javafxtest.model.entities.Client;
import com.example.javafxtest.model.entities.Os;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class PaymentWindow {

    @FXML
    private Button Return;

    @FXML
    private Button cash;

    @FXML
    private TextField clienteCpf;

    @FXML
    private ComboBox<Os> comboBox;

    @FXML
    private Button credit;

    @FXML
    private Button debitAction;

    @FXML
    private Button pix;
    private ObservableList<Os> obsOs;

    @FXML
    void CreditAction(ActionEvent event) {

    }

    @FXML
    void PixAction(ActionEvent event) {

    }

    @FXML
    void ReturnAction(ActionEvent event) {
        MainApplication.changeScreen("attendant");

    }

    @FXML
    void cashAction(ActionEvent event) {

    }

    @FXML
    void debitAction(ActionEvent event) {

    }

    public void loadOsList() throws IOException {
        String clientCpf = this.clienteCpf.getText();
        ClientDAOImp clientDAOImp = new ClientDAOImp();
        ArrayList <Os> osList = new ArrayList<>();
        osList = clientDAOImp.getClientById(clientCpf).getClientOs();
        obsOs = FXCollections.observableArrayList(osList);
        comboBox.setItems(obsOs);
    }

}
