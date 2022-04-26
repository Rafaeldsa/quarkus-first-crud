package com.github.rafaeldsa;

import java.math.BigDecimal;
import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto extends PanacheEntity {

    private String nome;
    private BigDecimal valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @CreationTimestamp
    private Date dataCriacao;

    public Produto(String nome, BigDecimal valor, Date dataCriacao, Date dataAtualizacao) {
        this.nome = nome;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Produto(){}

    @UpdateTimestamp
    private Date dataAtualizacao;




}
