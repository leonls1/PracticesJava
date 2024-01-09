module Task {
    requires javafx.controls;
    requires javafx.fxml;

    opens Task to javafx.fxml;
    exports Task;
}
