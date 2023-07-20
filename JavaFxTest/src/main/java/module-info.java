module com.example.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.javafxtest to javafx.fxml;
    exports com.example.javafxtest;
    exports com.example.javafxtest.controller;
    exports com.example.javafxtest.model.entities.enums to com.google.gson;
    opens com.example.javafxtest.controller to javafx.fxml;
    opens com.example.javafxtest.model.entities to com.google.gson;
    opens com.example.javafxtest.model.dao to com.google.gson;
}