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

    @Override
    public Map<String, Attendant> readAttendants() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendants.json"));
        Map<String, Attendant> attendants = gson.fromJson(reader, new TypeToken<Map<String, Attendant>>(){}.getType());
        return attendants;
    }

    @Override
    public Attendant getAttendantById(String id) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendants.json"));
        Map<String, Attendant> attendants = gson.fromJson(reader, new TypeToken<Map<String, Attendant>>(){}.getType());
        return attendants.get(id);
    }
}







