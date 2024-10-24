
package com.mycompany.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemProdutoId implements Serializable{
    
    public int itemId;
    
    public int produtoId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.itemId;
        hash = 47 * hash + this.produtoId;
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
        final ItemProdutoId other = (ItemProdutoId) obj;
        if (this.itemId != other.itemId) {
            return false;
        }
        return this.produtoId == other.produtoId;
    }
    
    
    
}
