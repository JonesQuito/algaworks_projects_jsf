package com.algaworks.cursojsf2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.algaworks.cursojsf2.dominio.Livro;

@ManagedBean
@SessionScoped
public class LivroBeans implements Serializable{
	
	private List<Livro> livros;
	private Livro livro;
	
	public LivroBeans() {
		this.livros = new ArrayList<Livro>();
		this.livro = new Livro();
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public Livro getLivro() {
		return livro;
	}
	
	public void adicionarLivro() {
		this.livros.add(this.livro);
		this.livro = new Livro();
	}
	
	
	
	
	
	
	
	
	
	
	
	


	

}
