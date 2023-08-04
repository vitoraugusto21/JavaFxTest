package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Client;
import com.example.javafxtest.model.entities.Os;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Interface responsável por definir as operações de acesso aos dados de Cliente no banco de dados.
 */
public interface ClientDAO {
    void insertOsInCliente(Os os, String clientCpf) throws IOException;
    void createClient(Client client) throws IOException;

    void updateClient(Client client, String attributeToChange, String newAttribute) throws IOException;

    void deleteClient(Client client) throws IOException;

    Map<String, Client> readClients() throws IOException;

    Client getClientById(String id) throws IOException;
}
