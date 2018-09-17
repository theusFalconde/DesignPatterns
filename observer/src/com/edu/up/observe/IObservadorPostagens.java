package com.edu.up.observe;

import com.edu.up.postagem.PostagemCorreiosObservavel;

public interface IObservadorPostagens {
	public void atualizar();

	public void setPostagemObservada(PostagemCorreiosObservavel postagemObservada);
}
