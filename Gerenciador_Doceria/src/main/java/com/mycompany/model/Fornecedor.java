
package com.mycompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  cod_Fornecedor;
    private String nome_Fornecedor;
    
    @ManyToMany
    @JoinTable(name = "fornecedor_item",
            joinColumns = @JoinColumn(name = "id_fornecedor"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
    private List<Item> itens = new ArrayList();
    
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
        return cod_Fornecedor;
    }

    public void setCod_Fornecedor(int cod_Fornecedor) {
        this.cod_Fornecedor = cod_Fornecedor;
    }

    public String getNome_Fornecedor() {
        return nome_Fornecedor;
    }

    public void setNome_Fornecedor(String nome_Fornecedor) {
        this.nome_Fornecedor = nome_Fornecedor;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
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

