package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Esta interface define os métodos que devem ser implementados para interagir com um objeto Manager em um banco de dados.
 */
public interface ManagerDAO {

    void createManager(Manager manager) throws IOException;

    void updateManager(Manager manager, String attributeToChange, String newAttribute) throws IOException;

    void deleteManager(Manager manager) throws IOException;

    Map<String, Manager> readManagers() throws IOException;

    Manager getManagerById(String id) throws IOException;

    void manageStock();

    void viewReports();
}
