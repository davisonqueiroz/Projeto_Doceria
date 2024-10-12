
package com.mycompany.model;


public class Endereço {
    
    private int cod_Endereco;
    private String rua;
    private String cidade;
    private String UF;
    private String CEP;

    public Endereço(String rua, String cidade, String UF, String CEP) {
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

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
    
}
