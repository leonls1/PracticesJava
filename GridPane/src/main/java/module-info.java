module gridpane {
    requires javafx.controls;
    requires javafx.fxml;

    opens gridpane to javafx.fxml;
    exports gridpane;
}
