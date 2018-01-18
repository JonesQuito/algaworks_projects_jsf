package com.algaworks.cursojsf2.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.algaworks.ConversorInteligente")
public class ConversorInteligente2 implements Converter {
	
	//private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);


	private Calendar getCurrentDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c;
	}

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
		Date dataConvertida = null;
		Calendar calendario = Calendar.getInstance();
		
		
		if (valor != null && !valor.equals("")){
			if(valor.equalsIgnoreCase("hoje")) {
				dataConvertida = getCurrentDate().getTime();
			}else if(valor.equalsIgnoreCase("amanha") || valor.equalsIgnoreCase("amanhã")) {
				calendario = getCurrentDate();
				calendario.add(Calendar.DAY_OF_MONTH, 1);
				dataConvertida = calendario.getTime();
			}else if(valor.equalsIgnoreCase("ontem")) {
				calendario = getCurrentDate();
				calendario.add(Calendar.DAY_OF_MONTH, -1);
				dataConvertida = calendario.getTime();
			}else {
				try {
					dataConvertida = df.parse(valor);	
				}catch(ParseException pe) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"'" + valor + "' não é uma data válida",
							"Favor, informar uma data válida");
					throw new ConverterException(msg);
				}
			}
		}else if(valor.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Data não informada",
					"Favor, informar uma data válida");
			throw new ConverterException(msg);
		}
		return dataConvertida;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object valor) {

		return null;
	}

}
