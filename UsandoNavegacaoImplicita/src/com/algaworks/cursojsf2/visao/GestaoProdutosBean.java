package com.algaworks.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@SessionScoped
public class GestaoProdutosBean {
	
	private Produto produto;
	private List<Produto> produtos;
	
	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public String obterAjuda() {
		if(this.produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		}else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}

	
	public Produto getProduto() {
		return produto;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}
	

}
