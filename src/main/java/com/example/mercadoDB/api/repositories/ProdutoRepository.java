package com.example.mercadoDB.api.repositories;

import com.example.mercadoDB.api.entities.MercadoEntity;
import com.example.mercadoDB.api.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <ProdutoEntity, Integer> {

    ProdutoEntity findByNome (String nome);

    ProdutoEntity findByNomeAndPreco (String nome, double preco);

    ProdutoEntity findByPreco (double preco);

    ProdutoEntity findById (int id);

    List<ProdutoEntity> findByMercado (MercadoEntity mercadoEntity);

}
