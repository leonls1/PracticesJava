module cbocomplete {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens cbocomplete to javafx.fxml;
    exports cbocomplete;
    exports cbocomplete.controller;
}
