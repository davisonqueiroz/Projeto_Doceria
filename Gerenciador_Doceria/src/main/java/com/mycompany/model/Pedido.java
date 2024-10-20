
package com.mycompany.model;

import Enums.Status_Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int id_Pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status_pedido")
    private Status_Pedido status;
    
    @OneToOne
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;
    
    @OneToMany(mappedBy = "pedido")
    private List<Item_Pedido> itensPedido = new ArrayList();
    
    @Column(nullable = true)
    private LocalDate data_entrega;
    

    public Pedido() {
        
    }

    public Pedido(Cliente cliente, Status_Pedido status, Pagamento pagamento, LocalDate data_entrega) {
        this.cliente = cliente;
        this.status = status;
        this.pagamento = pagamento;
        this.data_entrega = data_entrega;
    }

    

    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
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

    public List<Item_Pedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<Item_Pedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public LocalDate getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(LocalDate data_entrega) {
        this.data_entrega = data_entrega;
    }

 
 
}
