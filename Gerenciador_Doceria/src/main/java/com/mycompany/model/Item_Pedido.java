
package com.mycompany.model;


public class Item_Pedido {
    
    private Pedido cod_Pedido;
    private Produto cod_Produto;
    private int quantidade;

    public Item_Pedido(Pedido cod_Pedido, Produto cod_Produto, int quantidade) {
        this.cod_Pedido = cod_Pedido;
        this.cod_Produto = cod_Produto;
        this.quantidade = quantidade;
    }

    public Pedido getCod_Pedido() {
        return cod_Pedido;
    }

    public void setCod_Pedido(Pedido cod_Pedido) {
        this.cod_Pedido = cod_Pedido;
    }

    public Produto getCod_Produto() {
        return cod_Produto;
    }

    public void setCod_Produto(Produto cod_Produto) {
        this.cod_Produto = cod_Produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
