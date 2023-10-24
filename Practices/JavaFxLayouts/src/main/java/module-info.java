module javafxlayouts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens javafxlayouts to javafx.fxml;
    exports javafxlayouts;
}
