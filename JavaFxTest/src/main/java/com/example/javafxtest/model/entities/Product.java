package com.example.javafxtest.model.entities;

/**
 * Classe que representa um produto.
 */
public class Product {
    private String productCode;
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
    private Double productCost;

    public Product() {
    }

    /**
     * Construtor que recebe os dados do produto.
     *
     * @param productCode     - código do produto.
     * @param productName     - nome do produto.
     * @param productPrice    - preço do produto.
     * @param productQuantity - quantidade do produto em estoque.
     */
    public Product(String productCode, String productName, Double productPrice, Integer productQuantity, Double productCost) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }
}
