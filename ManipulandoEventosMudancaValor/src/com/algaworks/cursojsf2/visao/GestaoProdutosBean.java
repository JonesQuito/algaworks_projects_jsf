package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@SessionScoped
public class GestaoProdutosBean implements Serializable {

	private String nomePesquisa;
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	private Produto produto;

	private Produto produtoSelecionado;

	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produtosFiltrados = new ArrayList<Produto>();
		this.produto = new Produto();
	}

	public void nomePesquisaAlterado(ValueChangeEvent event) {
		System.out.println("Valor atual: " + this.nomePesquisa);
		System.out.println("Novo valor: " + event.getNewValue());
		this.nomePesquisa = event.getNewValue().toString();
		
		incluirProdutosFiltrados(this.nomePesquisa);

	}

	public void incluirProdutosFiltrados(String prefix) {
		this.produtosFiltrados.clear();

		for (Produto prod : produtos) {
			if (prod.getNome().toLowerCase().startsWith(prefix.toLowerCase())) {
				this.produtosFiltrados.add(prod);
			}

		}
	}

	public String obterAjuda() {
		if (this.produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		} else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}

	public void verificarInclusao(ActionEvent event) {
		System.out.println("verificando...");
		if ("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem fabricante");
		}
	}

	public void incluir() {
		System.out.println("incluíndo...");
		this.produtos.add(this.produto);
		this.incluirProdutosFiltrados(nomePesquisa);
		this.produto = new Produto();
	}

	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);	
		incluirProdutosFiltrados(this.nomePesquisa);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

}
