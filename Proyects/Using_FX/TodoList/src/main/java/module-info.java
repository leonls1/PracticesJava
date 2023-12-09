module todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;

    opens todolist to javafx.fxml;
    opens todolist.model.entity;

    opens todolist.controller;
            
    exports todolist.controller;
    exports todolist to javafx.graphics;
    exports todolist.model;

}
