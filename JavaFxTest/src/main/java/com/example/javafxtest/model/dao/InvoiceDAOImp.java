package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Invoice;
import com.example.javafxtest.model.entities.*;
import com.example.javafxtest.model.entities.enums.Payments;

import java.util.ArrayList;

/**
 * Esta classe implementa a interface InvoiceDAO e fornece as operações de CRUD (Create, Read, Update, Delete)
 * para a entidade Invoice (Fatura).
 */
public class InvoiceDAOImp implements InvoiceDAO {

    public ArrayList<Invoice> invoiceList = new ArrayList<>();

    public InvoiceDAOImp() {
    }

    /**
     * Insere uma nova fatura na lista de faturas.
     *
     * @param invoice - a fatura a ser inserida.
     */
    @Override
    public void insertInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }

    /**
     * Atualiza o cliente associado a uma fatura.
     *
     * @param invoice   - a fatura a ser atualizada.
     * @param newClient - o novo cliente associado à fatura.
     */
    @Override
    public void updateInvoiceClient(Invoice invoice, Client newClient) {
        invoice.setClient(newClient);
    }

    /**
     * Atualiza o atendente associado a uma fatura.
     *
     * @param invoice      - a fatura a ser atualizada.
     * @param newAttendant - o novo atendente associado à fatura.
     */
    @Override
    public void updateInvoiceAttendant(Invoice invoice, Attendant newAttendant) {
        invoice.setAttendant(newAttendant);
    }

    /**
     * Atualiza o técnico associado a uma fatura.
     *
     * @param invoice       - a fatura a ser atualizada.
     * @param newTechnician - o novo técnico associado à fatura.
     */
    @Override
    public void updateInvoiceClient(Invoice invoice, Technician newTechnician) {
        invoice.setTechnician(newTechnician);
    }

    /**
     * Atualiza a Ordem de Serviço (Os) associada a uma fatura.
     *
     * @param invoice A fatura a ser atualizada.
     * @param newOs   A nova Ordem de Serviço associada à fatura.
     */
    @Override
    public void updateInvoiceOs(Invoice invoice, Os newOs) {
        invoice.setOs(newOs);
    }

    /**
     * Atualiza o método de pagamento associado a uma fatura.
     *
     * @param invoice - a fatura a ser atualizada.
     * @param payment - o novo método de pagamento associado à fatura.
     */
    @Override
    public void updateInvoicePayment(Invoice invoice, Payments payment) {

    }

    /**
     * Exclui uma fatura da lista de faturas.
     *
     * @param invoice - a fatura a ser excluída.
     */
    @Override
    public void deleteInvoice(Invoice invoice) {
        invoiceList.remove(invoice);
    }

    /**
     * Retorna a fatura fornecida como parâmetro.
     *
     * @param invoice - a fatura a ser retornada.
     * @return - a fatura fornecida como parâmetro.
     */
    @Override
    public Invoice viewInvoice(Invoice invoice) {
        return invoice;
    }

    /**
     * Método para retornar todas as faturas presentes na lista de faturas.
     *
     * @return - todas as faturas presentes na lista de faturas.
     */
    @Override
    public ArrayList<Invoice> getAllInvoices() {
        return invoiceList;
    }
}
