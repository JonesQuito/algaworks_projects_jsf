package com.algaworks.cursojsf2.financeiro.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;

public class LancamentosHibernate implements Lancamentos{
	
	private Session session;
	
	public LancamentosHibernate(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> todos() {	
		return this.session.createQuery("from Lancamento").getResultList();
	}


	@Override
	public Lancamento guardar(Lancamento lancamento) {
		return (Lancamento)session.merge(lancamento);
	}

	@Override
	public void remover(Lancamento lancamento) {
		session.delete(lancamento);
	}

	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		return (Lancamento)this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("tipo", lancamento.getTipo()))
				.add(Restrictions.eq("pessoa", lancamento.getPessoa()))
				.add(Restrictions.eq("descricao", lancamento.getDescricao()))
				.uniqueResult();
	
	}

	@Override
	public Lancamento porCodigo(Integer codigo) {
		return (Lancamento)this.session.get(Lancamento.class, codigo);
	}

}
