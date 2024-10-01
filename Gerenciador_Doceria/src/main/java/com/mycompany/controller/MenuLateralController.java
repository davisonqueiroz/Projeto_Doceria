package com.mycompany.controller;

import java.io.IOException;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MenuLateralController {

    @FXML
    private HBox HBoxCadastros;

    @FXML
    private HBox HBoxConfig;

    @FXML
    private HBox HBoxEstoque;

    @FXML
    private HBox HBoxInicio;

    @FXML
    private HBox HBoxOrcamento;

    @FXML
    private HBox HBoxPedidos;

    @FXML
    private HBox HBoxVendas;

    private TelaPrincipalController telaPrincipalController;

    public void lockarTelaPrincipal(TelaPrincipalController controller) {

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

    @FXML
    void abrirTelaCadastros(MouseEvent event) {

        try {
           
            telaPrincipalController.setarCentro("/view/TelaCadastros.fxml");
            telaPrincipalController.esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaConfig(MouseEvent event) {

        try {

            telaPrincipalController.setarCentro("/view/TelaInicio.fxml");
            telaPrincipalController.esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaEstoque(MouseEvent event) {

        try {

            telaPrincipalController.setarCentro("/view/TelaEstoque.fxml");
            telaPrincipalController.esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    void abrirTelaOrcamento(MouseEvent event) {

        try {

            telaPrincipalController.setarCentro("/view/TelaInicio.fxml");
            telaPrincipalController.esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaPedidos(MouseEvent event) {

        try {

            telaPrincipalController.setarCentro("/view/TelaPedidos.fxml");
            telaPrincipalController.esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaVendas(MouseEvent event) {

        try {

            telaPrincipalController.setarCentro("/view/TelaVendas.fxml");
            telaPrincipalController.esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
