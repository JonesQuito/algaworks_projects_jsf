package com.algaworks.cursojsf2.financeiro.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;

@ManagedBean
public class SegurancaBean {
	
	private String usuario;
	private String senha;
	
	
	public String logar() {
		
		HttpServletRequest request =  this.getRequest();
		
		try {
			request.login(this.usuario, this.senha);
			return "Home?faces-redirect=true";
		} catch (ServletException e) {
			FacesUtil.adicionarMessagem(FacesMessage.SEVERITY_ERROR,
					FacesUtil.getMessageI18n("username_password_does_not_match"));
			return null;
		}
	}
	
	
	public String sair() throws ServletException {
		HttpServletRequest request = this.getRequest();
		request.logout();
		return "Login?redirect=true";
	}
	
	private HttpServletRequest getRequest() {
		FacesContext context = FacesContext.getCurrentInstance();
		return  (HttpServletRequest)context.getExternalContext().getRequest();
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
