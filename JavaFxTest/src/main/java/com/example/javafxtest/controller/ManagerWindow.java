package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ManagerWindow {

    @FXML
    private Button Return;

    @FXML
    void AddPieces(ActionEvent event) {

    }

    @FXML
    void AddPiecesAction(MouseEvent event) {

    }

    @FXML
    void GenReport(ActionEvent event) {

    }

    @FXML
    void GenreportAction(MouseEvent event) {

    }

    @FXML
    void ReturnAction(ActionEvent event) {
        MainApplication.changeScreen("main");
    }

}
