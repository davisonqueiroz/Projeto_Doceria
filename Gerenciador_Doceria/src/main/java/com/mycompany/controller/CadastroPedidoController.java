/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CadastroPedidoController implements Initializable {

    @FXML
    private ComboBox<?> ComboBoxQtdPedido;

    @FXML
    private HBox HBoxProdPedidos;

    @FXML
    private ImageView imgViewAdicionarProduto;

    @FXML
    private ImageView imgViewExcluirProduto;

    @FXML
    private Button btnLimparPedidos;

    @FXML
    private Button btnSalvarPedidos;

    @FXML
    private DatePicker dtDataEntrega;

    @FXML
    private DatePicker dtDataPedido;

    @FXML
    private Label lblValorTot;

    @FXML
    private RadioButton rBtnCredito;

    @FXML
    private RadioButton rBtnDebito;

    @FXML
    private RadioButton rBtnDinheiro;

    @FXML
    private RadioButton rBtnNDesc;

    @FXML
    private RadioButton rBtnPix;

    @FXML
    private RadioButton rBtnSDesc;

    @FXML
    private TextField txtClientePedido;

    @FXML
    private TextField txtDescontoPedido;

    @FXML
    private TextField txtEntradaPedido;

    @FXML
    private TextField txtProdutoPedido;

    @FXML
    private TextField txtRestantePedido;

    @FXML
    private TextField txtTelPedido;

    @FXML
    private TextField txtValUnitPedido;

    @FXML
    private VBox VBoxProdutos;

    @FXML
    private HBox HBoxDesc;

    @FXML
    private ToggleGroup desconto;

    private int contador = 1;

    @FXML
    void adicionarProduto(MouseEvent event) {

        gerarHBoxProduto(VBoxProdutos);
    }

    @FXML
    void removerProduto(MouseEvent event) {

    }

    public void gerarHBoxProduto(VBox vbox) {

        HBox hboxProd = new HBox();
        Label prod = new Label("Produto: ");
        TextField nvProd = new TextField();
        Label quant = new Label("Quantidade: ");
        ComboBox qtd = new ComboBox();
        Label valor = new Label("Valor Unit.: ");
        TextField nvValor = new TextField();

        Image addIcon = new Image("/com/mycompany/icons/add.png");
        Image delIcon = new Image("/com/mycompany/icons/delete circle.png");
        ImageView addHBox = new ImageView(addIcon);
        ImageView removeHBox = new ImageView(delIcon);

        hboxProd.setId("HBoxProdPedidos" + contador);
        nvProd.setId("txtProdutoPedido" + contador);
        qtd.setId("ComboBoxQtdPedido" + contador);
        nvValor.setId("txtValUnitPedido" + contador);

        hboxProd.setPrefWidth(670);
        hboxProd.setPrefHeight(45);
        nvProd.setPrefWidth(141);
        nvProd.setPrefHeight(25);
        qtd.setPrefWidth(85);
        qtd.setPrefHeight(25);
        nvValor.setPrefWidth(79);
        nvValor.setPrefHeight(25);
        addHBox.setFitWidth(28);
        addHBox.setFitHeight(28);
        removeHBox.setFitWidth(28);
        removeHBox.setFitHeight(28);

        hboxProd.setMargin(prod, new Insets(3, 10, 0, 15));
        hboxProd.setMargin(quant, new Insets(3, 10, 0, 25));
        hboxProd.setMargin(valor, new Insets(3, 10, 0, 25));
        hboxProd.setMargin(addHBox, new Insets(0, 0, 0, 10));
        hboxProd.setMargin(removeHBox, new Insets(0, 0, 0, 15));

        addHBox.setOnMouseClicked(event -> {

            gerarHBoxProduto(VBoxProdutos);
        });

        removeHBox.setOnMouseClicked(event -> {

            VBoxProdutos.getChildren().remove(hboxProd);

        });

        contador++;

        hboxProd.getChildren().addAll(prod, nvProd, quant, qtd, valor, nvValor, addHBox, removeHBox);
        VBoxProdutos.getChildren().add(hboxProd);

    }

    public void mostrarTxtDesc() {

        HBoxDesc.setVisible(true);
    }

    public void esconderTxtDesc() {
        HBoxDesc.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rBtnSDesc.setOnAction(event -> mostrarTxtDesc());
        rBtnNDesc.setOnAction(event -> esconderTxtDesc());
    }

}
