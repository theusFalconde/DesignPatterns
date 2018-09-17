package com.edu.up.postagem;

public class PostagemSedex extends PostagemCorreiosObservavel {
	private boolean embalagemFragil;
	
	public PostagemSedex(String origem, String destino, boolean embalagemFragil) {
		super(origem, destino);
		this.embalagemFragil = embalagemFragil;
	}

	public boolean isEmbalagemFragil() {
		return embalagemFragil;
	}

	public void setEmbalagemFragil(boolean embalagemFragil) {
		this.embalagemFragil = embalagemFragil;
	}
}
