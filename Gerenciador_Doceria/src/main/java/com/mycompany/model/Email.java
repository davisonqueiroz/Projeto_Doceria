
package com.mycompany.model;

public class Email {
    
    private int cod_Email;
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public int getCod_Email() {
        return cod_Email;
    }

    public void setCod_Email(int cod_Email) {
        this.cod_Email = cod_Email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
