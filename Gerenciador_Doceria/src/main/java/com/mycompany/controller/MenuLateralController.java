package com.mycompany.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MenuLateralController {

    @FXML
    private HBox HBoxInicio;
    
    private TelaPrincipalController telaPrincipalController;
    
    public void lockarTelaPrincipal(TelaPrincipalController controller){
        
        this.telaPrincipalController = controller;
    }

    @FXML
    void abrirTelaInicio(MouseEvent event) {

        try {

            telaPrincipalController.setarCentro("/view/TelaInicio.fxml");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
