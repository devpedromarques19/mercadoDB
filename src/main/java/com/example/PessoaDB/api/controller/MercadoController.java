package com.example.PessoaDB.api.controller;

import com.example.PessoaDB.api.entities.MercadoEntity;
import com.example.PessoaDB.api.services.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MercadoController {

    @Autowired
    public MercadoService mercadoService;

    @RequestMapping (value = "/getTodosMercados", method = RequestMethod.GET)
    public List<MercadoEntity> getTodosMercados (){
        return mercadoService.getTodosMercados();
    }

    @RequestMapping (value = "/adicionaMercado", method = RequestMethod.POST)
    public String adicionaMercado (@RequestBody MercadoEntity mercadoEntity){return mercadoService.adicionarMercado(mercadoEntity);}

}

