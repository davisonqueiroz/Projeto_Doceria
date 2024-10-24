/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controller;

import DAO.ClienteDAO;
import com.mycompany.model.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaCadastroClienteController implements Initializable {

    @FXML
    private Button BtnSalvar;

    @FXML
    private TextField TextFieldNomeCliente;

    @FXML
    void salvarCliente(MouseEvent event) {

        Cliente c = new Cliente();
        String nome = TextFieldNomeCliente.getText();
        c.setNome(nome);
        if (c.getNome() != null) {

            ClienteDAO dao = new ClienteDAO();
            dao.save(c);

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
