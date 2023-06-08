package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Report;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ReportDAOImp implements ReportDAO {

    public String getFilename(Report report) {
        var now = new Date();
        return "report-" + report.getName() + "__" + now.getYear()+now.getMonth()+now.getDay() + ".txt";
    }

    @Override
    public void saveReport(Report report) throws Exception, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(getFilename(report), StandardCharsets.UTF_8);
        writer.println(report.generateAsString());
        writer.close();
    }

}

/**
 * public String toString() {
 * return "Fatura: " +
 * "Cliente: " + client.getName() +
 * ", Tecnico: " + technician.getName() +
 * ", Atendente: " + attendant.getName() +
 * ", Valor Total: " + os.getTotalValue() +
 * ", Forma de pagamento: " + payment +
 * os.getDescription();
 * }
 */
