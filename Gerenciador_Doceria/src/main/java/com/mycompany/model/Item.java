
package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "item")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int id_Item;
    private String nome_Item;
    
    @ManyToOne
    @JoinColumn(name = "id_descricao")
    private Descricao descricao;
    
    
    private String marca;

    
    @ManyToOne
    @JoinColumn(name = "id_lote" )
    private Lote lote;
    
    @Column(name = "qtd_item")
    private int quantidade;
    
    @Column(name = "valor_unit_item")
    private double valor_unitario;
    
    @OneToMany(mappedBy = "item")
    private List<Receita> receitas = new ArrayList();
    
    @OneToMany(mappedBy = "item")
    private List<Item_Fornecido> itens_Fornecidos =  new ArrayList();
    
    private int uso_Temporario;
    
    public Item() {
        
    }

    public Item(String nome_Item, Descricao descricao, String marca, Lote lote, int quantidade, double valor_unitario) {
        this.nome_Item = nome_Item;
        this.descricao = descricao;
        this.marca = marca;
        this.lote = lote;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;

    }

    public int getId_Item() {
        return id_Item;
    }

    public void setId_Item(int id_Item) {
        this.id_Item = id_Item;
    }

    public String getNome_Item() {
        return nome_Item;
    }

    public void setNome_Item(String nome_Item) {
        this.nome_Item = nome_Item;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public List<Item_Fornecido> getItens_Fornecidos() {
        return itens_Fornecidos;
    }

    public void setItens_Fornecidos(List<Item_Fornecido> itens_Fornecidos) {
        this.itens_Fornecidos = itens_Fornecidos;
    }

    public int getUso_Temporario() {
        return uso_Temporario;
    }

    public void setUso_Temporario(int uso_Temporario) {
        this.uso_Temporario = uso_Temporario;
    }

   
}
