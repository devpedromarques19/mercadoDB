package com.example.mercadoDB.api.services;

import com.example.mercadoDB.api.entities.MercadoEntity;
import com.example.mercadoDB.api.repositories.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoService {

    @Autowired
    MercadoRepository mercadoRepository;

    public MercadoEntity persistirMercado (MercadoEntity mercado){return this.mercadoRepository.save(mercado);}

    public MercadoEntity buscarPorId (int id){return this.mercadoRepository.findById(id);}

    public MercadoEntity buscarPorCnpj (String cnpj){return this.mercadoRepository.findByCnpj(cnpj);}

    public List<MercadoEntity> getTodosMercados(){ return this.mercadoRepository.findAll(); }

    public void removerMercado (MercadoEntity mercadoEntity){mercadoRepository.delete(mercadoEntity);}


}

