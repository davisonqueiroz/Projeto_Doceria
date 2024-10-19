package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;


@Entity
@Table(name = "receita")
public class Receita {

    @EmbeddedId
    private ItemProdutoId id;
   
    
    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "idItem")
    private Item item;
    
    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "idProduto")
    private Produto produto;
  
    @Column(name = "qtdProd_receita")
    private int qtdProd;

    public Receita() {
        
    }

    public Receita(ItemProdutoId id, Item item, Produto produto, int qtdProd) {
        this.id = id;
        this.item = item;
        this.produto = produto;
        this.qtdProd = qtdProd;
    }

    public ItemProdutoId getId() {
        return id;
    }

    public void setId(ItemProdutoId id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }
    
    

}
