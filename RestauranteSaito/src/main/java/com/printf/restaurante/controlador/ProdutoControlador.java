package com.printf.restaurante.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.printf.restaurante.modelos.Produto;
import com.printf.restaurante.modelos.repositorios.ProdutoRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoControlador {
	
	@Autowired
	private ProdutoRepositorio repositorio;
	
	@GetMapping(path = "/mostrarProdutos")
	public List<Produto> mostrarProdutos() {
		return (List<Produto>) repositorio.findAll();
	}
	@GetMapping(path = "/mostrarProduto/{codigo}")
	public ResponseEntity consultarProduto(@PathVariable("codigo") long codigo) {
		return repositorio.findById(codigo).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = "/salvarProduto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return repositorio.save(produto);
	}
    
	@PostMapping("/atualizarProduto")
    public void atualizarProduto(@RequestBody Produto produto){
		repositorio.save(produto);
    }

    @DeleteMapping("deletarProduto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
    	repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
	public List<Produto> pegarProdutos(List<Long> id){
		List<Produto> produtos = new ArrayList<>();
		Optional<Produto> produto;
		long idEncontrar = 0;
		for(int i = 0; i < id.size(); i++){
			idEncontrar = id.get(i);
			produto = repositorio.findById(idEncontrar);
			produtos.add(produto.get());
		}
		return produtos;
	}

}

/*
 * 	public List<Produto> pegarProdutos(List<Long> id){
		List<Produto> produtos = new ArrayList<>();
		Produto produto;
		long idEncontrar;
		for(int i = 0; i < id.size(); i++){
			idEncontrar = id.get(i);
			produto = (Produto) consultarProduto(idEncontrar).getBody();
			produtos.add(produto);
		}
		return produtos;
	}
 */