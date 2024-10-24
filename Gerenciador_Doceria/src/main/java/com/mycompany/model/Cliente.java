
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
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id_Cliente;
    @Column(name = "nome_cliente")
    private String nome;
    
    @OneToMany(mappedBy = "cliente")
    private List<EmailCliente> emails = new ArrayList();
    
    @OneToMany(mappedBy = "cliente")
    private List<TelefoneCliente> telefones = new ArrayList();
    
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList();
    
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Cliente() {
        
    }

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    

    public int getCod_Cliente() {
        return id_Cliente;
    }

    public void setCod_Cliente(int cod_Cliente) {
        this.id_Cliente = cod_Cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<EmailCliente> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailCliente> emails) {
        this.emails = emails;
    }

    public List<TelefoneCliente> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneCliente> telefones) {
        this.telefones = telefones;
    }

    

}
