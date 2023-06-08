package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface que apresenta o CRUD dos itens no estoque
 */
public interface StockDAO {
    void insertProduct(Product product) throws IOException;

    void deleteProduct(Product product) throws IOException;


    HashMap<String, Product> readProducts() throws IOException;

}
