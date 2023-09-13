package com.example.javafxtest.model.entities;

import com.example.javafxtest.model.entities.enums.OsStatus;
import com.example.javafxtest.model.entities.enums.Payments;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que representa uma Ordem de Serviço (OS) no sistema de gerenciamento.
 */
public class Os {
    private String osId;
    private String description;
    private Date startTime;
    private Date endTime;
    private Double totalValue = 0.00;
    private OsStatus status;
    private Payments typePayment;
    private Integer cleaning = 70;
    private Integer operationalSystem = 50;
    private Integer programs = 10;
    private String attendantId;
    private String technicianId;
    private String clientId;
    private ArrayList<Product> usedParts = new ArrayList<>();

    /**
     * Construtor que recebe o identificador da OS (Ordem de serviço) como parâmetro.
     *
     * @param osId - identificador da OS (Ordem de serviço)
     */
    public Os(String osId) {
        this.osId = osId;
        this.startTime = new Date();
    }


    /**
     * Construtor que recebe alguns dados da OS como parâmetros.
     *
     * @param osId        - identificador da OS
     * @param description - descrição da OS
     * @param startTime   - data e hora de início da OS
     * @param clientId    - identificador do cliente associado à OS
     */
    public Os(String osId, String description, Date startTime, String clientId) {
        this.osId = osId;
        this.description = description;
        this.startTime = startTime;
        this.clientId = clientId;
    }

    /**
     * Adiciona as partes utilizadas à Os.
     *
     * @param part - Parte a ser adicionada à Os.
     */
    public void addParts(Product part) {
        if (part.getProductQuantity() < 1) {
            System.out.println("Produto indisponivel!");
        } else {
            this.getUsedParts().add(part);
            Double totalValue = this.getTotalValue() + part.getProductPrice();
            int quantity = part.getProductQuantity() - 1;
            part.setProductQuantity(quantity);
            this.setTotalValue(totalValue);
        }
    }

    /**
     * adicionar qual foi o tempo de duração da OS
     */
    public long calculateAverageAwait() {
        LocalDate date1 = LocalDate.of(this.getStartTime().getYear(), this.getStartTime().getMonth(), this.getStartTime().getDay());
        if (endTime != null) {
            LocalDate date2 = LocalDate.of(this.getEndTime().getYear(), this.getEndTime().getMonth(), this.getEndTime().getDay());
            return ChronoUnit.DAYS.between(date1, date2);
        }
        return 0;
    }

    public void addPrograms(int quantity) { //adicionar os programas (e quantos) a os
        Double totalValue = this.getTotalValue() + (this.getPrograms() * quantity);
        this.setTotalValue(totalValue);
    }


    /**
     * Adiciona o valor de limpeza à Os.
     */
    public void cleaning() { //adicionar limpeza a OS
        Double totalValue = this.getTotalValue() + this.getCleaning();
        this.setTotalValue(totalValue);
    }

    /**
     * Adiciona o valor do sistema operacional à Os.
     */
    public void addOperationalSystem() {
        Double totalValue = this.getTotalValue() + this.getOperationalSystem();
        this.setTotalValue(totalValue);
    }

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public OsStatus getStatus() {
        return status;
    }

    public void setStatus(OsStatus status) {
        this.status = status;
    }

    public Payments getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(Payments typePayment) {
        this.typePayment = typePayment;
    }

    public Integer getCleaning() {
        return cleaning;
    }

    public void setCleaning(Integer cleaning) {
        this.cleaning = cleaning;
    }

    public Integer getOperationalSystem() {
        return operationalSystem;
    }

    public void setOperationalSystem(Integer operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

    public Integer getPrograms() {
        return programs;
    }

    public void setPrograms(Integer programs) {
        this.programs = programs;
    }

    public String getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(String attendantId) {
        this.attendantId = attendantId;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ArrayList<Product> getUsedParts() {
        return usedParts;
    }

    public void setUsedParts(ArrayList<Product> usedParts) {
        this.usedParts = usedParts;
    }

    @Override
    public String toString() {
        return osId;
    }
}
