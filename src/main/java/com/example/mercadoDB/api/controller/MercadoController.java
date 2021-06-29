package com.example.mercadoDB.api.controller;

import com.example.mercadoDB.api.entities.MercadoEntity;
import com.example.mercadoDB.api.repositories.MercadoRepository;
import com.example.mercadoDB.api.response.Response;
import com.example.mercadoDB.api.services.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MercadoController {

    @Autowired
    MercadoRepository mercadoRepository;

    @Autowired
    public MercadoService mercadoService;

    @CrossOrigin
    @RequestMapping (value = "/getTodosMercados", method = RequestMethod.GET)
    public List<MercadoEntity> getTodosMercados (){
        return mercadoService.getTodosMercados();
    }

    @CrossOrigin
    @RequestMapping (value = "/adicionaMercado", method = RequestMethod.POST)
    public ResponseEntity<Response<MercadoEntity>> adicionaMercado (
            @Valid @RequestBody MercadoEntity mercadoEntity, BindingResult result){

        Response<MercadoEntity> response = new Response<MercadoEntity>();


        if (result.hasErrors()||mercadoRepository.findByCnpj(mercadoEntity.getCnpj()) != null){
            if (mercadoRepository.findByCnpj(mercadoEntity.getCnpj()) != null) {
                response.getErrors().add("CNPJ já existente no banco, digite outro");
            }
            if (result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            }
            return ResponseEntity.badRequest().body(response);
        }else {

            mercadoService.persistirMercado(mercadoEntity);
            response.setData(mercadoEntity);
            return ResponseEntity.ok(response);
        }

    }

    @CrossOrigin
    @RequestMapping (value = "/atualizaMercado", method = RequestMethod.PUT)
    public ResponseEntity <Response<MercadoEntity>> atualizaMercado (@Valid @RequestBody MercadoEntity mercadoEntity, BindingResult result) {

        Response<MercadoEntity> response = new Response<MercadoEntity>();

        if (result.hasErrors()||mercadoRepository.findById(mercadoEntity.getId())==null) {
            if (mercadoRepository.findById(mercadoEntity.getId())==null){
                response.getErrors().add("O mercado com o id "+mercadoEntity.getId()+" não existe, digite outro");
            }
            if (result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            }
            return ResponseEntity.badRequest().body(response);
        } else {
            mercadoService.persistirMercado(mercadoEntity);
            response.setData(mercadoEntity);
            return ResponseEntity.ok(response);
        }
    }

    @CrossOrigin
    @RequestMapping (value = "/removerMercado", method = RequestMethod.DELETE)
    public ResponseEntity<Response<String>> removerMercado (@RequestBody MercadoEntity mercadoEntity) {

        Response<String> response = new Response<String>();

        if (mercadoRepository.findById(mercadoEntity.getId()) == null) {
            response.getErrors().add("O mercado com o id " + mercadoEntity.getId() + " não existe, digite outro");
            return ResponseEntity.badRequest().body(response);
        } else {

            mercadoService.removerMercado(mercadoEntity);
            response.setData("Mercado Apagado");
            return ResponseEntity.ok(response);

        }
    }

}

