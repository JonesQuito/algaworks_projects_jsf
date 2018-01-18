package com.algaworks.cursojsf2;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class CadastroUsuarioBean {
	
	private String nome;
	private String email;
	private String senha;
	
	
	public void cadastrar() {
		if(this.getNome() == null || this.getNome().length() < 10) {
			adicionaMensagem("frm:nome", FacesMessage.SEVERITY_ERROR, "Nome imcompleto. ", "Favor, informar o nome completo");
		}
		if(hojeEhDiaDeDescanso()) {
			this.adicionaMensagem(null, FacesMessage.SEVERITY_WARN,
					"Hoje é dia de descanço. ", "Você não pode cadastrar usuários hoje.");
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		if(!context.getMessages().hasNext()) {
			this.adicionaMensagem(null, FacesMessage.SEVERITY_INFO,
					"Usuário Cadastrado. ", "O usuário foi cadastrado com sucesso!");
		}
	}
	
	private void adicionaMensagem(String clienteId, Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(severity, summary, detail);
		
		context.addMessage(clienteId, message);
	}
	
	private boolean hojeEhDiaDeDescanso() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
