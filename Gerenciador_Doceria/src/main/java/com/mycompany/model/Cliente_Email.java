
package com.mycompany.model;


public class Cliente_Email {
    
    private Cliente id_Cliente;
    private Email id_Email;

    public Cliente_Email(Cliente id_Cliente, Email id_Email) {
        this.id_Cliente = id_Cliente;
        this.id_Email = id_Email;
    }

    public Cliente getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Cliente id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public Email getId_Email() {
        return id_Email;
    }

    public void setId_Email(Email id_Email) {
        this.id_Email = id_Email;
    }
    
    
}
