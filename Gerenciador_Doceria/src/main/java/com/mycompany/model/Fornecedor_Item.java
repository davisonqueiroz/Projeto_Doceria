
package com.mycompany.model;


public class Fornecedor_Item {
    
    private Fornecedor cod_fornecedor;
    private Item cod_Item;

    public Fornecedor_Item(Fornecedor cod_fornecedor, Item cod_Item) {
        this.cod_fornecedor = cod_fornecedor;
        this.cod_Item = cod_Item;
    }

    public Fornecedor getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(Fornecedor cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public Item getCod_Item() {
        return cod_Item;
    }

    public void setCod_Item(Item cod_Item) {
        this.cod_Item = cod_Item;
    }
    
    
}
