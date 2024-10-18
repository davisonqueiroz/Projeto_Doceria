
package com.mycompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_Item;
    private String nome_Item;
    private String marca;
    
    @ManyToMany(mappedBy = "itens")
    List<Produto> produtos = new ArrayList();
    
    @ManyToOne
    @JoinColumn(name = "id_lote" )
    private Lote lote;
    private int quantidade;
    private double valor_unitario;

    public Item() {
    }

    public Item(String nome_Item, String marca, Lote lote, int quantidade, double valor_unitario) {
        this.nome_Item = nome_Item;
        this.marca = marca;
        this.lote = lote;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
    }

    public int getCod_Item() {
        return cod_Item;
    }

    public void setCod_Item(int cod_Item) {
        this.cod_Item = cod_Item;
    }

    public String getNome_Item() {
        return nome_Item;
    }

    public void setNome_Item(String nome_Item) {
        this.nome_Item = nome_Item;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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
    
    

  
}
