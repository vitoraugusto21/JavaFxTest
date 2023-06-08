package com.example.javafxtest.model.entities;

import java.util.ArrayList;

/**
 * Classe que representa o estoque de produtos.
 * Herda as propriedades da classe Product.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public class Stock extends Product {
    private ArrayList<Product> listProducts;

    public Stock() {
    }

    /**
     * Construtor com argumentos.
     *
     * @param productCode     - código ou id do produto
     * @param productName     - nome do produto
     * @param productPrice    - preço do produto
     * @param productQuantity - quantidade do produto
     * @param listProducts    - lista de produtos
     */
    public Stock(String productCode, String productName, Double productPrice, Integer productQuantity, ArrayList<Product> listProducts) {
        this.listProducts = listProducts;


    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    /**
     * Define a lista de produtos do estoque.
     *
     * @param listProducts - lista de produtos
     */
    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
}
