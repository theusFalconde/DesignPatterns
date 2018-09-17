package com.edu.up.postagem;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.edu.up.observe.IObservadorPostagens;

public class PostagemCorreiosObservavel {
	private Date dataHoraPostagem;
	private String origem;
	private String destino;
	private Set<IObservadorPostagens> observadores;
	private boolean itemEntregue;
	private Set<String> localidades = new HashSet<String>();
	
	private String ultimaLocalidade;

	public PostagemCorreiosObservavel(String origem, String destino) {
		dataHoraPostagem = new Date();
		observadores = new HashSet<IObservadorPostagens>();
		this.origem = origem;
		this.destino = destino;
		ultimaLocalidade = origem;
		itemEntregue = false;
	}

	public void adicionarObservador(IObservadorPostagens observador) {
		observadores.add(observador);
		observador.setPostagemObservada(this);
	}

	public void removerObservador(IObservadorPostagens observador) {
		observadores.remove(observador);
	}

	public void notificar() {
		for (IObservadorPostagens o : observadores) {
			o.atualizar();
		}
	}

	public Date getDataHoraPostagem() {
		return dataHoraPostagem;
	}

	public void setDataHoraPostagem(Date dataHoraPostagem) {
		this.dataHoraPostagem = dataHoraPostagem;
		this.notificar();
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
		this.notificar();
	}

	public boolean isItemEntregue() {
		return itemEntregue;
	}

	public void setItemEntregue(boolean itemEntregue) {
		this.itemEntregue = itemEntregue;
		this.notificar();
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
		setUltimaLocalidade(origem);
	}

	public String getUltimaLocalidade() {
		return ultimaLocalidade;
	}

	public void setUltimaLocalidade(String ultimaLocalidade) {
		this.ultimaLocalidade = ultimaLocalidade;
		localidades.add(ultimaLocalidade);
		this.notificar();
	}
	
	public Set<String> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Set<String> localidades) {
		this.localidades = localidades;
	}
}
