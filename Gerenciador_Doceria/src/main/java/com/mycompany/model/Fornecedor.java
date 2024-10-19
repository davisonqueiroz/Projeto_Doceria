
package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "fornecedor")
    private List<EmailFornecedor> emails = new ArrayList();
    
    @OneToMany(mappedBy = "fornecedor")
    private List<TelefoneFornecedor> telefones = new ArrayList();

    public Fornecedor() {
        
    }

    public Fornecedor(String nome_Fornecedor) {
        this.nome_Fornecedor = nome_Fornecedor;
    }
    
    

    public int getCod_Fornecedor() {
        return id_Fornecedor;
    }

    public void setCod_Fornecedor(int cod_Fornecedor) {
        this.id_Fornecedor = cod_Fornecedor;
    }

    public String getNome_Fornecedor() {
        return nome_Fornecedor;
    }

    public void setNome_Fornecedor(String nome_Fornecedor) {
        this.nome_Fornecedor = nome_Fornecedor;
    }

    public List<EmailFornecedor> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailFornecedor> emails) {
        this.emails = emails;
    }

    public List<TelefoneFornecedor> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneFornecedor> telefones) {
        this.telefones = telefones;
    }

   

   
   
}

