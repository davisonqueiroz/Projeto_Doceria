module com.mycompany.gerenciador_doceria {
    requires com.github.librepdf.openpdf;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires jakarta.persistence;

    opens com.mycompany.controller to javafx.fxml;
    exports com.mycompany.controller;
}
