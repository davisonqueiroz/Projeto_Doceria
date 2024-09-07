module com.mycompany.gerenciador_doceria {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.controller to javafx.fxml;
    exports com.mycompany.controller;
}
