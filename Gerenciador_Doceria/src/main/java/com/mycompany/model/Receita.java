package com.mycompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    private int quantidade_Item;

  

}
