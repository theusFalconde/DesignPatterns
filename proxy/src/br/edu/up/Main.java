package br.edu.up;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.edu.up.image.Grafico;
import br.edu.up.image.ImagemProxy;
import br.edu.up.util.FileFilterUtils;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Seja Bem-Vindo ao Vizualizador de Imagens Com Proxy");
			System.out.println();
			System.out.print("Digite o caminho do diretório das imagens: ");
			String caminho = scan.nextLine();
			List<Grafico> list = selecionaImagemDiretorio(caminho);
			selecionarImagemExibir(scan, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void selecionarImagemExibir(Scanner scan, List<Grafico> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(" " + i + " - " + list.get(i).getCaminho());
		}
		boolean correto = false;
		int index = -1;
		do {
			System.out.print("Selecione a imagem a ser exibida: ");
			try {
				index = Integer.parseInt(scan.nextLine());
				correto = true;
				if(index < 0 && index > list.size()) {
					correto = false;
				}
			} catch (Exception e) {
				System.err.println("O valor digitado não está disponível");
			}			
		} while(!correto);
		Grafico grafico = list.get(index);
		grafico.desenharImagem();
		System.out.println("Caminho da imagem:" + grafico.getCaminho());
		System.out.println("Altura da imagem:" + grafico.getAltura());
		System.out.println("Largura da imagem:" + grafico.getLargura());
	}
	
	public static List<Grafico> selecionaImagemDiretorio(String directory) {
		File[] files = FileFilterUtils.listImages(directory);
		if(files == null) {
			return null;
		}
		List<Grafico> list = Stream.of(files).map(f -> new ImagemProxy(f.getAbsolutePath())).collect(Collectors.toList());
		return list;
	}
}
