
package com.mycompany.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class FornecedorItemId implements Serializable{
    
    private int fornecedorId;
    private int itemId;

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.fornecedorId;
        hash = 47 * hash + this.itemId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FornecedorItemId other = (FornecedorItemId) obj;
        if (this.fornecedorId != other.fornecedorId) {
            return false;
        }
        return this.itemId == other.itemId;
    }

 
}
