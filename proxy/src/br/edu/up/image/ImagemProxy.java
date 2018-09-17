package br.edu.up.image;

public class ImagemProxy implements Grafico {
	private int altura;
	
	private int largura;
	
	private String caminho;
	
	private Imagem imagem;
	
	public ImagemProxy(String caminho) {
		this.caminho = caminho;
		this.altura = 0;
		this.largura = 0;
	}

	@Override
	public int getAltura() {
		if(imagem == null) {
			return altura;
		}
		return imagem.getAltura();
	}

	@Override
	public int getLargura() {
		if(imagem == null) {
			return largura;
		}
		return imagem.getLargura();
	}

	@Override
	public String getCaminho() {
		if(imagem == null) {
			return caminho;
		}
		return imagem.getCaminho();
	}

	@Override
	public void desenharImagem() {
		if(imagem == null) {
			imagem = new Imagem(caminho);
		}
		imagem.desenharImagem();
	}

}
