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
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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
    private Button ButtonCliente1;

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
    private TableView<?> TableViewCliente;

    @FXML
    private TableView<?> TableViewFornecedor;

    @FXML
    private TextField TextFieldCliente;

    @FXML
    private TextField TextFieldFornecedor;

    @FXML
    private VBox VBoxCliente;

    @FXML
    private VBox VBoxClienteBarra;

    @FXML
    private VBox VBoxClienteBarra1;

    @FXML
    private VBox VBoxFornecedor;


    @FXML
    void abrirFormularioCliente(MouseEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroCliente.fxml"));
            Scene scene = new Scene(root, 600, 687);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.requestFocus();
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void AbrirFormularioFornecedor(MouseEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroFornecedor.fxml"));
            Scene scene = new Scene(root, 520, 550);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.requestFocus();
            stage.setScene(scene);
            stage.showAndWait();
            stage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
            
        }

    }

     @FXML
    void abrirMenuCliente(MouseEvent event) {
        
        VBoxCliente.setVisible(true);
        VBoxFornecedor.setVisible(false);

    }

    @FXML
    void abrirMenuFornecedor(MouseEvent event) {
        
        VBoxCliente.setVisible(false);
        VBoxFornecedor.setVisible(true);


    }

}
