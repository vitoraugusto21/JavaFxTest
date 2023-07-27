package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import com.example.javafxtest.model.dao.ClientDAOImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class EditClientWindow {

    @FXML
    public TextField clienteCpf;

    @FXML
    public TextField newAttribute;

    public void ReturnAction(ActionEvent actionEvent) {
        MainApplication.changeScreen("attendant");
    }

    public void EditNameAction(ActionEvent actionEvent) throws IOException {
        ClientDAOImp clientDAOImp = new ClientDAOImp();
        File file = new File("clients.json");
        if (file.exists()) {
            clientDAOImp.readClients();
            String cpf = this.clienteCpf.getText();
            String newAttribute = this.newAttribute.getText();
            clientDAOImp.updateClient(clientDAOImp.getClientById(cpf), "name", newAttribute);
        }

    }

    public void editPhoneNumberAction(ActionEvent actionEvent) throws IOException {
        ClientDAOImp clientDAOImp = new ClientDAOImp();
        File file = new File("clients.json");
        if (file.exists()) {
            clientDAOImp.readClients();
            String cpf = this.clienteCpf.getText();
            String newAttribute = this.newAttribute.getText();
            clientDAOImp.updateClient(clientDAOImp.getClientById(cpf), "phoneNumber", newAttribute);
        }
    }

    public void editEmailAction(ActionEvent actionEvent) throws IOException {
        ClientDAOImp clientDAOImp = new ClientDAOImp();
        File file = new File("clients.json");
        if (file.exists()) {
            clientDAOImp.readClients();
            String cpf = this.clienteCpf.getText();
            String newAttribute = this.newAttribute.getText();
            clientDAOImp.updateClient(clientDAOImp.getClientById(cpf), "email", newAttribute);
        }
    }

    public void editAddressAction(ActionEvent actionEvent) throws IOException {
        ClientDAOImp clientDAOImp = new ClientDAOImp();
        File file = new File("clients.json");
        if (file.exists()) {
            clientDAOImp.readClients();
            String cpf = this.clienteCpf.getText();
            String newAttribute = this.newAttribute.getText();
            clientDAOImp.updateClient(clientDAOImp.getClientById(cpf), "address", newAttribute);
        }
    }
}
