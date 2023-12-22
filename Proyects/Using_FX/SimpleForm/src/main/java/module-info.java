module form {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.base;
    //requires lombok;
    
    opens form to javafx.fxml;
    opens form.controller;
    opens form.entity;
    
    exports form;
    exports form.controller;
    exports form.entity;
}
