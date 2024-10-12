
package com.mycompany.model;

import Enums.Tipo_Contato;


public class Telefone {
    
    private int cod_Telefone;
    private String numero_Tel;
    private Tipo_Contato tipo_Contato;

    public Telefone(String numero_Tel, Tipo_Contato tipo_Contato) {
        this.numero_Tel = numero_Tel;
        this.tipo_Contato = tipo_Contato;
    }

    public int getCod_Telefone() {
        return cod_Telefone;
    }

    public void setCod_Telefone(int cod_Telefone) {
        this.cod_Telefone = cod_Telefone;
    }

    public String getNumero_Tel() {
        return numero_Tel;
    }

    public void setNumero_Tel(String numero_Tel) {
        this.numero_Tel = numero_Tel;
    }

    public Tipo_Contato getTipo_Contato() {
        return tipo_Contato;
    }

    public void setTipo_Contato(Tipo_Contato tipo_Contato) {
        this.tipo_Contato = tipo_Contato;
    }

    
}
