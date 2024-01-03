module form.javafxcrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens form.javafxcrud to javafx.fxml;
    exports form.javafxcrud;
    exports form.javafxcrud.controller;
            }
