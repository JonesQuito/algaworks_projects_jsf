 package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.util.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Repositorios repositorios = new Repositorios();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();
		

	@PostConstruct
	public void init() {	
		Pessoas pessoas = repositorios.getPessoas();
		this.pessoas = pessoas.todas();
	}
	
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean)event.getNewValue());
		lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	
	public void salvar() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.salvar(this.lancamento);
			
			this.lancamento = new Lancamento();	
			
			FacesUtil.adicionarMessagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMessageI18n("entry_saved"));
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMessagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}					
	}
		
	
	public boolean isEditando() {
		return lancamento.getCodigo() != null;
	}
	
	public TipoLancamento[] getTiposLancamento() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}
	
	
	public void setLancamento(Lancamento lancamento) throws CloneNotSupportedException {
		this.lancamento = lancamento;
		if(this.lancamento == null) {
			this.lancamento = new Lancamento();
		}else {
			this.lancamento = (Lancamento) lancamento.clone();
		}
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}
