
package com.mycompany.model;

import Enums.Unidade_Da_Federacao;


public class Endereço {
    
    private int cod_Endereco;
    private String rua;
    private String cidade;
    private Unidade_Da_Federacao UF;
    private String CEP;

    public Endereço(String rua, String cidade, Unidade_Da_Federacao UF, String CEP) {
        this.rua = rua;
        this.cidade = cidade;
        this.UF = UF;
        this.CEP = CEP;
    }

    public int getCod_Endereco() {
        return cod_Endereco;
    }

    public void setCod_Endereco(int cod_Endereco) {
        this.cod_Endereco = cod_Endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Unidade_Da_Federacao getUF() {
        return UF;
    }

    public void setUF(Unidade_Da_Federacao UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    
}
