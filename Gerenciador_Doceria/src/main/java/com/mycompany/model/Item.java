
package com.mycompany.model;

public class Item {
    
    private int cod_Item;
    private String nome_Item;
    private String marca;
    private Lote cod_Lote;
    private int quantidade;
    private double valor_unitario;

    public Item(String nome_Item, String marca, Lote cod_Lote, int quantidade, double valor_unitario) {
        this.nome_Item = nome_Item;
        this.marca = marca;
        this.cod_Lote = cod_Lote;
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

    public Lote getCod_Lote() {
        return cod_Lote;
    }

    public void setCod_Lote(Lote cod_Lote) {
        this.cod_Lote = cod_Lote;
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
