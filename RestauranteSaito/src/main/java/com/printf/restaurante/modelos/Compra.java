package com.printf.restaurante.modelos;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="compra")
public class Compra {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @JoinColumn(name="idCliente")
    private Long idCliente;
    @JoinColumn(name="idProduto")
    private List<Long> idProduto;
    @Column(name="quatidadeDeProdutos")
    private List<Double> quatidadeDeProdutos;
	@Column(name="valorTotal")
    private Double valorTotal;
	@Column(name="dataDaCompra")
    private Date dataDaCompra;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public List<Long> getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(List<Long> idProduto) {
		this.idProduto = idProduto;
	}
	public List<Double> getQuatidadeDeProdutos() {
		return quatidadeDeProdutos;
	}
	public void setQuatidadeDeProdutos(List<Double> quatidadeDeProdutos) {
		this.quatidadeDeProdutos = quatidadeDeProdutos;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDataDaCompra(){
		return dataDaCompra;
	}
	public void setDataDaCompra(){
		Calendar calendario = Calendar.getInstance();
		dataDaCompra = calendario.getTime();
	}

}