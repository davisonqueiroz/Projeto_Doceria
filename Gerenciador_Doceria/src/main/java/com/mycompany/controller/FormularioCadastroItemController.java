
package com.mycompany.controller;

import Service.ItemService;
import com.mycompany.model.Item;
import com.mycompany.model.Lote;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FormularioCadastroItemController implements Initializable {

    @FXML
    private Button BtnLimparItem;

    @FXML
    private DatePicker DatePickerDataVenc;

    @FXML
    private TextField TextFieldMarca;

    @FXML
    private TextField TextFieldNomeItem;

    @FXML
    private TextField TextFieldPeso;

    @FXML
    private TextField TextFieldQtd;

    @FXML
    private TextField TextFieldValUnit;

    @FXML
    private Button btnSalvarItem;

    @FXML
    void salvarItem(MouseEvent event) {

        Item item = new Item();
        item.setNome_Item(TextFieldNomeItem.getText());
        item.setMarca(TextFieldMarca.getText());
        item.setQuantidade(Integer.parseInt(TextFieldQtd.getText()));
        item.setValor_unitario(Double.parseDouble(TextFieldValUnit.getText()));
        ItemService service = new ItemService();
        service.salvarItem(item, DatePickerDataVenc.getValue());
        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
