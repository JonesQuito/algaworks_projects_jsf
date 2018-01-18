 package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.algaworks.cursojsf2.financeiro.service.GestaoPessoas;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();
	
	@PostConstruct
	public void init() {
		GestaoPessoas gestaoPessoas = new GestaoPessoas();
		this.pessoas = gestaoPessoas.listarTodas();
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean)event.getNewValue());
		lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	
	public void cadastrar() {
				
		if(!FacesContext.getCurrentInstance().getMessages().hasNext()) {
			System.out.println("Tipo: " + this.lancamento.getTipo());
			System.out.println("Pessoa: " + this.lancamento.getPessoa().getNome());
			System.out.println("Descrição: " + this.lancamento.getDescricao());
			System.out.println("Valor: " + this.lancamento.getValor());
			System.out.println("Data vencimento: " + this.lancamento.getDataVencimento());
			System.out.println("Conta paga: " + this.lancamento.isPago());
			System.out.println("Data pagamento: " + this.lancamento.getDataPagamento());
			
			String mensagem = "Cadastro realizado com sucesso!";
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			this.lancamento = new Lancamento();
		}
		
		
	}
		
	public TipoLancamento[] getTiposLancamento() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	
	
	

	
	
	
	

}
