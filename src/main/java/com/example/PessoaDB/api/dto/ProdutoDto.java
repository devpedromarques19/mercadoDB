package com.example.PessoaDB.api.dto;

public class ProdutoDto {

    String nome;
    double preco;
    int quantidade;
    int mercado_id;

    public ProdutoDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getMercado_id() {
        return mercado_id;
    }

    public void setMercado_id(int mercado_id) {
        this.mercado_id = mercado_id;
    }

    @Override
    public String toString() {
        return "ProdutoDto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", mercado_id=" + mercado_id +
                '}';
    }
}

