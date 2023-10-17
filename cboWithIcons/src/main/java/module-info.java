module cbowithicons {
    requires javafx.controls;
    requires javafx.fxml;

    opens cbowithicons to javafx.fxml;
    exports cbowithicons;
}
