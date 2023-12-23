module form.crud_gpt {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.base;

    opens form.crud_gpt to javafx.fxml;
    exports form.crud_gpt;
}
