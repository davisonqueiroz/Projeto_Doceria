
package com.mycompany.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class ProdutoPedidoId implements Serializable{
    
    public int produtoId;
    public int pedidoId;

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.produtoId;
        hash = 59 * hash + this.pedidoId;
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
        final ProdutoPedidoId other = (ProdutoPedidoId) obj;
        if (this.produtoId != other.produtoId) {
            return false;
        }
        return this.pedidoId == other.pedidoId;
    }
    
    
}
