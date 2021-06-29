package com.example.mercadoDB.api.controller;

import com.example.mercadoDB.api.dto.ProdutoDto;
import com.example.mercadoDB.api.entities.MercadoEntity;
import com.example.mercadoDB.api.entities.ProdutoEntity;
import com.example.mercadoDB.api.repositories.MercadoRepository;
import com.example.mercadoDB.api.repositories.ProdutoRepository;
import com.example.mercadoDB.api.response.Response;
import com.example.mercadoDB.api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    MercadoRepository mercadoRepository;

    @Autowired
    ProdutoService produtoService;

    @CrossOrigin
    @RequestMapping (value = "/getTodosProdutos", method = RequestMethod.GET)
    List<ProdutoEntity> getTodosProdutos () {return produtoService.getTodosProdutos();}

    @CrossOrigin
    @RequestMapping (value = "/getTodosProdutos/{id}", method = RequestMethod.GET)
    List<ProdutoEntity> getTodosProdutos (@PathVariable ("id") int mercado_id) {return produtoService.getTodosProdutosbyMercado(mercado_id);}

    @CrossOrigin
    @RequestMapping (value = "adicionaProduto", method = RequestMethod.POST)
    ResponseEntity<Response<ProdutoEntity>> adicionaProduto (@Valid @RequestBody ProdutoDto produtoDto, BindingResult result) {
        Response<ProdutoEntity> response = new Response ();

        if (result.hasErrors() || mercadoRepository.findById(produtoDto.getMercado_id())== null){
            if (mercadoRepository.findById(produtoDto.getMercado_id())== null){
                response.getErrors().add("Mercado_id "+produtoDto.getMercado_id()+" não existe, digite outro");
            }
            if (result.hasErrors()){
                result.getAllErrors().forEach(error->response.getErrors().add(error.getDefaultMessage()));
            }
            return ResponseEntity.badRequest().body(response);
        }else{
        ProdutoEntity produtoEntity = produtoService.persistirProduto(produtoDto);
        response.setData(produtoEntity);
        return ResponseEntity.ok(response);
        }
    }

    @CrossOrigin
    @RequestMapping (value = "atualizaProduto", method = RequestMethod.PUT)
    ResponseEntity<Response<ProdutoEntity>> atualizaProduto (@Valid @RequestBody ProdutoDto produtoDto, BindingResult result) {
        Response <ProdutoEntity> response = new Response<ProdutoEntity>();

        if (result.hasErrors() || produtoRepository.findById(produtoDto.getId())==null){
            if (produtoRepository.findById(produtoDto.getId())==null){
                response.getErrors().add("O id: "+produtoDto.getId()+" não existe, digite outro");
            }
            if (result.hasErrors()){
                result.getAllErrors().forEach(error->response.getErrors().add(error.getDefaultMessage()));
            }
            return ResponseEntity.badRequest().body(response);
        }else{
        ProdutoEntity produtoEntity = produtoService.persistirProduto(produtoDto, produtoDto.getId());
        response.setData(produtoEntity);
        return ResponseEntity.ok(response);
        }
    }

    @CrossOrigin
    @RequestMapping (value = "removerProduto", method = RequestMethod.DELETE)
    ResponseEntity <Response<String>> removerProduto (@RequestBody ProdutoEntity produtoEntity) {
        Response <String> response = new Response <String>();
        if (produtoRepository.findById(produtoEntity.getId())!=null) {
            produtoService.removerProduto(produtoEntity);
            response.setData("Produto Removido");
            return ResponseEntity.ok(response);
        }
        else{
            response.getErrors().add("O id "+produtoEntity.getId()+" não existe, digite outro");
            return ResponseEntity.badRequest().body(response);
        }
    }

}
