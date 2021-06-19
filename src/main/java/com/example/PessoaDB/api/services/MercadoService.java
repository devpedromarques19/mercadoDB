package com.example.PessoaDB.api.services;

import com.example.PessoaDB.api.entities.MercadoEntity;
import com.example.PessoaDB.api.repositories.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoService {

    @Autowired
    MercadoRepository mercadoRepository;

    public String adicionarMercado (MercadoEntity mercado){

        if (mercadoRepository.findByCnpj(mercado.getCnpj())==null) {
            this.mercadoRepository.save(mercado);
            return "Mercado Cadastrado";
        }
        return "Não deeeeu";
    }

    public MercadoEntity buscarPorId (int id){
        return this.mercadoRepository.getById(id);
    }

    public List<MercadoEntity> getTodosMercados(){ return this.mercadoRepository.findAll(); }


}
