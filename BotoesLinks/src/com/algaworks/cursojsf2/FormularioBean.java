package com.algaworks.cursojsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FormularioBean {
	
	private String nome;
	
	public String tamanhoTexto() {
		if(this.nome.length() < 3) {
			return "Formulario";
		}
		return "Resultado";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
