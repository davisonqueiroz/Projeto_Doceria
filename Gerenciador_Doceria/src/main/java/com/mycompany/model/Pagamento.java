
package com.mycompany.model;

import Enums.Forma_De_Pagamento;

public class Pagamento {
    
    private int cod_Pagamento;
    private double valor_Total;
    private Forma_De_Pagamento forma_Pagamento;
    private boolean parcelar;
    private int qtd_Parcelas;

    public Pagamento(double valor_Total, Forma_De_Pagamento forma_Pagamento, boolean parcelar, int qtd_Parcelas) {
        this.valor_Total = valor_Total;
        this.forma_Pagamento = forma_Pagamento;
        this.parcelar = parcelar;
        this.qtd_Parcelas = qtd_Parcelas;
    }

    public int getCod_Pagamento() {
        return cod_Pagamento;
    }

    public void setCod_Pagamento(int cod_Pagamento) {
        this.cod_Pagamento = cod_Pagamento;
    }

    public double getValor_Total() {
        return valor_Total;
    }

    public void setValor_Total(double valor_Total) {
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

    
}
