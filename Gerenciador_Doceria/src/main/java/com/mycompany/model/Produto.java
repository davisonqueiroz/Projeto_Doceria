
package com.mycompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_Produto;
    private String nome_Produto;
    private double valor;
    
    @ManyToMany
    @JoinTable(name = "Receita", 
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
    private List<Item> itens = new ArrayList();
    
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos = new ArrayList();
  
}
