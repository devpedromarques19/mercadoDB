package com.example.mercadoDB.api.repositories;

import com.example.mercadoDB.api.entities.MercadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoRepository extends JpaRepository <MercadoEntity, Integer> {

    MercadoEntity findByCnpj (String Cnpj);

    MercadoEntity findByNome (String nome);

    MercadoEntity findById (int MercadoId);

}
