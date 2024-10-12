/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author User
 */
public class Fornecedor {
    
    private int  cod_Fornecedor;
    private String nome_Fornecedor;

    public Fornecedor(String nome_Fornecedor) {
        this.nome_Fornecedor = nome_Fornecedor;
    }

    
    
    public int getCod_Fornecedor() {
        return cod_Fornecedor;
    }

    public void setCod_Fornecedor(int cod_Fornecedor) {
        this.cod_Fornecedor = cod_Fornecedor;
    }

    public String getNome_Fornecedor() {
        return nome_Fornecedor;
    }

    public void setNome_Fornecedor(String nome_Fornecedor) {
        this.nome_Fornecedor = nome_Fornecedor;
    }
    
    
   
}

