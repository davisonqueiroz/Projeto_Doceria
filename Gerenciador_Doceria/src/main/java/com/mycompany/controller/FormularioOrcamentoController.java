/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controller;

import com.lowagie.text.Chunk;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.mycompany.model.GeradorPDF;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FormularioOrcamentoController implements Initializable {

    @FXML
    private Button BtnLimparOrcamento;

    @FXML
    private TextField TextFieldQtdOrcamento;

    @FXML
    private HBox HBoxProdOrcamento;

    @FXML
    private TextField TxtClienteOrcamento;

    @FXML
    private TextField TxtDescOrcamento;

    @FXML
    private TextField TxtProdOrcamento;
    
    @FXML
    private Label LabelDataOrc;

    @FXML
    private TextField TxtTelOrcamento;

    @FXML
    private TextField TxtValUnitOrcamento;

    @FXML
    private RadioButton btnRadioNao;

    @FXML
    private RadioButton btnRadioSim;

    @FXML
    private Button btnSalvarOrcamento;

    @FXML
    private VBox VBoxProduto;

    @FXML
    private ToggleGroup Desconto;



    @FXML
    private ImageView imgViewAdicionarProd;

    @FXML
    private ImageView imgViewRemoverProd;

    @FXML
    private Label lblDesc;

    @FXML
    private Label lblValorTot;

    private int contador = 1;

    List<HBox> boxes = new ArrayList();
    List<TextField> nomeProd = new ArrayList();
    List<TextField> valProd = new ArrayList();
    List<TextField> qtdProd = new ArrayList();
    List<ImageView> imgAdd = new ArrayList();
    List<ImageView> imgDelete = new ArrayList();
    
    private LocalDate dtAtual = LocalDate.now();
    private DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String dtFormatada = dtAtual.format(formatacao);
    

    Document docPDF = new Document();

    ObservableList<Integer> qtdsProds = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @FXML
    void adicionarProduto(MouseEvent event) {

        gerarHBoxProduto(VBoxProduto);

    }

    @FXML
    void removerProduto(MouseEvent event) {

    }

    public void gerarHBoxProduto(VBox vbox) {

        imgViewAdicionarProd.setVisible(false);
        imgViewRemoverProd.setVisible(false);

        HBox hboxProd = new HBox();
        boxes.add(hboxProd);
        Label prod = new Label("Produto: ");
        TextField nvProd = new TextField();
        nomeProd.add(nvProd);
        Label quant = new Label("Quantidade: ");
        TextField qtd = new TextField();
        qtd.setPromptText("0");
        qtdProd.add(qtd);
        Label valor = new Label("Valor Unit.: ");
        TextField nvValor = new TextField();
        valProd.add(nvValor);
        Image addIcon = new Image("/com/mycompany/icons/add.png");
        Image delIcon = new Image("/com/mycompany/icons/delete circle.png");
        ImageView addHBox = new ImageView(addIcon);
        imgAdd.add(addHBox);

        ImageView removeHBox = new ImageView(delIcon);
        imgDelete.add(removeHBox);

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

            gerarHBoxProduto(VBoxProduto);

        });

        removeHBox.setOnMouseClicked(event -> {

            VBoxProduto.getChildren().remove(hboxProd);
            boxes.remove(hboxProd);
            nomeProd.remove(nvProd);
            qtdProd.remove(qtd);
            valProd.remove(nvValor);
            imgAdd.remove(addHBox);
            imgDelete.remove(removeHBox);
            System.out.println("tamanho apos remover " + imgDelete.size());
            System.out.println("tamanho apos remover " + imgAdd.size());
            int tam = imgAdd.size();
            if (tam == 0) {

                imgViewAdicionarProd.setVisible(true);
                imgViewRemoverProd.setVisible(true);

            } else {

                imgAdd.get(tam - 1).setVisible(true);
                imgDelete.get(tam - 1).setVisible(true);

            }

        });

        hboxProd.getChildren().addAll(prod, nvProd, quant, qtd, valor, nvValor, addHBox, removeHBox);
        VBoxProduto.getChildren().add(hboxProd);

        if (imgAdd.size() > 1) {
            imgAdd.get(imgAdd.size() - 2).setVisible(false);
            imgDelete.get(imgDelete.size() - 2).setVisible(false);
        }

        System.out.println(imgDelete.size());
        System.out.println(imgAdd.size());

    }

    @FXML
    void salvarOrcamento(MouseEvent event) {

        String valorTot = Double.toString(somarTotal());

        Stage stage = (Stage) VBoxProduto.getScene().getWindow();

        lblValorTot.setText(valorTot);
        GeradorPDF orcamento = new GeradorPDF();
        orcamento.salvarPDF(TxtClienteOrcamento, TxtTelOrcamento, nomeProd, qtdProd, valProd, lblValorTot, stage);
    }

    public void mostrarTxtDesc() {

        lblDesc.setVisible(true);
        TxtDescOrcamento.setVisible(true);
    }

    public void esconderTxtDesc() {
        lblDesc.setVisible(false);
        TxtDescOrcamento.setVisible(false);
    }

    public double somarTotal() {

        int quantidade = 0;
        double soma = 0;
        double valorProdAtual = 0;

        for (int i = 0; i < qtdProd.size(); i++) {

            quantidade = Integer.parseInt(qtdProd.get(i).getText());
            valorProdAtual = Double.parseDouble(valProd.get(i).getText());
            soma += (quantidade * valorProdAtual);
        }
        return soma;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblDesc.setVisible(false);
        TxtDescOrcamento.setVisible(false);

        btnRadioSim.setOnAction(event -> mostrarTxtDesc());
        btnRadioNao.setOnAction(event -> esconderTxtDesc());


        boxes.add(HBoxProdOrcamento);
        nomeProd.add(TxtProdOrcamento);
        valProd.add(TxtValUnitOrcamento);
        qtdProd.add(TextFieldQtdOrcamento);
        imgAdd.add(imgViewAdicionarProd);
        imgDelete.add(imgViewRemoverProd);
        
        LabelDataOrc.setText(dtFormatada);
        



    }

}
