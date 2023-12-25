module flowpane {
    requires javafx.controls;
    requires javafx.fxml;

    opens flowpane to javafx.fxml;
    exports flowpane;
}
