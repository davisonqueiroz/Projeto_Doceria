
package com.mycompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Lote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_Lote;
    private Date data_Vencimento;
    
    @OneToMany(mappedBy = "lote")
    private List<Item> itens = new ArrayList();

    public Lote(Date data_Vencimento) {
        this.data_Vencimento = data_Vencimento;
    }

    public int getCod_Lote() {
        return cod_Lote;
    }

    public void setCod_Lote(int cod_Lote) {
        this.cod_Lote = cod_Lote;
    }

    public Date getData_Vencimento() {
        return data_Vencimento;
    }

    public void setData_Vencimento(Date data_Vencimento) {
        this.data_Vencimento = data_Vencimento;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

  
    
}
