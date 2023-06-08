package com.example.javafxtest.model.dao;

import com.example.javafxtest.model.entities.Report;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface ReportDAO {
    void saveReport(Report report) throws Exception, UnsupportedEncodingException;
}
