package com.example.javafxtest.model.entities;

/**
 * A classe Manager representa um gerente que trabalha na empresa de manutenção.
 * Esta classe herda da classe Person e adiciona um campo de senha.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public class Manager extends Person {

    /**
     * A senha do gerente.
     */
    private final String mPassword;

    /**
     * Constrói um objeto Manager com os campos especificados.
     *
     * @param id          - o ID do gerente
     * @param name        - o nome do gerente
     * @param phoneNumber - o número de telefone do gerente
     * @param email       - o e-mail do gerente
     * @param address     - o endereço do gerente
     * @param mPassword   - a senha do gerente
     */
    public Manager(String id, String name, String phoneNumber, String email, String address, String mPassword) {
        super(id, name, phoneNumber, email, address);
        this.mPassword = mPassword;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        mPassword = mPassword;
    }
}
