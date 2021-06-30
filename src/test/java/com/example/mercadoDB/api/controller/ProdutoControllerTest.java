package com.example.mercadoDB.api.controller;

import com.example.mercadoDB.api.dto.ProdutoDto;
import com.example.mercadoDB.api.repositories.MercadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void testGetTodosProdutos ()throws Exception{
        mvc.perform(get("/getTodosProdutos")).andExpect(status().isOk());
    }

    @Test
    public void testRemoverProdutos ()throws Exception{

        ProdutoDto produto = new ProdutoDto();
        produto.setId(3);
        produto.setNome("teste");
        produto.setPreco(5.3);
        produto.setQuantidade(33);
        produto.setMercado_id(3);

        mvc.perform(delete("/removerProduto").contentType("application/json")
                .content(objectMapper.writeValueAsString(produto))).andExpect(status().isBadRequest());
    }

}


