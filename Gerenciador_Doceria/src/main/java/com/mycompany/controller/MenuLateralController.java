package com.mycompany.controller;

import java.io.IOException;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

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
            telaPrincipalController.esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void esconderMenu(){
               

    }

}
