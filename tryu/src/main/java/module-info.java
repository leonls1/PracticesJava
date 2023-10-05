module tryu {
    requires javafx.controls;
    requires javafx.fxml;

    opens tryu to javafx.fxml;
    exports tryu;
}
