package com.algaworks.cursojsf2.validator;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.algaworks.DiaUtil")
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext contex, UIComponent component, Object data) throws ValidatorException {
		
		Calendar c = Calendar.getInstance();
		c.setTime((Date)data);
		
		int diaDaSemana = c.get(Calendar.DAY_OF_WEEK);
		if(diaDaSemana == Calendar.SATURDAY || diaDaSemana == Calendar.SUNDAY) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Data não permitida", "Favor informar uma data que seja um dia útil");
			
			throw new ValidatorException(msg);
		}
	}
}
