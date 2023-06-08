package com.example.javafxtest.model.entities;

import com.example.javafxtest.model.entities.enums.Payments;

/**
 * Classe que representa uma fatura emitida pela empresa para um cliente
 * com as informações dos produtos comprados e os valores
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public class Invoice {
    private Client client;
    private Technician technician;
    private Attendant attendant;
    private Os os;
    private Payments payment;

    public Invoice(Client client, Technician technician, Attendant attendant, Os os, Payments payment) {
        this.client = client;
        this.technician = technician;
        this.attendant = attendant;
        this.os = os;
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Attendant getAttendant() {
        return attendant;
    }

    public void setAttendant(Attendant attendant) {
        this.attendant = attendant;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Fatura: " +
                "Cliente: " + client.getName() +
                ", Tecnico: " + technician.getName() +
                ", Atendente: " + attendant.getName() +
                ", Valor Total: " + os.getTotalValue() +
                ", Forma de pagamento: " + payment +
                os.getDescription();
    }
}
