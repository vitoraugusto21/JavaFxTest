package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Attendant;

import java.io.IOException;
import java.util.Map;

/**
 * Interface responsável por definir as operações de acesso aos dados de Atendente no banco de dados.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public interface AttendantDAO {
    void createAttendant(Attendant attendant) throws IOException;

    void updateAttendant(Attendant attendant, String attributeToChange, String newAttribute) throws IOException;

    void deleteAttendant(Attendant attendant) throws IOException;

    Map<String, Attendant> readAttendants() throws IOException;

    Attendant getAttendantById(String id) throws IOException;

}
