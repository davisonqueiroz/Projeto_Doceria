
package com.mycompany.model;

import Enums.Forma_De_Pagamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private int id_Pagamento;
    
    @Column(name = "valorTot_pgt",precision = 10, scale = 2)
    private BigDecimal valor_Total;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    private Forma_De_Pagamento forma_Pagamento;
    
    private boolean parcelar;
    
    @Column(name = "qtd_parcelas",nullable = true)
    private int qtd_Parcelas;
   
    @OneToOne(mappedBy = "pagamento")
    private Pedido pedido;
    
    
    private int desconto;

    public Pagamento() {
        
    }

    public Pagamento(BigDecimal valor_Total, Forma_De_Pagamento forma_Pagamento, Pedido pedido) {
        this.valor_Total = valor_Total;
        this.forma_Pagamento = forma_Pagamento;
        this.pedido = pedido;
    }

    public Pagamento(BigDecimal valor_Total, Forma_De_Pagamento forma_Pagamento, Pedido pedido, int desconto) {
        this.valor_Total = valor_Total;
        this.forma_Pagamento = forma_Pagamento;
        this.pedido = pedido;
        this.desconto = desconto;
    }
    
    

    public Pagamento(BigDecimal valor_Total, Forma_De_Pagamento forma_Pagamento, boolean parcelar, int qtd_Parcelas, Pedido pedido, int desconto) {
        this.valor_Total = valor_Total;
        this.forma_Pagamento = forma_Pagamento;
        this.parcelar = parcelar;
        this.qtd_Parcelas = qtd_Parcelas;
        this.pedido = pedido;
        this.desconto = desconto;
    }

    public int getId_Pagamento() {
        return id_Pagamento;
    }

    public void setId_Pagamento(int id_Pagamento) {
        this.id_Pagamento = id_Pagamento;
    }

    public BigDecimal getValor_Total() {
        return valor_Total;
    }

    public void setValor_Total(BigDecimal valor_Total) {
        this.valor_Total = valor_Total;
    }

    public Forma_De_Pagamento getForma_Pagamento() {
        return forma_Pagamento;
    }

    public void setForma_Pagamento(Forma_De_Pagamento forma_Pagamento) {
        this.forma_Pagamento = forma_Pagamento;
    }

    public boolean isParcelar() {
        return parcelar;
    }

    public void setParcelar(boolean parcelar) {
        this.parcelar = parcelar;
    }

    public int getQtd_Parcelas() {
        return qtd_Parcelas;
    }

    public void setQtd_Parcelas(int qtd_Parcelas) {
        this.qtd_Parcelas = qtd_Parcelas;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }


}
