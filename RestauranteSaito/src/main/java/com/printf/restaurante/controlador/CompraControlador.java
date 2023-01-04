package com.printf.restaurante.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.printf.restaurante.controlador.FunçoesExtra.CompraPdf;
import com.printf.restaurante.modelos.Compra;
import com.printf.restaurante.modelos.Produto;
import com.printf.restaurante.modelos.repositorios.CompraRepositorio;
import com.printf.restaurante.modelos.repositorios.ProdutoRepositorio;

@RestController
public class CompraControlador {
	
	@Autowired
	private CompraRepositorio repositorio;
	@Autowired
	private ProdutoRepositorio produtoRep;

	private CompraPdf compraPdf = new CompraPdf();
	private	clienteControlador clienteCT = new clienteControlador();
	
	@GetMapping(path = "/mostrarCompras")
	public List<Compra> mostrarCompras() {
		return (List<Compra>) repositorio.findAll();
	}
	@GetMapping(path = "/mostrarCompra/{codigo}")
	public ResponseEntity consultarCompra(@PathVariable("codigo") long codigo) {
		return repositorio.findById(codigo).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping(path = "/exportaPdf/{codigo}")
	public ResponseEntity exportaPdf(@PathVariable("codigo") long codigo) {
		Optional<Compra> compra = repositorio.findById(codigo);
		//compraPdf.criarPdf(compra.get(),,clienteCT.pegarCliente(codigo));
		return ResponseEntity.ok().body(compra);
	}

	@PostMapping(path = "/salvarCompra")
	public Compra salvarCompra(@RequestBody Compra compra) {
		return repositorio.save(compra);
	}
    
	@PostMapping("/atualizarCompra")
    public void atualizarCompra(@RequestBody Compra compra){
		repositorio.save(compra);
    }

    @DeleteMapping("deletarCompra/{id}")
    public ResponseEntity<Void> deletarCompra(@PathVariable Long id){
    	repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
	@GetMapping(path = "/teste")
	public List<Produto> mostrarProdutos() {
		return (List<Produto>) produtoRep.findAll();
	}
}
