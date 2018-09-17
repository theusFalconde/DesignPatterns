package com.edu.up.observe;

import com.edu.up.postagem.PostagemCorreiosObservavel;

public class ObservadorPostagemSMS extends ObservadorPostagem implements IObservadorPostagens {
	private int numeroEnvioSMS;

	public ObservadorPostagemSMS(int numeroEnvioSMS) {
		super();
		this.numeroEnvioSMS = numeroEnvioSMS;
	}

	@Override
	public void setPostagemObservada(PostagemCorreiosObservavel postagemObservada) {
		this.postagemObservada = postagemObservada;
		this.atualizarDados();
	}

	@Override
	public void atualizar() {
		System.out.println("Enviando um SMS para " + numeroEnvioSMS + " com os seguintes conteúdos");
		super.atualizar();
	}

}
