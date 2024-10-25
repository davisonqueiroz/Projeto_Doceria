module com.mycompany.gerenciador_doceria {
    requires com.github.librepdf.openpdf;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    

    
    opens com.mycompany.model to org.hibernate.orm.core,jakarta.persistence ;
    opens com.mycompany.controller to javafx.fxml;

    exports com.mycompany.controller;
    exports com.mycompany.model;
    

}
