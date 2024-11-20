
package com.mycompany.controller;

import Enums.Medida;
import Service.ItemService;
import com.mycompany.model.Descricao;
import com.mycompany.model.Item;
import com.mycompany.model.Lote;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FormularioCadastroItemController implements Initializable {

      @FXML
    private Button BtnLimparItem;

    @FXML
    private DatePicker DatePickerDataVenc;

    @FXML
    private Button btnSalvarItem;

    @FXML
    private TextField txtFieldMarca;

    @FXML
    private TextField txtFieldNomeItem;

    @FXML
    private TextField txtFieldPesoUnit;

    @FXML
    private TextField txtFieldQtd;

    @FXML
    private TextField txtFieldValUnit;
    
    @FXML
    private ChoiceBox<Medida> choiceBoxMedida;

    private Medida medidas[] = {Medida.ml,Medida.Litro,Medida.gramas,Medida.kg};

    @FXML
    void salvarItem(MouseEvent event) {

        Item item = new Item();
        item.setMarca(txtFieldMarca.getText());
        item.setQuantidade(Integer.parseInt(txtFieldQtd.getText()));
        String valor = txtFieldValUnit.getText();
        BigDecimal valorDecimal = new BigDecimal(valor);
        item.setValor_unitario(valorDecimal);
        Descricao descricao = new Descricao();
        descricao.setMedida(choiceBoxMedida.getSelectionModel().getSelectedItem());
        descricao.setPeso(Integer.parseInt(txtFieldPesoUnit.getText()));
        descricao.setNome_Item((txtFieldNomeItem.getText()).trim().toLowerCase());
        ItemService itemSalvar = new ItemService();
        itemSalvar.salvarItem(item, DatePickerDataVenc.getValue(), descricao);
        
        txtFieldMarca.setText("");
        txtFieldNomeItem.setText("");
        txtFieldPesoUnit.setText("");
        txtFieldQtd.setText("");
        txtFieldValUnit.setText("");
        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        choiceBoxMedida.getItems().addAll(medidas);
    }    
    
}
