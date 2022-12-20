package com.printf.restaurante.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name="id_cliente")
	  private int id;
	  @Column(name="nome", nullable=false)
	  private String nome;
	  @Column(name="endereco")
	  private String endereco;
	  @Column(name="telefone")
	  private String telefone;
	  @Column(name="cpf")
	  private String cpf;
	  @Column(name="tipo_pagamento")
	  private String tipoPagamento;
	  @Column(name="sexo")
	  private char sexo;
	  @Column(name="idade")
	  private String idade;
	
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}

}
