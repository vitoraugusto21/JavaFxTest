package com.example.javafxtest.model.entities;

/**
 * Representa um técnico no sistema de gerenciamento de ordens de serviço.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public class Technician extends Person {
    private String tPassword;
    private Os os;

    /**
     * Construtor padrão.
     */
    public Technician(String number, String john, String mail, String id, String s) {
    }


    /**
     * Cria um técnico sem especificar uma ordem de serviço.
     *
     * @param id          - o identificador do técnico
     * @param name        - o nome do técnico
     * @param phoneNumber - o número de telefone do técnico
     * @param email       - o endereço de email do técnico
     * @param address     - o endereço do técnico
     * @param tPassword   - a senha do técnico
     */
    public Technician(String id, String name, String phoneNumber, String email, String address, String tPassword) {
        super(id, name, phoneNumber, email, address);
        this.tPassword = tPassword;
    }

    /**
     * Cria um técnico especificando uma ordem de serviço.
     *
     * @param id          - o identificador do técnico
     * @param name        - o nome do técnico
     * @param phoneNumber - o número de telefone do técnico
     * @param email       - o endereço de email do técnico
     * @param address     - o endereço do técnico
     * @param tPassword   - a senha do técnico
     * @param os          - a ordem de serviço atribuída ao técnico
     */
    public Technician(String id, String name, String phoneNumber, String email, String address, String tPassword, Os os) {
        super(id, name, phoneNumber, email, address);
        this.tPassword = tPassword;
        this.os = os;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    /**
     * Método para retornar uma representação em string do técnico.
     *
     * @return - retorna uma representação em string do técnico
     */
    @Override
    public String toString() {
        return "Technician{" +
                "tPassword='" + tPassword + '\'' +
                '}';
    }
}
