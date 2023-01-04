package com.printf.restaurante.controlador.FunçoesExtra;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.printf.restaurante.modelos.Cliente;
import com.printf.restaurante.modelos.Compra;
import com.printf.restaurante.modelos.Produto;

public class CompraPdf {

    private Document documentPDF;
	

    public void criarPdf(Compra compra,List<Produto> produtos,Cliente cliente ) {
		documentPDF = new Document();
		documentPDF.setPageSize(PageSize.A4);
		documentPDF.setMargins(20, 20, 20, 20);
		
		FileOutputStream baos;

		try {
			baos = new FileOutputStream("teste.pdf");

			PdfWriter.getInstance(documentPDF, baos);
		
			documentPDF.open();
			adicionarPdf(compra,produtos,cliente);
			documentPDF.addTitle("Pdf Do Saito");
			documentPDF.addAuthor("Saito");
		
			documentPDF.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

    private void adicionarPdf(Compra compra ,List<Produto> produtos,Cliente cliente){
		
		
		compra.setValorTotal(somarValor(compra, produtos));

		documentPDF.add(new Paragraph("-----------Data Da Compra-----------"));
        documentPDF.add(new Paragraph(compra.getDataDaCompra().toString()));
		documentPDF.add(new Paragraph());
		documentPDF.add(new Paragraph("-----------Informação dos Produtos-----------"));
		listaDeProdutoEmPdf(compra, produtos);
		documentPDF.add(new Paragraph("Valor Total:                   " +  compra.getValorTotal()));
		documentPDF.add(new Paragraph("-----------Informações do Cliente-----------"));
		documentPDF.add(new Paragraph("Nome: " + cliente.getNome()));
		documentPDF.add(new Paragraph("Tipo de Pagamento: " + cliente.getTipoPagamento()));
		documentPDF.add(new Paragraph("Telefone: " + cliente.getTelefone()));
		documentPDF.add(new Paragraph("Data Da Compra: " + compra.getDataDaCompra()));
	}

	private double somarValor(Compra compra,List<Produto> produtos){
		
		double calcular = 1;
		for(int i = 0; i < produtos.size(); i++){
			if(compra.getQuatidadeDeProdutos().get(i) < compra.getQuatidadeDeProdutos().size() && compra.getQuatidadeDeProdutos().get(i) != 0 ){
				calcular = (produtos.get(i).getPrecoDoProduto() * compra.getQuatidadeDeProdutos().get(i)) + calcular;
			}else{
				calcular = produtos.get(i).getPrecoDoProduto() + calcular;
			}
		}

		return calcular;
	}

	private void listaDeProdutoEmPdf(Compra compra,List<Produto> produtos) {
		double valorAPagar; 
		for(int i = 0; i < produtos.size(); i++){
			if(compra.getQuatidadeDeProdutos().get(i) < compra.getQuatidadeDeProdutos().size() && compra.getQuatidadeDeProdutos().get(i) != 0 ){
				valorAPagar = produtos.get(i).getPrecoDoProduto() * compra.getQuatidadeDeProdutos().get(i);
				documentPDF.add(new Paragraph(produtos.get(i).getNome() + "      " + compra.getQuatidadeDeProdutos().get(i) + "X  valor: " + valorAPagar));	
			}else{
				documentPDF.add(new Paragraph(produtos.get(i).getNome() + "      1X  valor: " + produtos.get(i).getPrecoDoProduto()));
			}
		}
	}
}
