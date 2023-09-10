package com.example.spring.controller;

import com.example.spring.dto.ProdutoDTO;
import com.example.spring.entity.ProdutoEntity;
import com.example.spring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Principal {

    @GetMapping
    public String Main()
    {
        return "Bem vindo aplicação principal de java<br><br>" +
                "******** HTTP REQUEST ********<br><br>" +
                "Principais rotas :<br>" +
                "GET : / <br>" +
                "POST : /produtos/novo-produto <br>" +
                "Para cadastrar um produto, enviar um JSON no post contendo NOME E VALOR<br>" +
                "GET : /todos-produtos";
    }
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping(path = "/produtos/novo-produto")

    public String inserirProduto (@RequestBody ProdutoDTO corpo){
        ProdutoEntity produto = new ProdutoEntity();

        produto.setNome(corpo.nome());
        produto.setValor(corpo.valor());

        produtoRepository.save(produto);
        return "Produto cadastrado !";
    }

    @GetMapping(path = "/todos-produtos")

    public @ResponseBody Iterable<ProdutoEntity> pegarTodosProdutos(){
        return produtoRepository.findAll();
    }

}
