package br.edu.up.image;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Imagem implements Grafico {
	private int altura;

	private int largura;

	private String caminho;

	private BufferedImage img;

	public Imagem(String caminho) {
		this.caminho = caminho;
		carregarImagem();
	}

	public void carregarImagem() {
		try {
			img = ImageIO.read(new File(caminho));
			altura = img.getHeight();
			largura = img.getWidth();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao carregar a imagem!");
		}
	}

	@Override
	public int getAltura() {
		return altura;
	}

	@Override
	public int getLargura() {
		return largura;
	}

	@Override
	public String getCaminho() {
		return caminho;
	}

	@Override
	public void desenharImagem() {
		try {
			ImageIcon icon = new ImageIcon(img);
			JFrame frame = new JFrame();
			frame.setLayout(new FlowLayout());
			frame.setSize(largura, altura);
			JLabel lbl = new JLabel();
			lbl.setIcon(icon);
			frame.add(lbl);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao mostrar a imagem!");
		}
	}

}
