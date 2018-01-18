package com.algaworks.cursojsf2.financeiro.model;

public enum TipoLancamento {

	RECEITA("Receita"),
	DESPESA("Despesa");
	
	private String descricao;

	TipoLancamento(String tipoLancamento) {
		this.descricao = tipoLancamento;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
