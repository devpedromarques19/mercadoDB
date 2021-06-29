package com.example.mercadoDB.api.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "mercado")
public class MercadoEntity {

    private int id;
    private String nome;
    private String cnpj;
    List<ProdutoEntity> produtos;

    public MercadoEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty
    @Length (min = 3, max = 255, message = "O nome da empresa deve conter entre 3 a 255 caracteres")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty
    @CNPJ (message = "CNPJ invalido")
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @OneToMany (mappedBy = "mercado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }
}
