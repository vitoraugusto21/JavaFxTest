package com.example.javafxtest.model.entities;

/**
 * A classe abstrata Person representa uma pessoa genérica.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public abstract class Person {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    /**
     * Constrói um objeto Person vazio.
     */
    public Person() {
    }

    /**
     * Constrói um objeto Person com os campos especificados.
     *
     * @param id          - o ID da pessoa
     * @param name        - o nome da pessoa
     * @param phoneNumber - o número de telefone da pessoa
     * @param email       - o e-mail da pessoa
     * @param address     - o endereço da pessoa
     */
    public Person(String id, String name, String phoneNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Método para retornar uma representação em string do objeto Person.
     *
     * @return - retorna uma representação em string do objeto Person.
     */
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}


