module guicontrolsexample {
    requires javafx.controls;
    requires javafx.fxml;

    opens guicontrolsexample to javafx.fxml;
 
    exports guicontrolsexample;
    exports controller;
}
