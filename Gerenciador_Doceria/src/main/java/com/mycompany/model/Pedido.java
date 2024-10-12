
package com.mycompany.model;


public class Pedido {
    
    private int cod_Pedido;
    private Cliente cod_Cliente;
    private String status;
    private Pagamento cod_Pagamento;

    public Pedido(Cliente cod_Cliente, String status, Pagamento cod_Pagamento) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pagamento getCod_Pagamento() {
        return cod_Pagamento;
    }

    public void setCod_Pagamento(Pagamento cod_Pagamento) {
        this.cod_Pagamento = cod_Pagamento;
    }

    
    
}
