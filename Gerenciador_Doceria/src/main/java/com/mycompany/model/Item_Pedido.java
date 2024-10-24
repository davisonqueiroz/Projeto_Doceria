
package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_pedido")
public class Item_Pedido {
    
    @EmbeddedId
    private ProdutoPedidoId id;
    
    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "idProduto")
    private Produto produto;
    
    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "idPedido")
    private Pedido pedido;
    
    @Column(name = "qtd_itemPedido")
    private int quantidade;

    public Item_Pedido() {
        
    }

    public Item_Pedido(ProdutoPedidoId id, Produto produto, Pedido pedido, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = quantidade;
    }

    public ProdutoPedidoId getId() {
        return id;
    }

    public void setId(ProdutoPedidoId id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
     
}
