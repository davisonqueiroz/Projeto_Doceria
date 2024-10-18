
package com.mycompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmailCliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_Email;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public EmailCliente() {
    }

    public EmailCliente(String email, Cliente cliente) {
        this.email = email;
        this.cliente = cliente;
    }

    public int getCod_Email() {
        return cod_Email;
    }

    public void setCod_Email(int cod_Email) {
        this.cod_Email = cod_Email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
