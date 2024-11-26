
package com.mycompany.controller;

import Enums.Tipo_Contato;
import com.mycompany.model.Item;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class TelaCadastroFornecedorController implements Initializable {

      @FXML
    private Button btnLimparForn;

    @FXML
    private Button btnSalvarForn;

    @FXML
    private ChoiceBox<Item> choiceBoxIngredientes;

    @FXML
    private ChoiceBox<Tipo_Contato> choiceBoxTipoContatoForn;

    @FXML
    private TextField txtFieldDDDForn;

    @FXML
    private TextField txtFieldNomeFornecedor;

    @FXML
    private TextField txtFieldTelForn;

    @FXML
    void salvarForn(MouseEvent event) {

        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
