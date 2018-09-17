package com.edu.up.observe;

import java.util.Date;

import com.edu.up.postagem.PostagemCorreiosObservavel;

public class ObservadorPostagem implements IObservadorPostagens {

	protected PostagemCorreiosObservavel postagemObservada;
	protected Date ultimaHoraPostagemConhecida;
	protected String ultimaOrigemConhecida;
	protected String ultimoDestinoConhecido;
	private String ultimaLocalidade;
	protected boolean ultimoEstadoEntrega;

	@Override
	public void setPostagemObservada(PostagemCorreiosObservavel postagemObservada) {
		this.postagemObservada = postagemObservada;
		this.atualizarDados();
	}

	@Override
	public void atualizar() {
		if (ultimaHoraPostagemConhecida != postagemObservada.getDataHoraPostagem()) {
			System.out.println("Por algum motivo a data e hora da postagem mudou para " + postagemObservada.getDataHoraPostagem());
		}
		if (!ultimaOrigemConhecida.equals(postagemObservada.getOrigem())) {
			System.out.println("Por algum motivo a origem mudou para " + postagemObservada.getOrigem());
		}
		if (!ultimoDestinoConhecido.equals(postagemObservada.getDestino())) {
			System.out.println("Por algum motivo o destino mudou para " + postagemObservada.getDestino());
		}
		if (!ultimaLocalidade.equals(postagemObservada.getUltimaLocalidade())) {
			System.out.println("Ultima localidade do produto: " + postagemObservada.getUltimaLocalidade());
		}
		if (ultimoEstadoEntrega != postagemObservada.isItemEntregue()) {
			if (postagemObservada.isItemEntregue() == true) {
				System.out.println("Sua encomenda foi entregue!");
			}
		}
		this.atualizarDados();
	}

	protected void atualizarDados() {
		this.ultimaHoraPostagemConhecida = postagemObservada.getDataHoraPostagem();
		this.ultimaOrigemConhecida = postagemObservada.getOrigem();
		this.ultimoDestinoConhecido = postagemObservada.getDestino();
		this.ultimaLocalidade = postagemObservada.getUltimaLocalidade();
		ultimoEstadoEntrega = postagemObservada.isItemEntregue();
	}

}
