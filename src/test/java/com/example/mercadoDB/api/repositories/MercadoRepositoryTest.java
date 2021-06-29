package com.example.mercadoDB.api.repositories;

import com.example.mercadoDB.api.entities.MercadoEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class MercadoRepositoryTest {

    @Autowired
    MercadoRepository mercadoRepository;

    private static final String CNPJ = "51463645000100";

    @BeforeEach
    public void setUp() {
        MercadoEntity mercado = new MercadoEntity();
        mercado.setNome("Mercadinho");
        mercado.setCnpj(CNPJ);
        this.mercadoRepository.save(mercado);
    }

    @AfterEach
    public void tearDown() {
        this.mercadoRepository.deleteAll();
    }

    @Test
    public void testBuscarPorCnpj() {
        MercadoEntity mercado = this.mercadoRepository.findByCnpj(CNPJ);
        Assertions.assertEquals(CNPJ, mercado.getCnpj());
    }

    @Test
    public void testBuscarPorNome() {
        MercadoEntity mercado = this.mercadoRepository.findByNome("Mercadinho");
        Assertions.assertEquals("Mercadinho", mercado.getNome());
    }
}


