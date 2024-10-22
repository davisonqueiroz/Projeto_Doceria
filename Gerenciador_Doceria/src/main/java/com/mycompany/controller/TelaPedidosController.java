/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TelaPedidosController implements Initializable {
    
    

     @FXML
    private Button BtnNvPedido;

    @FXML
    void adicionarPedido(MouseEvent event) {
        
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroPedido.fxml"));
            Scene scene = new Scene(root, 700, 900);
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
