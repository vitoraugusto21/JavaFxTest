package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TecWindow {

    @FXML
    private Button AddOSystem;

    @FXML
    private Button AddParts;

    @FXML
    private Button AddProgram;

    @FXML
    private Button CancelOs;

    @FXML
    private Button Cleaning;

    @FXML
    private Button FinishOs;

    @FXML
    private Button Return;

    @FXML
    private Button TakeOs;

    @FXML
    void AddOSystemAction(ActionEvent event) {

    }

    @FXML
    void AddPartsAction(ActionEvent event) {

    }

    @FXML
    void AddProgramAction(ActionEvent event) {

    }

    @FXML
    void CancelOsAction(ActionEvent event) {

    }

    @FXML
    void CleaningAction(ActionEvent event) {

    }

    @FXML
    void FinishOsAction(ActionEvent event) {

    }

    @FXML
    void ReturnAction(ActionEvent event) {
        MainApplication.changeScreen("main");
    }

    @FXML
    void TakeOsAction(ActionEvent event) {

    }

}
