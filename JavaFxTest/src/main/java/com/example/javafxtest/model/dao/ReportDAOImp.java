package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Report;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ReportDAOImp implements ReportDAO {

    /**
            * Gera um nome de arquivo com base no nome do relatório e na data atual.
     *
             * @param report O relatório para o qual o nome do arquivo será gerado.
     * @return O nome do arquivo gerado.
            */
    public String getFilename(Report report) {
        var now = new Date();
        return "report-" + report.getName() + "__" + now.getYear()+now.getMonth()+now.getDay() + ".txt";
    }

    /**
     * Salva um relatório em um arquivo de texto.
     *
     * @param report O relatório a ser salvo.
     * @throws Exception               Se ocorrer um erro ao criar ou escrever no arquivo.
     * @throws UnsupportedEncodingException Se ocorrer um erro de codificação não suportada.
     */

    @Override
    public void saveReport(Report report) throws Exception, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(getFilename(report), StandardCharsets.UTF_8);
        writer.println(report.generateAsString());
        writer.close();
    }

}
