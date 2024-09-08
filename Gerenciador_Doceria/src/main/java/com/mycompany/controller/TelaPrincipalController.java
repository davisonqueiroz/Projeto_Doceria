package com.mycompany.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class TelaPrincipalController implements Initializable {

    @FXML
    private Label LabelMenu;

    @FXML
    private Pane PaneMenu;

    @FXML
    private VBox vBoxMenuLateral;

    @FXML
    void abrirMenu(MouseEvent event) {

        TranslateTransition menu = new TranslateTransition();
        menu.setDuration(Duration.seconds(0.4));
        menu.setNode(vBoxMenuLateral);
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

    }
    
        @FXML
    void menuInicio(MouseEvent event) {
        TranslateTransition menu = new TranslateTransition();
        menu.setDuration(Duration.seconds(0.4));
        menu.setNode(vBoxMenuLateral);
        LabelMenu.setVisible(true);
        menu.setToX(-120);
        
        TranslateTransition painel = new TranslateTransition();
        painel.setDuration(Duration.seconds(0.4));
        painel.setNode(PaneMenu);
        painel.setToX(0);
        PaneMenu.setTranslateX(60);
        PaneMenu.setPrefWidth(PaneMenu.getWidth() - 60);
        
        painel.play();
        menu.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vBoxMenuLateral.setTranslateX(-200);
    }

}
