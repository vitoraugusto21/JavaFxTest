package com.example.javafxtest.model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.example.javafxtest.model.entities.Attendant;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementação da interface AttendantDAO responsável pelas operações de acesso aos dados de Atendente no banco de dados.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public class AttendantDAOImp implements AttendantDAO {

    private final Map<String, Attendant> attendants = new HashMap<>();

    File file = new File(System.getProperty("user.dir") + File.separator + "attendants.json");

    public AttendantDAOImp() {
    }

    /**
     * Cria um novo atendente ou atualiza um atendente existente no arquivo JSON.
     *
     * @param attendant O atendente a ser criado ou atualizado.
     * @throws IOException Se ocorrer um erro de E/S ao manipular o arquivo JSON.
     */
    @Override
    public void createAttendant(Attendant attendant) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (file.exists()){
            Reader reader = Files.newBufferedReader(Paths.get("attendants.json"));
            Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, Map.class);
            attendantsFromJson.put(attendant.getId(), attendant);
            String updateJson = gson.toJson(attendantsFromJson);
            FileWriter writer = new FileWriter(file);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else {
            attendants.put(attendant.getId(), attendant);
            String attendantsJson = gson.toJson(attendants);
            FileWriter writer = new FileWriter(file);
            writer.write(attendantsJson);
            writer.flush();
            writer.close();
        }

    }

    /**
     * Atualiza um atributo específico de um atendente.
     *
     * @param attendant         O atendente a ser atualizado.
     * @param attributeToChange O atributo a ser alterado (name, email, phonenumber, address).
     * @param newAttribute      O novo valor do atributo.
     * @throws IOException            Se ocorrer um erro de E/S ao manipular o arquivo JSON.
     * @throws IllegalArgumentException Se o nome do atributo a ser alterado for inválido.
     */
    @Override
    public void updateAttendant(Attendant attendant, String attributeToChange, String newAttribute) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Attendant> attendantsFromJson = readAttendants();
        switch (attributeToChange.toLowerCase()) {
            case "name" -> attendantsFromJson.get(attendant.getId()).setName(newAttribute);
            case "email" -> attendantsFromJson.get(attendant.getId()).setEmail(newAttribute);
            case "phonenumber" -> attendantsFromJson.get(attendant.getId()).setPhoneNumber(newAttribute);
            case "address" -> attendantsFromJson.get(attendant.getId()).setAddress(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        String attendantsToJson = gson.toJson(attendantsFromJson);
        FileWriter writer = new FileWriter("attendants.json");
        writer.write(attendantsToJson);
        writer.close();
    }

    /**
     * Exclui um atendente do arquivo JSON.
     *
     * @param attendant O atendente a ser excluído.
     * @throws IOException Se ocorrer um erro de E/S ao manipular o arquivo JSON.
     */

    @Override
    public void deleteAttendant(Attendant attendant) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Attendant> attendantsFromJson = readAttendants();
        attendantsFromJson.remove(attendant.getId());
        String attendantsToJson = gson.toJson(attendantsFromJson);
        FileWriter writer = new FileWriter("attendants.json");
        writer.write(attendantsToJson);
        writer.close();
    }

    /**
     * Lê todos os atendentes do arquivo JSON e retorna um mapa de atendentes.
     *
     * @return Um mapa de atendentes, onde a chave é o ID do atendente e o valor é o objeto Attendant.
     * @throws IOException Se ocorrer um erro de E/S ao ler o arquivo JSON.
     */

    @Override
    public Map<String, Attendant> readAttendants() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendants.json"));
        Map<String, Attendant> attendants = gson.fromJson(reader, new TypeToken<Map<String, Attendant>>(){}.getType());
        return attendants;
    }

    /**
     * Obtém um atendente com base em seu ID.
     *
     * @param id O ID do atendente a ser obtido.
     * @return O objeto Attendant correspondente ao ID fornecido, ou null se não for encontrado.
     * @throws IOException Se ocorrer um erro de E/S ao ler o arquivo JSON.
     */
    @Override
    public Attendant getAttendantById(String id) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendants.json"));
        Map<String, Attendant> attendants = gson.fromJson(reader, new TypeToken<Map<String, Attendant>>(){}.getType());
        return attendants.get(id);
    }
}







