
package com.mycompany.model;

import Enums.Status_Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_Pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    private Status_Pedido status;
    
    @OneToOne
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;
    
    
    @ManyToMany
    @JoinTable(name = "item_Pedido",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_produto"))
    private List<Produto> produtos = new ArrayList();

    public Pedido() {
    }

    public Pedido(Cliente cliente, Status_Pedido status, Pagamento pagamento) {
        this.cliente = cliente;
        this.status = status;
        this.pagamento = pagamento;
    }

    public int getCod_Pedido() {
        return cod_Pedido;
    }

    public void setCod_Pedido(int cod_Pedido) {
        this.cod_Pedido = cod_Pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Status_Pedido getStatus() {
        return status;
    }

    public void setStatus(Status_Pedido status) {
        this.status = status;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
 
}
