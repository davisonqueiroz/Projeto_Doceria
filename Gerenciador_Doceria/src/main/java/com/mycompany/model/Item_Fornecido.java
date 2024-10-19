
package com.mycompany.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_fornecido")
public class Item_Fornecido {
    
    @EmbeddedId
    private FornecedorItemId id;
    
    @ManyToOne
    @MapsId("fornecedorId")
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
    
    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "id_item")
    private Item item;
    
    @Column(name = "valor_forn")
    private double valor;

    public Item_Fornecido() {
        
    }

    public Item_Fornecido(FornecedorItemId id, Fornecedor fornecedor, Item item, double valor) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.item = item;
        this.valor = valor;
    }

    public FornecedorItemId getId() {
        return id;
    }

    public void setId(FornecedorItemId id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
