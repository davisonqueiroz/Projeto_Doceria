
package com.mycompany.model;

import Enums.Tipo_Contato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tel_fornecedor")
public class TelefoneFornecedor {
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telForn")
    private int id_Telefone;
    
    @Column(name = "numero_tel")
    private String numero_Tel;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contato")
    private Tipo_Contato tipo_Contato;
    
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    public TelefoneFornecedor() {
        
    }

    public TelefoneFornecedor(String numero_Tel, Tipo_Contato tipo_Contato, Fornecedor fornecedor) {
        this.numero_Tel = numero_Tel;
        this.tipo_Contato = tipo_Contato;
        this.fornecedor = fornecedor;
    }

    public int getCod_Telefone() {
        return id_Telefone;
    }

    public void setCod_Telefone(int cod_Telefone) {
        this.id_Telefone = cod_Telefone;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
