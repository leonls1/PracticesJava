module todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;
    requires lombok;
    requires spring.boot;

    opens todolist to javafx.fxml;
    opens todolist.controller;
    
    exports todolist.controller;
    exports todolist;
}
