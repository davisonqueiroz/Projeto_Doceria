
package com.mycompany.model;


public class Fornecedor_Telefone {
    
    private Fornecedor id_Fornecedor;
    private Telefone id_Telefone;

    public Fornecedor_Telefone(Fornecedor id_Fornecedor, Telefone id_Telefone) {
        this.id_Fornecedor = id_Fornecedor;
        this.id_Telefone = id_Telefone;
    }

    public Fornecedor getId_Fornecedor() {
        return id_Fornecedor;
    }

    public void setId_Fornecedor(Fornecedor id_Fornecedor) {
        this.id_Fornecedor = id_Fornecedor;
    }

    public Telefone getId_Telefone() {
        return id_Telefone;
    }

    public void setId_Telefone(Telefone id_Telefone) {
        this.id_Telefone = id_Telefone;
    }
    
    
}
