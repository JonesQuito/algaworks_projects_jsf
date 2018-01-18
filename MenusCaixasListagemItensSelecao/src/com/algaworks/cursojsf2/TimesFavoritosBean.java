package com.algaworks.cursojsf2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TimesFavoritosBean {
	
	private List<String> times; //Recebe os times escolhidos quando o botão "Escolher" for clicado
	private HashSet<String> allTeams; // A collection HasSet garante que não haja elementos repetidos em seu interior
	private String timeSelecionado; // Recebe o time selecionado pra exclusão
	
	
	//Construtor
	public TimesFavoritosBean() {
		times = new ArrayList<String>();
		allTeams = new HashSet<String>();
	}
	
	
	/*
	 * Percorre a lista de times adicionando cada um na HashSet allTeams
	 * mesmo que exista algun time repetido na List times, a duplicidade
	 * não prosseguirar para HashSet allTeams.
	 * Dessa forma, ao fim da execução deste método, a List de times terá
	 * todos os times escolidos sem que haja duplicidade*/
	public void escolher() {
		for(String time : times) {
			this.allTeams.add(time);
			System.out.println(time);
		}
		times.clear(); //Limpa a lista de times para garantir que não haja times repetidos
		for(String time : allTeams) {
			times.add(time);
		}
	}
	
	
	public void excluir() {
		this.times.remove(this.getTimeSelecionado());
		allTeams.clear();
		for(String time : times) {
			allTeams.add(time);
		}
		System.out.println("Time removido foi: " + this.getTimeSelecionado());
	}

	public List<String> getTimes() {
		return this.times;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}

	public String getTimeSelecionado() {
		return timeSelecionado;
	}

	public void setTimeSelecionado(String timeSelecionado) {
		this.timeSelecionado = timeSelecionado;
	}

	public HashSet<String> getAllTeams() {
		return allTeams;
	}

	public void setAllTeams(HashSet<String> allTeams) {
		this.allTeams = allTeams;
	}		
	
}
