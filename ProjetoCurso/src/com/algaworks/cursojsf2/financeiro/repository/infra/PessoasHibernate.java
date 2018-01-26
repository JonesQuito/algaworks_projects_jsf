package com.algaworks.cursojsf2.financeiro.repository.infra;

import java.util.List;

import org.hibernate.Session;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;

public class PessoasHibernate implements Pessoas {
	
	Session session;
	
	public PessoasHibernate(Session session) {
		this.session =  session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> todas() {
		return session.createQuery("from Pessoa order by nome").getResultList();
	}

	@Override
	public Pessoa porCodigo(Integer codigo) {
		return (Pessoa)this.session.get(Pessoa.class, codigo);
	}
	
	

}
