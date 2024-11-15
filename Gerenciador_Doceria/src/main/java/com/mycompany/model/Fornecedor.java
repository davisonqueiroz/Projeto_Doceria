
package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private int  id_Fornecedor;
    
    @Column(name = "nome_forn")
    private String nome_Fornecedor;
    
    @OneToOne
    @JoinColumn(name = "id_telefone")
    private Telefone telefone;
    


    public Fornecedor() {
        
    }

    public Fornecedor(String nome_Fornecedor, Telefone telefone) {
        this.nome_Fornecedor = nome_Fornecedor;
        this.telefone = telefone;
    }

    public int getId_Fornecedor() {
        return id_Fornecedor;
    }

    public void setId_Fornecedor(int id_Fornecedor) {
        this.id_Fornecedor = id_Fornecedor;
    }

    public String getNome_Fornecedor() {
        return nome_Fornecedor;
    }

    public void setNome_Fornecedor(String nome_Fornecedor) {
        this.nome_Fornecedor = nome_Fornecedor;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    
    


}

