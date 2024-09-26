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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class TelaPrincipalController implements Initializable {

    @FXML
    private BorderPane BorderPanePrincipal;

    @FXML
    private Label LabelMenu;

    @FXML
    private Pane PaneMenu;

    @FXML
    void abrirMenu(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuLateral.fxml"));
            VBox menuLateral = loader.load();

            MenuLateralController menuController = loader.getController();
            menuController.lockarTelaPrincipal(this);

            BorderPanePrincipal.setLeft(menuLateral);

            menuLateral.setTranslateX(-menuLateral.getWidth());

            TranslateTransition menu = new TranslateTransition();
            menu.setDuration(Duration.seconds(0.4));
            menu.setNode(menuLateral);
            LabelMenu.setVisible(false);
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
    
    public void esconderMenuLateral(){
        
         try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuLateral.fxml"));
            VBox menuLateral = loader.load();


            TranslateTransition painel = new TranslateTransition();
            painel.setDuration(Duration.seconds(0.4));
            painel.setNode(PaneMenu);
            painel.setToX(0);
            PaneMenu.setPrefWidth(PaneMenu.getWidth() - 55 );
            PaneMenu.setTranslateX(+55);

            painel.play();
            
            LabelMenu.setVisible(true);
            BorderPanePrincipal.setLeft(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void telaFornecedor(){
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroCliente.fxml"));
            Parent cadastroCliente = loader.load();

            MenuLateralController menuController = loader.getController();
            menuController.lockarTelaPrincipal(this);
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

        } catch (Exception e) {
        }

    }

}
