package com.printf.restaurante.modelos.repositorios;

import com.printf.restaurante.modelos.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long>{
}
