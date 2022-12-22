package com.printf.restaurante.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.printf.restaurante.modelos.Compra;
import com.printf.restaurante.modelos.repositorios.CompraRepositorio;

@RestController
public class CompraControlador {
	
	@Autowired
	private CompraRepositorio repositorio;
	
	@PostMapping(path = "/exportarPdf")
	public Compra salvarProduto(@RequestBody Compra compra) {
		return repositorio.save(compra);
	}
    
	@PostMapping("/atualizarCompra")
    public void atualizarProduto(@RequestBody Compra compra){
		repositorio.save(compra);
    }

    @DeleteMapping("deletarCompra/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
    	repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
