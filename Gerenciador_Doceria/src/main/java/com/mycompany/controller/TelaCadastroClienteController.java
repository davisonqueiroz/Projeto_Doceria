/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controller;

import DAO.ClienteDAO;
import Enums.Sexo;
import Enums.Tipo_Contato;
import Service.ClienteService;
import com.mycompany.model.Cliente;
import com.mycompany.model.Telefone;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaCadastroClienteController implements Initializable {

    
    @FXML
    private Button BtnSalvarCli;

    @FXML
    private Button btnLimparCli;

    @FXML
    private ChoiceBox<Sexo> choiceBoxSexo;

    @FXML
    private ChoiceBox<Tipo_Contato> choiceBoxTipoContato;

    @FXML
    private TextField txtFieldDDDCli;

    @FXML
    private TextField txtFieldNomeCliente;

    @FXML
    private TextField txtFieldTelefoneCli;

    @FXML
    void salvarCliente(MouseEvent event) {

        Cliente cliente = new Cliente();
        Telefone telefone = new Telefone();
        cliente.setNome(txtFieldNomeCliente.getText());
        cliente.setSexo(choiceBoxSexo.getSelectionModel().getSelectedItem());
        telefone.setNumero_Telefone(txtFieldDDDCli.getText() +txtFieldTelefoneCli.getText() );
        telefone.setTipo_Contato(choiceBoxTipoContato.getSelectionModel().getSelectedItem());
        cliente.setTelefone(telefone);
        ClienteService cliService = new ClienteService();
        cliService.salvarCliente(cliente, telefone);
    }
    
    private Sexo sexo[] = {Sexo.Feminino,Sexo.Masculino};
    private Tipo_Contato tipoCont[] = {Tipo_Contato.CELULAR,Tipo_Contato.RESIDENCIAL};

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        choiceBoxSexo.getItems().addAll(sexo);
        choiceBoxTipoContato.getItems().addAll(tipoCont);
    }

}
