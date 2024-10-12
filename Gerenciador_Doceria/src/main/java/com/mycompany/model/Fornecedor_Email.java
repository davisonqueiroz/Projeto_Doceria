
package com.mycompany.model;


public class Fornecedor_Email {
    
    private Fornecedor id_Fornecedor;
    private Email id_Email;

    public Fornecedor_Email(Fornecedor id_Fornecedor, Email id_Email) {
        this.id_Fornecedor = id_Fornecedor;
        this.id_Email = id_Email;
    }

    public Fornecedor getId_Fornecedor() {
        return id_Fornecedor;
    }

    public void setId_Fornecedor(Fornecedor id_Fornecedor) {
        this.id_Fornecedor = id_Fornecedor;
    }

    public Email getId_Email() {
        return id_Email;
    }

    public void setId_Email(Email id_Email) {
        this.id_Email = id_Email;
    }
    
    
}
