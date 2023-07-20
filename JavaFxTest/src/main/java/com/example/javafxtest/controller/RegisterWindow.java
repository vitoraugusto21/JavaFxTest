package com.example.javafxtest.controller;

import com.example.javafxtest.MainApplication;
import com.example.javafxtest.model.dao.AttendantDAOImp;
import com.example.javafxtest.model.dao.ClientDAOImp;
import com.example.javafxtest.model.dao.ManagerDAOImp;
import com.example.javafxtest.model.dao.TechnicianDAOImp;
import com.example.javafxtest.model.entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
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
        ids.add(id);
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
    private TextField name;

    @FXML
    private TextField phoneNumber;

    @FXML
    void FinishRegisterAttendantAction(ActionEvent event) throws IOException {
        String name = this.name.getText();
        String number = this.phoneNumber.getText();
        String email = this.email.getText();
        String adress = this.address.getText();
        Attendant attendant = new Attendant(ids(), name, number, email, adress, "31312");
        AttendantDAOImp attendantDAO = new AttendantDAOImp();
        attendantDAO.createAttendant(attendant);

    }

    @FXML
    void FinishRegisterClient(ActionEvent event) throws IOException {
        String name = this.name.getText();
        String number = this.phoneNumber.getText();
        String email = this.email.getText();
        String address = this.address.getText();
        ArrayList<Os> clientOsList = new ArrayList<>();
        Client client = new Client(ids(), name, number, email, address,clientOsList);
        System.out.println(client);
        ClientDAOImp clientDAOImp = new ClientDAOImp();
        clientDAOImp.createClient(client);

    }

    @FXML
    void FinishRegisterManagerAction(ActionEvent event) throws IOException {
        String name = this.name.getText();
        String number = this.phoneNumber.getText();
        String email = this.email.getText();
        String address = this.address.getText();
        Manager manager = new Manager(ids(), name, number, email, address, "pass");
        ManagerDAOImp managerDAOImp = new ManagerDAOImp();
        managerDAOImp.createManager(manager);
    }

    @FXML
    void FinishRegisterTecAction(ActionEvent event) throws IOException {
        String name = this.name.getText();
        String number = this.phoneNumber.getText();
        String email = this.email.getText();
        String address = this.address.getText();
        Technician tec = new Technician(ids(), name, number, email, address, "pass");
        TechnicianDAOImp technicianDAOImp = new TechnicianDAOImp();
        technicianDAOImp.createTechnician(tec);
    }

    @FXML
    void ReturnAction(ActionEvent event) {
        MainApplication.changeScreen("main");
    }

}
