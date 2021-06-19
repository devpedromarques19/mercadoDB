package com.example.PessoaDB.api.services;

import com.example.PessoaDB.api.dto.ProdutoDto;
import com.example.PessoaDB.api.entities.MercadoEntity;
import com.example.PessoaDB.api.entities.ProdutoEntity;
import com.example.PessoaDB.api.repositories.MercadoRepository;
import com.example.PessoaDB.api.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    MercadoRepository mercadoRepository;

    public List<ProdutoEntity> getTodosProdutos (){return this.produtoRepository.findAll();}

    public String adicionarProduto (ProdutoDto produtoDto){

            ProdutoEntity produtoEntity = new ProdutoEntity();

            MercadoEntity mercadoEntity = mercadoRepository.findById(produtoDto.getMercado_id());

            produtoEntity.setMercado(mercadoEntity);
            produtoEntity.setPreco(produtoDto.getPreco());
            produtoEntity.setNome(produtoDto.getNome());
            produtoEntity.setQuantidade(produtoDto.getQuantidade());

            this.produtoRepository.save(produtoEntity);
            return "Produto Cadastrado";

    }

}
