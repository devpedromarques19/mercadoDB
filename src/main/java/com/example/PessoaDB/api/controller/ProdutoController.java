package com.example.PessoaDB.api.controller;

import com.example.PessoaDB.api.dto.ProdutoDto;
import com.example.PessoaDB.api.entities.ProdutoEntity;
import com.example.PessoaDB.api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping (value = "/getTodosProdutos", method = RequestMethod.GET)
    List<ProdutoEntity> getTodosProdutos () {return produtoService.getTodosProdutos();}

    @RequestMapping (value = "adicionaProduto", method = RequestMethod.POST)
    String adicionaProduto (@RequestBody ProdutoDto produtoDto) {return produtoService.adicionarProduto(produtoDto);}

}
