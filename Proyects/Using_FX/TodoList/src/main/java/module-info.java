module todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.orm;
    requires spring.tx;

    opens todolist to javafx.fxml;
    opens todolist.controller;
    opens todolist.model;
            
    exports todolist.controller;
    exports todolist;
}
