module formwithfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens formwithfx to javafx.fxml;
    opens formwithfx.controller;
    exports formwithfx;
    exports formwithfx.controller;
}
