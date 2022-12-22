package com.printf.restaurante.modelos;

import jakarta.persistence.*;

@Entity
@Table(name="compra")
public class Compra {

    @Id
    @Column(name="id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente idCliente;
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto idProduto;
    @Column(name="quatidade_de_produtos")
    private Double quatidadeDeProdutos;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	public Produto getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}
	public Double getQuatidadeDeProdutos() {
		return quatidadeDeProdutos;
	}
	public void setQuatidadeDeProdutos(Double quatidadeDeProdutos) {
		this.quatidadeDeProdutos = quatidadeDeProdutos;
	}

}