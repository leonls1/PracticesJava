module guicontrolsexample {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens guicontrolsexample to javafx.fxml;
    opens controller to javafx.fxml;
 
    exports guicontrolsexample;
    exports controller;
}
