package com.printf.restaurante.modelos;

import jakarta.persistence.*;

@Entity
@Table(name="produto")
public class Produto {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_produto")
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="precoDoProduto")
    private Double precoDoProduto;
    @Column(name="descricao")
    private String descricao;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrecoDoProduto() {
		return precoDoProduto;
	}
	public void setPrecoDoProduto(Double precoDoProduto) {
		this.precoDoProduto = precoDoProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
       
}
