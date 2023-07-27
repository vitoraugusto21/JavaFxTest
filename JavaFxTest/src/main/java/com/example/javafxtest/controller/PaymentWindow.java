package com.example.javafxtest.controller;

import com.example.javafxtest.model.dao.OsDAOImp;
import com.example.javafxtest.model.dao.TechnicianDAOImp;
import javafx.event.ActionEvent;

import java.io.File;

public class PaymentWindow {
    OsDAOImp osDAOImp = new OsDAOImp();
    TechnicianDAOImp technicianDAOImp = new TechnicianDAOImp();
    File file = new File("os.json");



    public void cashAction(ActionEvent actionEvent) {
    }

    public void debitAction(ActionEvent actionEvent) {
    }

    public void PixAction(ActionEvent actionEvent) {
    }

    public void CreditAction(ActionEvent actionEvent) {
    }
}
