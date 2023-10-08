module fulllogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens fulllogin to javafx.fxml;
    exports fulllogin;
    exports controller;
}
