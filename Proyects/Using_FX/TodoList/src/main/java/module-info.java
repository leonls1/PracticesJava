module todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens todolist to javafx.fxml;
    opens todolist.controller;
    
    exports todolist.controller;
    exports todolist;
}
