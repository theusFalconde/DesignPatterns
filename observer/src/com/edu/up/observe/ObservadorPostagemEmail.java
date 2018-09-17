package com.edu.up.observe;

import com.edu.up.postagem.PostagemCorreiosObservavel;

public class ObservadorPostagemEmail extends ObservadorPostagem implements IObservadorPostagens {
	private String email;
	
	public ObservadorPostagemEmail(String email) {
		this.email = email;
	}

	@Override
	public void setPostagemObservada(PostagemCorreiosObservavel postagemObservada) {
		this.postagemObservada = postagemObservada;
		super.atualizarDados();
	}

	@Override
	public void atualizar() {
		System.out.println("Enviando um Email para " + email + " com os seguintes conteúdos");
		super.atualizar();
	}
	
	@Override
	protected void atualizarDados() {
		super.atualizarDados();
	}

}
