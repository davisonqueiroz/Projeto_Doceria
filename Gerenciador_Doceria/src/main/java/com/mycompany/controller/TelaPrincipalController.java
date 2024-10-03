package com.mycompany.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TelaPrincipalController implements Initializable {

       @FXML
    private BorderPane BorderPanePrincipal;

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

    @FXML
    private Label LabelMenu;

    @FXML
    private Pane PaneMenu;

    @FXML
    private VBox VBoxMenuLateral;
    
    @FXML
    void abrirMenu(MouseEvent event) {

        try {

            BorderPanePrincipal.setLeft(VBoxMenuLateral);

            VBoxMenuLateral.setTranslateX(-120);
            VBoxMenuLateral.setVisible(true);

            TranslateTransition menu = new TranslateTransition();
            menu.setDuration(Duration.seconds(0.4));
            menu.setNode(VBoxMenuLateral);
            LabelMenu.setVisible(false);
            VBoxMenuLateral.setPrefWidth(VBoxMenuLateral.getWidth());
            menu.setToX(0);

            TranslateTransition painel = new TranslateTransition();
            painel.setDuration(Duration.seconds(0.4));
            painel.setNode(PaneMenu);
            painel.setToX(0);
            PaneMenu.setPrefWidth(PaneMenu.getWidth() + 60);
            PaneMenu.setTranslateX(-60);

            painel.play();
            menu.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setarCentro(String fxml) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent telaSetada = loader.load();
            BorderPanePrincipal.setCenter(telaSetada);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void esconderMenuLateral() {

        try {

            TranslateTransition painel = new TranslateTransition();
            painel.setDuration(Duration.seconds(0.4));
            painel.setNode(PaneMenu);
            painel.setToX(-60);
            PaneMenu.setPrefWidth(PaneMenu.getWidth() - 55);
            PaneMenu.setTranslateX(0);

            TranslateTransition menu = new TranslateTransition();
            painel.setDuration(Duration.seconds(0.4));
            painel.setNode(VBoxMenuLateral);
            painel.setToX(-120);

            menu.setOnFinished(e -> {

                VBoxMenuLateral.setVisible(false);
                BorderPanePrincipal.setLeft(null);
                LabelMenu.setVisible(true);
            });

            

            painel.play();
            menu.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void telaFornecedor() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroCliente.fxml"));
            Parent cadastroCliente = loader.load();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaInicio.fxml"));
            AnchorPane telaInicial = loader.load();

            BorderPanePrincipal.setCenter(telaInicial);
            BorderPanePrincipal.setLeft(null);

        } catch (Exception e) {
        }

    }

    @FXML
    void abrirTelaInicio(MouseEvent event) {

        try {

            setarCentro("/view/TelaInicio.fxml");
            esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void abrirTelaCadastros(MouseEvent event) {

        try {

            setarCentro("/view/TelaCadastros.fxml");
            esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaConfig(MouseEvent event) {

        try {

            setarCentro("/view/TelaInicio.fxml");
            esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaEstoque(MouseEvent event) {

        try {

            setarCentro("/view/TelaEstoque.fxml");
            esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaOrcamento(MouseEvent event) {

         try {

            Parent root = FXMLLoader.load(getClass().getResource("/view/FormularioOrcamento.fxml"));
            Scene scene = new Scene(root, 700, 900);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaPedidos(MouseEvent event) {

        try {

            setarCentro("/view/TelaPedidos.fxml");
            esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTelaVendas(MouseEvent event) {

        try {

            setarCentro("/view/TelaVendas.fxml");
            esconderMenuLateral();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
