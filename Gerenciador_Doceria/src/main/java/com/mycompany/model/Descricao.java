
package com.mycompany.model;

import Enums.Medida;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "descricao")
public class Descricao {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desc")
    private int id_Descricao;
    
    @Column(name = "nome_item")
    private String nome_Item;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "medida")
    private Medida medida;
    
    @Column(name = "peso")
    private int peso;

    @OneToMany(mappedBy = "descricao")
    private List<Item> itens = new ArrayList();
    
    public Descricao() {
    }

    public Descricao(String nome_Item, Medida medida, int peso) {
        this.nome_Item = nome_Item;
        this.medida = medida;
        this.peso = peso;
    }

    public int getId_Descricao() {
        return id_Descricao;
    }

    public void setId_Descricao(int id_Descricao) {
        this.id_Descricao = id_Descricao;
    }

    public String getNome_Item() {
        return nome_Item;
    }

    public void setNome_Item(String nome_Item) {
        this.nome_Item = nome_Item;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

 
}
