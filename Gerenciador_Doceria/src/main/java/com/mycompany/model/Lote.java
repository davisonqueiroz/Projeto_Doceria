
package com.mycompany.model;

import java.util.Date;


public class Lote {
    
    private int cod_Lote;
    private Date data_Vencimento;

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
    
    
    
}
