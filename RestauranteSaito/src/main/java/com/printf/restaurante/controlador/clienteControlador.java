package com.printf.restaurante.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.printf.restaurante.modelos.Cliente;
import com.printf.restaurante.modelos.repositorios.ClienteRepositorio;

@RestController
public class clienteControlador {

	@Autowired
	private ClienteRepositorio repositorio;
	
	@GetMapping(path = "/cliente/{codigo}")
	public ResponseEntity consultar(@PathVariable("codigo") long codigo) {
		return repositorio.findById(codigo).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = "/cliente/salvar")
	public Cliente salvar(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}
	
}
