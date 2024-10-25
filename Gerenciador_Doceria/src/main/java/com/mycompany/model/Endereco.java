package com.mycompany.model;

import Enums.Unidade_Da_Federacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "endereco")
public class Endereco {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int id_Endereco;
    private String CEP;
    @Column(name = "rua")
    private String logradouro;
    private String complemento;
    @Transient
    private String unidade;
    private String bairro;
    @Column(name = "cidade")
    private String localidade;
    @Enumerated(EnumType.STRING)
    private Unidade_Da_Federacao UF;
    @Transient
    private String estado;
    @Transient
    private String regiao;
    @Transient
    private String ibge;
    @Transient
    private String gia;
    @Transient
    private String ddd;
    @Transient
    private String siafi;
    

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

    public Endereco() {

    }

    public Endereco(String CEP, String logradouro, String complemento, String unidade, String bairro,
            String localidade, Unidade_Da_Federacao UF, String estado, String regiao, String ibge, 
            String gia, String ddd, String siafi) {
        
        this.CEP = CEP;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.unidade = unidade;
        this.bairro = bairro;
        this.localidade = localidade;
        this.UF = UF;
        this.estado = estado;
        this.regiao = regiao;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }

    public int getId_Endereco() {
        return id_Endereco;
    }

    public void setId_Endereco(int id_Endereco) {
        this.id_Endereco = id_Endereco;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Unidade_Da_Federacao getUF() {
        return UF;
    }

    public void setUF(Unidade_Da_Federacao UF) {
        this.UF = UF;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Endereco{" + "CEP=" + CEP + ", logradouro=" + logradouro + ", complemento=" + complemento + ", unidade=" + unidade + ", bairro=" + bairro + ", localidade=" + localidade + ", UF=" + UF + ", estado=" + estado + ", regiao=" + regiao + ", ibge=" + ibge + ", gia=" + gia + ", ddd=" + ddd + ", siafi=" + siafi + '}';
    }
    
    


}
