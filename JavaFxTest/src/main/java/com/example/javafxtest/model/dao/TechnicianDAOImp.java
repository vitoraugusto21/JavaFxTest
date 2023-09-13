package com.example.javafxtest.model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.example.javafxtest.model.entities.Attendant;
import com.example.javafxtest.model.entities.Os;
import com.example.javafxtest.model.entities.Technician;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TechnicianDAOImp implements TechnicianDAO {

    private final Map<String, Technician> technicians = new HashMap<>();

    File file = new File(System.getProperty("user.dir") + File.separator + "technicians.json");

    public TechnicianDAOImp() {
    }

    /**
     * Insere um objeto `Technician` no banco de dados.
     *
     * @param technician O objeto `Technician` a ser inserido.
     * @throws IOException Se ocorrer um erro durante a operação de leitura ou escrita do arquivo.
     */
    @Override
    public void createTechnician(Technician technician) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (file.exists()){
            Reader reader = Files.newBufferedReader(Paths.get("technicians.json"));
            Map<String, Technician> techniciansFromJson = gson.fromJson(reader, Map.class);
            techniciansFromJson.put(technician.getId(), technician);
            String updateJson = gson.toJson(techniciansFromJson);
            FileWriter writer = new FileWriter(file);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else {
            technicians.put(technician.getId(), technician);
            String techniciansJson = gson.toJson(technicians);
            FileWriter writer = new FileWriter(file);
            writer.write(techniciansJson);
            writer.flush();
            writer.close();
        }

    }

    /**
     * Atualiza um objeto `Technician` no banco de dados.
     *
     * @param technician        O objeto `Technician` a ser atualizado.
     * @param attributeToChange O atributo do objeto a ser modificado.
     * @param newAttribute      O novo valor do atributo modificado.
     * @throws IOException Se ocorrer um erro durante a operação de leitura ou escrita do arquivo.
     */
    @Override
    public void updateTechnician(Technician technician, String attributeToChange, String newAttribute) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Technician> techniciansFromJson = readTechnicians();
        switch (attributeToChange.toLowerCase()) {
            case "name" -> techniciansFromJson.get(technician.getId()).setName(newAttribute);
            case "email" -> techniciansFromJson.get(technician.getId()).setEmail(newAttribute);
            case "phoneNumber" -> techniciansFromJson.get(technician.getId()).setPhoneNumber(newAttribute);
            case "address" -> techniciansFromJson.get(technician.getId()).setAddress(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        String techniciansToJson = gson.toJson(techniciansFromJson);
        FileWriter writer = new FileWriter("technicians.json");
        writer.write(techniciansToJson);
        writer.close();
    }

    /**
     * Atualiza o objeto `Os` associado a um técnico no banco de dados.
     *
     * @param tec O técnico para o qual a `Os` será associada.
     * @param os  O objeto `Os` a ser associado ao técnico.
     * @throws IOException Se ocorrer um erro durante a operação de leitura ou escrita do arquivo.
     */
    public void updateTechnicianOs(Technician tec, Os os) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Technician> techniciansFromJson = readTechnicians();
        techniciansFromJson.get(tec.getId()).setOs(os);
        String techniciansToJson = gson.toJson(techniciansFromJson);
        FileWriter writer = new FileWriter("technicians.json");
        writer.write(techniciansToJson);
        writer.close();
    }

    /**
     * Remove um objeto `Technician` do banco de dados.
     *
     * @param technician O objeto `Technician` a ser removido.
     * @throws IOException Se ocorrer um erro durante a operação de leitura ou escrita do arquivo.
     */
    @Override
    public void deleteTechnician(Technician technician) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Technician> techniciansFromJson = readTechnicians();
        techniciansFromJson.remove(technician.getId());
        String techniciansToJson = gson.toJson(techniciansFromJson);
        FileWriter writer = new FileWriter("technicians.json");
        writer.write(techniciansToJson);
        writer.close();
    }

    /**
     * Retorna uma lista com todos os técnicos cadastrados no banco de dados.
     *
     * @return Uma lista com todos os técnicos cadastrados no banco de dados.
     * @throws IOException Se ocorrer um erro durante a operação de leitura do arquivo.
     */
    @Override
    public Map<String, Technician> readTechnicians() throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("technicians.json"));
        Map<String, Technician> technicians = gson.fromJson(reader, new TypeToken<Map<String, Technician>>(){}.getType());
        return technicians;
    }

    /**
     * Retorna um objeto `Technician` com base no seu ID.
     *
     * @param id O ID do técnico desejado.
     * @return O objeto `Technician` com o ID fornecido.
     * @throws IOException Se ocorrer um erro durante a operação de leitura do arquivo.
     */
    @Override
    public Technician getTechnicianById(String id) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("technicians.json"));
        Map<String, Technician> technicians = gson.fromJson(reader, new TypeToken<Map<String, Technician>>(){}.getType());
        return technicians.get(id);
    }


}