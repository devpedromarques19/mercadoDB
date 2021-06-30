package com.example.mercadoDB.api.controller;

import com.example.mercadoDB.api.entities.MercadoEntity;
import com.example.mercadoDB.api.services.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MercadoControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void testGetTodosMercados ()throws Exception{
        mvc.perform(get("/getTodosMercados")).andExpect(status().isOk());
    }

    @Test
    public void testAdicionaMercado ()throws Exception{
        MercadoEntity mercadoEntity = new MercadoEntity();
        mercadoEntity.setId(1);
        mercadoEntity.setNome("teste");
        mercadoEntity.setCnpj("84155358000183");

        mvc.perform(post("/adicionaMercado")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mercadoEntity)))
                .andExpect(status().isOk());
    }
}
