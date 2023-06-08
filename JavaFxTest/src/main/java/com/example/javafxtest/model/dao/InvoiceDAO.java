package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Invoice;
import com.example.javafxtest.model.entities.*;
import com.example.javafxtest.model.entities.enums.Payments;

import java.util.ArrayList;

/**
 * Interface responsável por definir as operações de acesso aos dados de Fatura no banco de dados.
 */
public interface InvoiceDAO {
    void insertInvoice(Invoice invoice);

    void updateInvoiceClient(Invoice invoice, Client client);

    void updateInvoiceAttendant(Invoice invoice, Attendant attendant);

    void updateInvoiceClient(Invoice invoice, Technician technician);

    void updateInvoiceOs(Invoice invoice, Os os);

    void updateInvoicePayment(Invoice invoice, Payments payment);

    void deleteInvoice(Invoice invoice);

    Invoice viewInvoice(Invoice invoice);

    ArrayList<Invoice> getAllInvoices();
}
