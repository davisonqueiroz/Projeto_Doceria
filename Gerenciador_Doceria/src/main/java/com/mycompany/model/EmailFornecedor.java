
package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "email_fornecedor")
public class EmailFornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forn_email")
    private int id_Email;
    @Column(name = "end_email")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    public EmailFornecedor() {
        
    }

    
    public EmailFornecedor(String email, Fornecedor fornecedor) {
        this.email = email;
        this.fornecedor = fornecedor;
    }

    public int getCod_Email() {
        return id_Email;
    }

    public void setCod_Email(int cod_Email) {
        this.id_Email = cod_Email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
                                    
}
