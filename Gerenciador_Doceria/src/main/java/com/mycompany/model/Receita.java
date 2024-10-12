
package com.mycompany.model;


public class Receita {
    
    private Item cod_Item;
    private Produto cod_Produto;
    private int quantiade_Item;

    public Receita(Item cod_Item, Produto cod_Produto, int quantiade_Item) {
        this.cod_Item = cod_Item;
        this.cod_Produto = cod_Produto;
        this.quantiade_Item = quantiade_Item;
    }

    public Item getCod_Item() {
        return cod_Item;
    }

    public void setCod_Item(Item cod_Item) {
        this.cod_Item = cod_Item;
    }

    public Produto getCod_Produto() {
        return cod_Produto;
    }

    public void setCod_Produto(Produto cod_Produto) {
        this.cod_Produto = cod_Produto;
    }

    public int getQuantiade_Item() {
        return quantiade_Item;
    }

    public void setQuantiade_Item(int quantiade_Item) {
        this.quantiade_Item = quantiade_Item;
    }
    
    
}
