module SceneBuilder {
    requires javafx.controls;
    requires javafx.fxml;

    opens SceneBuilder to javafx.fxml;
    exports SceneBuilder;
}
