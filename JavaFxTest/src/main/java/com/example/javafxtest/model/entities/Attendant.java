package com.example.javafxtest.model.entities;


/**
 * A classe Attendant representa um atendente que trabalha na empresa de manutenção de computadores.
 * Esta classe herda da classe Person e adiciona um campo de senha.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public class Attendant extends Person {

    /**
     * A senha do atendente.
     */
    private String aPassword;


    /**
     * Constrói um objeto Attendant com os campos especificados.
     *
     * @param id          - o ID do atendente
     * @param name        - o nome do atendente
     * @param phoneNumber - o número de telefone do atendente
     * @param email       - o e-mail do atendente
     * @param address     - o endereço do atendente
     * @param aPassword   - a senha do atendente
     */
    public Attendant(String id, String name, String phoneNumber, String email, String address, String aPassword) {
        super(id, name, phoneNumber, email, address);
        this.aPassword = aPassword;
    }

    public Attendant(String id, String name, String phoneNumber, String email, String address) {
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

}
