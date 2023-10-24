module loginfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens loginfx to javafx.fxml;
    exports loginfx;
}
