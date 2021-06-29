package com.example.mercadoDB.api.repositories;

import com.example.mercadoDB.api.entities.MercadoEntity;
import com.example.mercadoDB.api.entities.ProdutoEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    MercadoRepository mercadoRepository;

    @BeforeEach
    public void setUp(){

        MercadoEntity mercado = new MercadoEntity();
        mercado.setId(1);
        mercado.setNome("Mercadinho");
        mercado.setCnpj("51463645000100");
        this.mercadoRepository.save(mercado);

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome("Coca-cola");
        produtoEntity.setPreco(6.50);
        produtoEntity.setQuantidade(10);
        produtoEntity.setMercado(mercado);
        this.produtoRepository.save(produtoEntity);
    }

    @AfterEach
    public void tearDown (){
        this.produtoRepository.deleteAll();
    }

    @Test
    public void testBuscaNome (){
        ProdutoEntity produtoEntity = this.produtoRepository.findByNome("Coca-cola");
        Assertions.assertEquals("Coca-cola",produtoEntity.getNome());
    }

    @Test
    public void testBuscaPreco (){
        ProdutoEntity produtoEntity = this.produtoRepository.findByPreco(6.50);
        Assertions.assertEquals(6.50,produtoEntity.getPreco());
    }

    @Test
    public void testBuscaNomePreco (){
        ProdutoEntity produtoEntity = this.produtoRepository.findByNomeAndPreco("Coca-cola", 6.50);
        Assertions.assertEquals("Coca-cola",produtoEntity.getNome());
        Assertions.assertEquals(6.50,produtoEntity.getPreco());
    }
}
