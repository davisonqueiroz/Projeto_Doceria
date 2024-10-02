/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class CadastrosController {

 

    @FXML
    private Button ButtonAdicionarCliente;

    @FXML
    private Button ButtonAdicionarFornecedor;

    @FXML
    private Button ButtonCliente;

    @FXML
    private Button ButtonFiltroCliente;

    @FXML
    private Button ButtonFiltroFornecedor;

    @FXML
    private Button ButtonFornecedor;

    @FXML
    private ComboBox<?> ComboBoxCliente;

    @FXML
    private ComboBox<?> ComboBoxFornecedor;

    @FXML
    private Pane PaneFornecedorTabela;

    @FXML
    private Pane PaneTabelaCliente;

    @FXML
    private TableView<?> TableViewCliente;

    @FXML
    private TableView<?> TableViewFornecedor;

    @FXML
    private TextField TextFieldCliente;

    @FXML
    private TextField TextFieldFornecedor;

    @FXML
    private VBox VBoxClienteBarra;

    @FXML
    private VBox VBoxFornecedorBarra;

    @FXML
    void abrirFormularioCliente(MouseEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroCliente.fxml"));
            Scene scene = new Scene(root, 600, 687);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
        @FXML
    void AbrirFormularioFornecedor(MouseEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroFornecedor.fxml"));
            Scene scene = new Scene(root,520,550);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    void abrirMenuFornecedor(MouseEvent event) {

        try {

            PaneTabelaCliente.setVisible(false);
            PaneFornecedorTabela.setVisible(true);

            VBoxClienteBarra.setVisible(false);
            VBoxFornecedorBarra.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void abrirMenuCliente(MouseEvent event) {

        PaneTabelaCliente.setVisible(true);
        PaneFornecedorTabela.setVisible(false);

        VBoxClienteBarra.setVisible(true);
        VBoxFornecedorBarra.setVisible(false);

    }

}
