module javafx.incidentmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens javafx.incidentmanager to javafx.fxml;
    exports javafx.incidentmanager;
}
