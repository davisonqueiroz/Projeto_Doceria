package com.mycompany.model;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GeradorPDF {

    private Document docPDF;

    public GeradorPDF() {

        this.docPDF = new Document();

    }

    public void cabeçalho() {

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
            this.docPDF.add(titulo);

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
            this.docPDF.add(linhadiv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dadosCliente(TextField txtCliente, TextField telefone) {

        try {

            Font colunas = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font dados = new Font(Font.HELVETICA, 16);
            //criacao da tabela com dados dos clientes
            PdfPTable dadosCliente = new PdfPTable(2);
            PdfPCell cliente = new PdfPCell(new Phrase("Cliente: ", colunas));
            cliente.setFixedHeight(30);
            PdfPCell nomeCliente = new PdfPCell(new Phrase(txtCliente.getText(), dados));
            nomeCliente.setFixedHeight(30);
            PdfPCell endereco = new PdfPCell(new Phrase("Endereço: ", colunas));
            endereco.setFixedHeight(30);
            PdfPCell endCliente = new PdfPCell(new Phrase("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ", dados));
            endCliente.setFixedHeight(30);
            PdfPCell tel = new PdfPCell(new Phrase("Telefone: ", colunas));
            tel.setFixedHeight(30);
            PdfPCell telCliente = new PdfPCell(new Phrase(telefone.getText(), dados));
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
            this.docPDF.add(dadosCliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void tabelaProdutos(List<TextField> nomeProd, List<ComboBox<Integer>> qtdProd, List<TextField> valProd, Label lblValorTot) {

        try {

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
            this.docPDF.add(tabela);

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
            this.docPDF.add(tabelVal);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void salvarPDF(TextField txtCliente, TextField telefone, List<TextField> nomeProd, List<ComboBox<Integer>> qtdProd,
            List<TextField> valProd, Label lblValorTot, Stage stage) {

        FileChooser salvar = new FileChooser();
        FileChooser.ExtensionFilter filtroArq = new FileChooser.ExtensionFilter("Arquivo PDF(*.pdf)", "*.pdf");
        salvar.getExtensionFilters().add(filtroArq);
        File file = salvar.showSaveDialog(stage);

        if (file != null) {
            try {

                PdfWriter.getInstance(this.docPDF, new FileOutputStream(file));
                this.docPDF.open();

            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }

        if (this.docPDF != null && this.docPDF.isOpen()) {

            try {

                cabeçalho();
                dadosCliente(txtCliente, telefone);
                tabelaProdutos(nomeProd, qtdProd, valProd, lblValorTot);

            } catch (Exception e) {
                
                e.printStackTrace();
            } finally {
                
                this.docPDF.close();
                
            }

            
        }

    }

}
