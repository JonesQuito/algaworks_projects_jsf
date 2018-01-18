package com.algaworks.cursojsf2.financeiro.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.RequeridoCondicional")
public class RequeridoCondicionalValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		Boolean checado = (Boolean) component.getAttributes().get("checado");
		if(checado != null && checado && value == null) {
			Object label = MessageFactory.getLabel(context, component);
			
			String mensagemErro = "Preencha o campo " + label + ".";
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
											mensagemErro, mensagemErro));
		}
		
	}

}
