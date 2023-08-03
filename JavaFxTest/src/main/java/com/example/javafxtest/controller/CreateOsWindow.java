package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import com.example.javafxtest.model.dao.OsDAOImp;
import com.example.javafxtest.model.entities.Os;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class CreateOsWindow {
    public TextField description;
    public TextField clienteCpf;

    public ArrayList randomList = new ArrayList<>();

    public String random() {
        
    }

    public void ReturnAction(ActionEvent actionEvent) {
        MainApplication.changeScreen("attendant");
    }
    public void okButton(ActionEvent actionEvent) throws IOException {
        String description = this.description.getText();
        Date startTime = new Date();
        String clientCpf = this.clienteCpf.getText();
        Os os = new Os(random(), description, startTime, clientCpf);
        OsDAOImp osDAOImp = new OsDAOImp();
        osDAOImp.insertOsInQueue(os);
    }
}
