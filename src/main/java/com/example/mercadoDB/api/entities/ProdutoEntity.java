package com.example.mercadoDB.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private MercadoEntity mercado;

    public ProdutoEntity() {
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (name = "nome", nullable = false)
    @NotEmpty
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column (name = "preco", nullable = false)
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Column (name = "quantidade", nullable = true)
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JsonIgnore
    public MercadoEntity getMercado() {
        return mercado;
    }

    public void setMercado(MercadoEntity mercado) {
        this.mercado = mercado;
    }
}
