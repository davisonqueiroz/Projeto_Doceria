
package com.mycompany.model;

import Enums.Tipo_Contato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "telefone")
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private int id_Telefone;
    
    @Column(name = "tipo_contato")
    private Tipo_Contato tipo_Contato;
    
    @Column(name = "num_telefone")
    private String numero_Telefone;

    public Telefone() {
    }

    public Telefone(Tipo_Contato tipo_Contato, String numero_Telefone) {
        this.tipo_Contato = tipo_Contato;
        this.numero_Telefone = numero_Telefone;
    }

    public int getId_Telefone() {
        return id_Telefone;
    }

    public void setId_Telefone(int id_Telefone) {
        this.id_Telefone = id_Telefone;
    }

    public Tipo_Contato getTipo_Contato() {
        return tipo_Contato;
    }

    public void setTipo_Contato(Tipo_Contato tipo_Contato) {
        this.tipo_Contato = tipo_Contato;
    }

    public String getNumero_Telefone() {
        return numero_Telefone;
    }

    public void setNumero_Telefone(String numero_Telefone) {
        this.numero_Telefone = numero_Telefone;
    }
    
    
    
}
