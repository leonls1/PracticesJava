module GUIExample {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens GUIExample to javafx.fxml;
    exports GUIExample.app;
}
