package com.example.javafxtest.model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.example.javafxtest.model.entities.Attendant;
import com.example.javafxtest.model.entities.Product;

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
 * Classe responsável pela implementação do estoque (Stock) de produtos.
 */
public class StockDAOImp implements StockDAO {

    private final Map<String, Product> stock = new HashMap<>();

    File file = new File(System.getProperty("user.dir") + File.separator + "stock.json");

    public StockDAOImp() {

    }

    /**
     * Insere um produto no estoque.
     *
     * @param product O produto a ser inserido no estoque.
     * @throws IOException Se ocorrer um erro durante a operação de leitura ou escrita do arquivo.
     */
    @Override
    public void insertProduct(Product product) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (file.exists()){
            Reader reader = Files.newBufferedReader(Paths.get("stock.json"));
            Map<String, Product> productsFromJson = gson.fromJson(reader, Map.class);
            productsFromJson.put(product.getProductCode(), product);
            String updateJson = gson.toJson(productsFromJson);
            FileWriter writer = new FileWriter(file);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else {
            stock.put(product.getProductCode(), product);
            String productsJson = gson.toJson(stock);
            FileWriter writer = new FileWriter(file);
            writer.write(productsJson);
            writer.flush();
            writer.close();
        }
    }

    /**
     * Remove um produto do estoque.
     *
     * @param product O produto a ser removido do estoque.
     * @throws IOException Se ocorrer um erro durante a operação de leitura ou escrita do arquivo.
     */
    @Override
    public void deleteProduct(Product product) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Product> productsFromJson = readProducts();
        productsFromJson.remove(product.getProductCode());
        String productsToJson = gson.toJson(productsFromJson);
        FileWriter writer = new FileWriter("stock.json");
        writer.write(productsToJson);
        writer.close();
    }

    /**
     * Retorna uma lista com todos os produtos do estoque.
     *
     * @return Uma lista com todos os produtos do estoque.
     * @throws IOException Se ocorrer um erro durante a operação de leitura do arquivo.
     */
    @Override
    public HashMap<String, Product> readProducts() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("stock.json"));
        Map<String, Product> stock = gson.fromJson(reader, new TypeToken<Map<String, Product>>(){}.getType());
        return (HashMap<String, Product>) stock;
    }
}
