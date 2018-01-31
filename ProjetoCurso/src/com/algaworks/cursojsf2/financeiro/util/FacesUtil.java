package com.algaworks.cursojsf2.financeiro.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {
	
	public static String getMessageI18n(String chave) {
		FacesContext contex = FacesContext.getCurrentInstance();
		String msg = contex.getApplication().getResourceBundle(contex, "msg").getString(chave);
		return msg;
	}
	
	public static void adicionarMessagem(Severity tipo, String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(tipo, msg, msg));
	}
	
	
	public static Object getRequestAttribute(String nome) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute("session");
	}

}
