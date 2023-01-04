package com.printf.restaurante.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.printf.restaurante.modelos.Cliente;
import com.printf.restaurante.modelos.repositorios.ClienteRepositorio;

import java.util.List;
import java.util.Optional;

@RestController
public class clienteControlador {

	@Autowired
	private ClienteRepositorio repositorio;
	
	@GetMapping(path = "/mostrarclientes")
	public List<Cliente> mostrarClientes() {
		return (List<Cliente>) repositorio.findAll();
	}
	@GetMapping(path = "/mostrarcliente/{codigo}")
	public ResponseEntity consultarCliente(@PathVariable("codigo") long codigo) {
		return repositorio.findById(codigo).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = "/salvarcliente")
	public Cliente salvar(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}
    
	@PostMapping("/atualizarCliente")
    public void atualizarCliente(@RequestBody Cliente cliente){
		repositorio.save(cliente);
    }

    @DeleteMapping("deletarCliente/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
    	repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

	public Cliente pegarCliente(Long id){
		Optional<Cliente> cliente = repositorio.findById(id);
		return cliente.get();
	}

}