package com.example.javafxtest.model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.example.javafxtest.model.entities.Attendant;
import com.example.javafxtest.model.entities.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientDAOImp implements ClientDAO {

    private final Map<String, Client> clients = new HashMap<>();
    File file = new File(System.getProperty("user.dir") + File.separator + "clients.json");

    public ClientDAOImp() {
    }

    /**
     * Insere um novo Cliente no banco de dados.
     *
     *
     * @param client o Cliente a ser inserido.
     */
    @Override
    public void createClient(Client client) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (file.exists()){
            Reader reader = Files.newBufferedReader(Paths.get("clients.json"));
            Map<String, Client> clientsFromJson = gson.fromJson(reader, Map.class);
            clientsFromJson.put(client.getId(), client);
            String updateJson = gson.toJson(clientsFromJson);
            FileWriter writer = new FileWriter(file);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else {
            clients.put(client.getId(), client);
            String clientsJson = gson.toJson(clients);
            FileWriter writer = new FileWriter(file);
            writer.write(clientsJson);
            writer.flush();
            writer.close();
        }

    }

    /**
     * Atualiza as informações de um Cliente no banco de dados.
     *
     * @param client            - o Cliente a ser atualizado.
     * @param attributeToChange - o atributo a ser alterado.
     * @param newAttribute      - o novo valor do atributo.
     */
    @Override
    public void updateClient(Client client, String attributeToChange, String newAttribute) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Client> clientsFromJson = readClients();
        switch (attributeToChange.toLowerCase()) {
            case "name" -> clientsFromJson.get(client.getId()).setName(newAttribute);
            case "email" -> clientsFromJson.get(client.getId()).setEmail(newAttribute);
            case "phoneNumber" -> clientsFromJson.get(client.getId()).setPhoneNumber(newAttribute);
            case "address" -> clientsFromJson.get(client.getId()).setAddress(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        String clientsToJson = gson.toJson(clientsFromJson);
        FileWriter writer = new FileWriter("clients.json");
        writer.write(clientsToJson);
        writer.close();
    }

    /**
     * Exclui um Cliente do banco de dados.
     *
     * @param client - o Cliente a ser excluído.
     */
    @Override
    public void deleteClient(Client client) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Client> clientsFromJson = readClients();
        clientsFromJson.remove(client.getId());
        String clientsToJson = gson.toJson(clientsFromJson);
        FileWriter writer = new FileWriter("clients.json");
        writer.write(clientsToJson);
        writer.close();
    }

    /**
     * Obtém todos os Clientes cadastrados no banco de dados.
     *
     * @return - uma lista de todos os Clientes.
     */
    @Override
    public Map<String, Client> readClients() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("clients.json"));
        Map<String, Client> clients = gson.fromJson(reader, new TypeToken<Map<String, Client>>(){}.getType());
        return clients;
    }

    /**
     * Obtém um Cliente específico do banco de dados a partir de seu ID.
     *
     * @param id - o ID do Cliente a ser buscado.
     * @return - o Cliente correspondente ao ID especificado.
     */
    @Override
    public Client getClientById(String id) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("clients.json"));
        Map<String, Client> clients = gson.fromJson(reader, new TypeToken<Map<String, Client>>(){}.getType());
        return clients.get(id);
    }
}
