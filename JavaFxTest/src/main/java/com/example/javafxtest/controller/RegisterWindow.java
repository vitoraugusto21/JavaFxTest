package com.example.javafxtest.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Random;

public class RegisterWindow {
    Random random = new Random();
    private final ArrayList ids = new ArrayList<>();

    public String ids(){
        int id = random.nextInt(10000);
        while (ids.contains(id)){
            id = random.nextInt(10000);
        }
        return String.valueOf(id);
    }
    @FXML
    private Button FinishRegisterAttendant;

    @FXML
    private Button FinishRegisterClient;

    @FXML
    private Button FinishRegisterManager;

    @FXML
    private Button FinishRegisterTec;

    @FXML
    private Button Return;

    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNumber;

    @FXML
    void FinishRegisterAttendantAction(ActionEvent event) {
        String id = ids();
        


    }

    @FXML
    void FinishRegisterClient(ActionEvent event) {

    }

    @FXML
    void FinishRegisterManagerAction(ActionEvent event) {
        int id = random.nextInt(10000);
    }

    @FXML
    void FinishRegisterTecAction(ActionEvent event) {
        int id = random.nextInt(10000);
    }

    @FXML
    void ReturnAction(ActionEvent event) {

    }

}
