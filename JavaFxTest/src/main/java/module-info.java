module com.example.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.javafxtest to javafx.fxml;
    exports com.example.javafxtest;
    exports com.example.javafxtest.controller;
    opens com.example.javafxtest.controller to javafx.fxml;
}