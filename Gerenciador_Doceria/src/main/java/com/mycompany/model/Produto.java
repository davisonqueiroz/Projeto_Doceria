
package com.mycompany.model;


public class Produto {
    
    private int cod_Produto;
    private String nome_Produto;
    private double valor;

    public Produto(String nome_Produto, double valor) {
        this.nome_Produto = nome_Produto;
        this.valor = valor;
    }

    public int getCod_Produto() {
        return cod_Produto;
    }

    public void setCod_Produto(int cod_Produto) {
        this.cod_Produto = cod_Produto;
    }

    public String getNome_Produto() {
        return nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto = nome_Produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
