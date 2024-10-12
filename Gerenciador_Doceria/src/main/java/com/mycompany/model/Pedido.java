
package com.mycompany.model;

import Enums.Status_Pedido;


public class Pedido {
    
    private int cod_Pedido;
    private Cliente cod_Cliente;
    private Status_Pedido status;
    private Pagamento cod_Pagamento;

    public Pedido(Cliente cod_Cliente, Status_Pedido status, Pagamento cod_Pagamento) {
        this.cod_Cliente = cod_Cliente;
        this.status = status;
        this.cod_Pagamento = cod_Pagamento;
    }

    public int getCod_Pedido() {
        return cod_Pedido;
    }

    public void setCod_Pedido(int cod_Pedido) {
        this.cod_Pedido = cod_Pedido;
    }

    public Cliente getCod_Cliente() {
        return cod_Cliente;
    }

    public void setCod_Cliente(Cliente cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }

    public Status_Pedido getStatus() {
        return status;
    }

    public void setStatus(Status_Pedido status) {
        this.status = status;
    }

    public Pagamento getCod_Pagamento() {
        return cod_Pagamento;
    }

    public void setCod_Pagamento(Pagamento cod_Pagamento) {
        this.cod_Pagamento = cod_Pagamento;
    }

   
}
