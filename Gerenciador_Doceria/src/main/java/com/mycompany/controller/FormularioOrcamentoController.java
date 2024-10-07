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
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
    private ComboBox<Integer> ComboBoxQtdOrcamento;

    @FXML
    private HBox HBoxProdOrcamento;

    @FXML
    private TextField TxtClienteOrcamento;

    @FXML
    private TextField TxtDescOrcamento;

    @FXML
    private TextField TxtProdOrcamento;

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
    private DatePicker dtDataOrcamento;

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
    List<ComboBox<Integer>> qtdProd = new ArrayList();
    List<ImageView> imgAdd = new ArrayList();
    List<ImageView> imgDelete = new ArrayList();

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
        ComboBox qtd = new ComboBox<Integer>();
        qtd.setItems(qtdsProds);
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

        lblValorTot.setText(valorTot);
        salvarPDF();
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
        double soma = (ComboBoxQtdOrcamento.getSelectionModel().getSelectedItem()) * (Double.parseDouble(TxtValUnitOrcamento.getText()));
        double valorProdAtual = 0;

        for (int i = 0; i < qtdProd.size(); i++) {

            quantidade = qtdProd.get(i).getSelectionModel().getSelectedItem();
            valorProdAtual = Double.parseDouble(valProd.get(i).getText());
            soma += (quantidade * valorProdAtual);
        }
        return soma;
    }

    public void gerarPDF() {

        try {

            //Instanciando nova fonte e transformando em formato valido
            String caminhoFonte = getClass().getResource("/fontes/Gilton-Bold.otf").getPath();
            BaseFont fonteNova = BaseFont.createFont(caminhoFonte, BaseFont.WINANSI, BaseFont.EMBEDDED);
            Font fonteTit = new Font(fonteNova, 28);

            //Criacao da tabela e celulas de titulo
            PdfPTable titulo = new PdfPTable(3);
            
            URL icone = getClass().getResource("/com/mycompany/icons/brigadeiro.png");
            com.lowagie.text.Image icon = com.lowagie.text.Image.getInstance(icone);
            icon.scaleAbsolute(30, 30);
            PdfPCell imgesq = new PdfPCell(icon);
            PdfPCell orc = new PdfPCell(new Phrase("  ORÇAMENTO  ", fonteTit));
            PdfPCell imgdir = new PdfPCell(icon);
            

            //alinhamento das celulas
            imgesq.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            imgesq.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            orc.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            orc.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            imgdir.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            imgdir.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);

            //removendo as bordas
            imgesq.setBorder(PdfPCell.NO_BORDER);
            imgdir.setBorder(PdfPCell.NO_BORDER);
            orc.setBorder(PdfPCell.NO_BORDER);

            //configuração da tabela
            titulo.setWidthPercentage(100);
            float[] larcol = {27f, 48f, 29f};
            titulo.setWidths(larcol);
            titulo.setSpacingAfter(30);
            titulo.setSpacingBefore(30);

            //adicionando as celulas na tabela e a tabela no documento
            titulo.addCell(imgesq);
            titulo.addCell(orc);
            titulo.addCell(imgdir);
            docPDF.add(titulo);

            //Criacao da tabela da dt entrega e suas celulas
            Font colunas = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font dados = new Font(Font.HELVETICA, 16);
            PdfPTable entrega = new PdfPTable(2);
            PdfPCell dtPedido = new PdfPCell(new Phrase("Data do orçamento: ", colunas));
            PdfPCell data = new PdfPCell(new Phrase("05/10/2024", dados));

            //alinhamento das celulas
            entrega.setHorizontalAlignment(Element.ALIGN_LEFT);
            data.setHorizontalAlignment(Element.ALIGN_CENTER);

            //removendo as bordas
            dtPedido.setBorder(PdfPCell.NO_BORDER);
            data.setBorder(PdfPCell.NO_BORDER);

            //configuração da tabela
            entrega.setWidthPercentage(60);
            entrega.setSpacingAfter(5);
            entrega.setSpacingBefore(30);
            float[] largcol = {17f, 14f};
            entrega.setWidths(largcol);
            dtPedido.setFixedHeight(22);

            //adicionando as celulas na tabela e a tabela no documento
            entrega.addCell(dtPedido);
            entrega.addCell(data);
            docPDF.add(entrega);

            //Linha divisoria
            Paragraph linhadiv = new Paragraph();
            linhadiv.add(new Chunk("______________________________________________________________________________"));
            docPDF.add(linhadiv);

            //criacao da tabela com dados dos clientes
            PdfPTable dadosCliente = new PdfPTable(2);
            PdfPCell cliente = new PdfPCell(new Phrase("Cliente: ", colunas));
            cliente.setFixedHeight(30);
            PdfPCell nomeCliente = new PdfPCell(new Phrase(TxtClienteOrcamento.getText(), dados));
            nomeCliente.setFixedHeight(30);
            PdfPCell endereco = new PdfPCell(new Phrase("Endereço: ", colunas));
            endereco.setFixedHeight(30);
            PdfPCell endCliente = new PdfPCell(new Phrase("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ", dados));
            endCliente.setFixedHeight(30);
            PdfPCell tel = new PdfPCell(new Phrase("Telefone: ", colunas));
            tel.setFixedHeight(30);
            PdfPCell telCliente = new PdfPCell(new Phrase(TxtTelOrcamento.getText(), dados));
            telCliente.setFixedHeight(30);

            //alinhamento das celulas
            dadosCliente.setHorizontalAlignment(Element.ALIGN_LEFT);

            //removendo as bordas
            cliente.setBorder(PdfPCell.NO_BORDER);
            nomeCliente.setBorder(PdfPCell.NO_BORDER);
            endereco.setBorder(PdfPCell.NO_BORDER);
            endCliente.setBorder(PdfPCell.NO_BORDER);
            tel.setBorder(PdfPCell.NO_BORDER);
            telCliente.setBorder(PdfPCell.NO_BORDER);

            //configuração da tabela
            dadosCliente.setWidthPercentage(100);
            float[] largcols = {17f, 83f};
            dadosCliente.setWidths(largcols);
            dadosCliente.setSpacingAfter(30);
            dadosCliente.setSpacingBefore(50);

            //adicionando as celulas na tabela e a tabela no documento
            dadosCliente.addCell(cliente);
            dadosCliente.addCell(nomeCliente);
            dadosCliente.addCell(endereco);
            dadosCliente.addCell(endCliente);
            dadosCliente.addCell(tel);
            dadosCliente.addCell(telCliente);
            docPDF.add(dadosCliente);

            //criação da tabela e celulas
            PdfPTable tabela = new PdfPTable(3);
            Font negrito = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font celulas = new Font(Font.HELVETICA, 16);
            PdfPCell col1 = new PdfPCell(new Phrase("PRODUTO", negrito));
            PdfPCell col2 = new PdfPCell(new Phrase("QUANTIDADE", negrito));
            PdfPCell col3 = new PdfPCell(new Phrase("VALOR UNITARIO", negrito));

            //alinhamento das celulas
            col1.setHorizontalAlignment(Element.ALIGN_CENTER);
            col2.setHorizontalAlignment(Element.ALIGN_CENTER);
            col3.setHorizontalAlignment(Element.ALIGN_CENTER);

            //definindo cor de fundo
            col1.setBackgroundColor(new java.awt.Color(255, 230, 250));
            col2.setBackgroundColor(new java.awt.Color(255, 230, 250));
            col3.setBackgroundColor(new java.awt.Color(255, 230, 250));

            //adicionando as celulas na tabela
            tabela.addCell(col1);
            tabela.addCell(col2);
            tabela.addCell(col3);

            for (int i = 0; i < qtdProd.size(); i++) {//for-each para percorrer a lista de produtos e copular a tabela     

                PdfPCell nomeprod = new PdfPCell(new Phrase(nomeProd.get(i).getText(), celulas));
                PdfPCell qtdprod = new PdfPCell(new Phrase(String.valueOf(qtdProd.get(i).getSelectionModel().getSelectedItem()), celulas));
                PdfPCell valprod = new PdfPCell(new Phrase(String.valueOf(valProd.get(i).getText()), celulas));

                //fixando altura das celulas
                nomeprod.setFixedHeight(22);
                qtdprod.setFixedHeight(22);
                valprod.setFixedHeight(22);

                //alinhamento das novas celulas
                nomeprod.setHorizontalAlignment(Element.ALIGN_CENTER);
                qtdprod.setHorizontalAlignment(Element.ALIGN_CENTER);
                valprod.setHorizontalAlignment(Element.ALIGN_CENTER);

                //adicionando as celulas criadas na tabela
                tabela.addCell(nomeprod);
                tabela.addCell(qtdprod);
                tabela.addCell(valprod);
            }

            //comfiguração da tabela
            tabela.setWidthPercentage(100);
            tabela.setSpacingAfter(10f);
            tabela.setSpacingBefore(10f);
            col1.setFixedHeight(26);
            col2.setFixedHeight(26);
            col3.setFixedHeight(26);

            //adicionando a tabela no documento
            docPDF.add(tabela);

            //criação da tabela e suas celulas
            PdfPTable tabelVal = new PdfPTable(3);
            PdfPCell vazio = new PdfPCell(new Phrase(" "));
            PdfPCell tot = new PdfPCell(new Phrase("TOTAL: ", negrito));
            PdfPCell valorTot = new PdfPCell(new Phrase(String.valueOf(lblValorTot.getText()), celulas));

            //definicao da cor de fundo
            tot.setBackgroundColor(new java.awt.Color(255, 230, 250));

            //configuracao das celulas
            valorTot.setFixedHeight(26);
            tot.setFixedHeight(26);
            tabelVal.setWidthPercentage(100);

            //alinhamento das celulas
            tot.setHorizontalAlignment(Element.ALIGN_CENTER);
            valorTot.setHorizontalAlignment(Element.ALIGN_CENTER);

            //removendo as bordas
            vazio.setBorder(PdfPCell.NO_BORDER);

            //adicionando as celulas na tabela e a tabela no documento
            tabelVal.addCell(vazio);
            tabelVal.addCell(tot);
            tabelVal.addCell(valorTot);
            docPDF.add(tabelVal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stage stageVBox() {

        Stage stage = (Stage) VBoxProduto.getScene().getWindow();

        return stage;
    }

    public void salvarPDF() {

        FileChooser salvar = new FileChooser();
        FileChooser.ExtensionFilter filtroArq = new FileChooser.ExtensionFilter("Arquivo PDF(*.pdf)", "*.pdf");
        salvar.getExtensionFilters().add(filtroArq);
        File file = salvar.showSaveDialog(stageVBox());

        if (file != null) {
            try {

                PdfWriter.getInstance(docPDF, new FileOutputStream(file));
                docPDF.open();
                gerarPDF();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (docPDF != null && docPDF.isOpen()) {

            docPDF.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblDesc.setVisible(false);
        TxtDescOrcamento.setVisible(false);

        btnRadioSim.setOnAction(event -> mostrarTxtDesc());
        btnRadioNao.setOnAction(event -> esconderTxtDesc());

        ComboBoxQtdOrcamento.setItems(qtdsProds);
        ComboBoxQtdOrcamento.setPromptText("0");

        boxes.add(HBoxProdOrcamento);
        nomeProd.add(TxtProdOrcamento);
        valProd.add(TxtValUnitOrcamento);
        qtdProd.add(ComboBoxQtdOrcamento);
        imgAdd.add(imgViewAdicionarProd);
        imgDelete.add(imgViewRemoverProd);

    }

}
