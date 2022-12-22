package com.printf.restaurante.modelos.repositorios;

import com.printf.restaurante.modelos.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepositorio extends CrudRepository<Produto, Long>{

}
