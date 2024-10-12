
package com.mycompany.model;


public class Cliente {
    
    private int cod_Cliente;
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public int getCod_Cliente() {
        return cod_Cliente;
    }

    public void setCod_Cliente(int cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    
}
