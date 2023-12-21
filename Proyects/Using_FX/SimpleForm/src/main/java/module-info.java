module form {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    //requires lombok;
    
    opens form to javafx.fxml;
    opens form.controller;
    
    exports form;
    exports form.controller;
    exports form.entity;
}
