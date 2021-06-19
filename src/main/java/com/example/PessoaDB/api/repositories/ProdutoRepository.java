package com.example.PessoaDB.api.repositories;

import com.example.PessoaDB.api.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <ProdutoEntity, Integer> {

    ProdutoEntity findByNome (String nome);

    ProdutoEntity findByNomeAndPreco (String nome, double preco);

    ProdutoEntity findByPreco (double preco);

}
