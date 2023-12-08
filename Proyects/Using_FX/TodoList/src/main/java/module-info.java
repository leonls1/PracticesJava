module todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;


    opens todolist to javafx.fxml;
    opens todolist.controller;
    opens todolist.model;
            
    exports todolist.controller;
    exports todolist;
}
