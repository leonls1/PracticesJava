module cbocomplete {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens cbocomplete to javafx.fxml;
    opens cbocomplete.controller;
    exports cbocomplete;
    exports cbocomplete.controller;
}
