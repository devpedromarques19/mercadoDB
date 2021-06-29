package com.example.mercadoDB.api.services;

import com.example.mercadoDB.api.dto.ProdutoDto;
import com.example.mercadoDB.api.entities.MercadoEntity;
import com.example.mercadoDB.api.entities.ProdutoEntity;
import com.example.mercadoDB.api.repositories.MercadoRepository;
import com.example.mercadoDB.api.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    MercadoRepository mercadoRepository;

    public List<ProdutoEntity> getTodosProdutos (){return this.produtoRepository.findAll();}

    public List<ProdutoEntity> getTodosProdutosbyMercado (int mercado_id) {

        MercadoEntity mercadoEntity = this.mercadoRepository.findById(mercado_id);

        return produtoRepository.findByMercado(mercadoEntity);

    }

    public ProdutoEntity persistirProduto (ProdutoDto produtoDto){

            ProdutoEntity produtoEntity = new ProdutoEntity();

            MercadoEntity mercadoEntity = mercadoRepository.findById(produtoDto.getMercado_id());

            produtoEntity.setMercado(mercadoEntity);
            produtoEntity.setPreco(produtoDto.getPreco());
            produtoEntity.setNome(produtoDto.getNome());
            produtoEntity.setQuantidade(produtoDto.getQuantidade());

            return this.produtoRepository.save(produtoEntity);

    }

    public ProdutoEntity persistirProduto (ProdutoDto produtoDto, int id){

        ProdutoEntity produtoEntity = new ProdutoEntity();

        MercadoEntity mercadoEntity = mercadoRepository.findById(produtoDto.getMercado_id());

        produtoEntity.setId(id);
        produtoEntity.setMercado(mercadoEntity);
        produtoEntity.setPreco(produtoDto.getPreco());
        produtoEntity.setNome(produtoDto.getNome());
        produtoEntity.setQuantidade(produtoDto.getQuantidade());

        return this.produtoRepository.save(produtoEntity);

    }


    public void removerProduto (ProdutoEntity produtoEntity){produtoRepository.delete(produtoEntity);}

}
