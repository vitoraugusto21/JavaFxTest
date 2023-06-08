package com.example.javafxtest.model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.example.javafxtest.model.entities.Attendant;
import com.example.javafxtest.model.entities.Manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Classe que implementa a interface ManagerDAO e realiza operações de CRUD (criação, leitura, atualização e exclusão)
 * em objetos da classe Manager utilizando uma estrutura de mapeamento em hash.
 */
public class ManagerDAOImp implements ManagerDAO {

    private final Map<String, Manager> managers = new HashMap<>();

    File file = new File(System.getProperty("user.dir") + File.separator + "managers.json");

    public ManagerDAOImp() {
    }

    /**
     * Método que realiza o gerenciamento de estoque.
     */
    @Override
    public void manageStock() {
        // Implementação do método para gerenciar estoque
    }

    /**
     * Método que realiza o gerenciamento de estoque.
     */
    @Override
    public void viewReports() {
        // Implementação do método para visualizar relatórios
    }

    /**
     * Método que realiza o gerenciamento de estoque.
     *
     * @param manager - objeto da classe Manager a ser inserido
     */
    @Override
    public void createManager(Manager manager) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (file.exists()) {
            Reader reader = Files.newBufferedReader(Paths.get("managers.json"));
            Map<String, Manager> managersFromJson = gson.fromJson(reader, Map.class);
            managersFromJson.put(manager.getId(), manager);
            String updateJson = gson.toJson(managersFromJson);
            FileWriter writer = new FileWriter(file);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else {
            managers.put(manager.getId(), manager);
            String managersJson = gson.toJson(managers);
            FileWriter writer = new FileWriter(file);
            writer.write(managersJson);
            writer.flush();
            writer.close();
        }
    }

    /**
     * Método que atualiza um objeto da classe Manager na estrutura de mapeamento em hash.
     *
     * @param manager           - objeto da classe Manager a ser atualizado.
     * @param attributeToChange - nome do atributo a ser alterado.
     * @param newAttribute      - novo valor do atributo a ser alterado.
     * @throws IllegalArgumentException - se o nome do atributo fornecido não for válido.
     */
    @Override
    public void updateManager(Manager manager, String attributeToChange, String newAttribute) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Manager> managersFromJson = readManagers();

        switch (attributeToChange.toLowerCase()) {
            case "email" -> managersFromJson.get(manager.getId()).setEmail(newAttribute);
            case "phonenumber" -> managersFromJson.get(manager.getId()).setPhoneNumber(newAttribute);
            case "address" -> managersFromJson.get(manager.getId()).setAddress(newAttribute);
            case "password" -> managersFromJson.get(manager.getId()).setPassword(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        String managersToJson = gson.toJson(managersFromJson);
        FileWriter writer = new FileWriter("managers.json");
        writer.write(managersToJson);
        writer.close();
    }

    /**
     * Método que exclui um objeto da classe Manager da estrutura de mapeamento em hash.
     *
     * @param manager objeto da classe Manager a ser excluído.
     * @param manager
     */
    @Override
    public void deleteManager(Manager manager) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Manager> managersFromJson = readManagers();
        managersFromJson.remove(manager.getId());
        String managersToJson = gson.toJson(managersFromJson);
        FileWriter writer = new FileWriter("managers.json");
        writer.write(managersToJson);
        writer.close();
    }

    /**
     * Método que retorna uma lista contendo todos os objetos da classe Manager presentes na estrutura de mapeamento em hash.
     *
     * @return lista contendo todos os objetos da classe Manager presentes na estrutura de mapeamento em hash.
     */
    @Override
    public Map<String, Manager> readManagers() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("managers.json"));
        Map<String, Manager> managers = gson.fromJson(reader, new TypeToken<Map<String, Manager>>(){}.getType());
        return managers;
    }

    /**
     * Método que retorna um objeto da classe Manager presente na estrutura de mapeamento em hash a partir do seu identificador.
     *
     * @param id - identificador do objeto da classe Manager a ser retornado.
     * @return - objeto da classe Manager presente na estrutura de mapeamento em hash a partir do seu identificador.
     */
    @Override
    public Manager getManagerById(String id) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("managers.json"));
        Map<String, Manager> managers = gson.fromJson(reader, new TypeToken<Map<String, Manager>>(){}.getType());
        return managers.get(id);
    }


}
