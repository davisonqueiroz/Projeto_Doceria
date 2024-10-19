
package com.mycompany.model;

import Enums.Unidade_Da_Federacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco" )
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int id_Endereco;
    
    private String rua;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private Unidade_Da_Federacao UF;
    private String CEP;

    public Endereco() {
        
    }

    
    public Endereco(String rua, String cidade, Unidade_Da_Federacao UF, String CEP) {
        this.rua = rua;
        this.cidade = cidade;
        this.UF = UF;
        this.CEP = CEP;
    }

    public int getCod_Endereco() {
        return id_Endereco;
    }

    public void setCod_Endereco(int cod_Endereco) {
        this.id_Endereco = cod_Endereco;
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
