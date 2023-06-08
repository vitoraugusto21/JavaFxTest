package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Os;
import com.example.javafxtest.model.entities.Technician;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Interface que define as operações básicas para o DAO de técnicos.
 */
public interface TechnicianDAO {

    void createTechnician(Technician technician) throws IOException;

    void updateTechnician(Technician technician, String attributeToChange, String newAttribute) throws IOException;

    void deleteTechnician(Technician technician) throws IOException;

    Map<String, Technician> readTechnicians() throws IOException;

    Technician getTechnicianById(String id) throws IOException;

    void updateTechnicianOs(Technician tec, Os os) throws IOException;
}
