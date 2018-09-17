package br.edu.up;

import java.util.Scanner;

import br.edu.up.enums.EnumForma;
import br.edu.up.factory.FactoryForma;
import br.edu.up.interfaces.Forma;
import br.edu.up.interfaces.IFactoryForma;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			IFactoryForma factory = new FactoryForma();
			criarTitulo();
			criarMenu();
			int numForma = getValorSelecionado(scan, "Digite o numero da forma que deseja criar: ");
			String formaSelecionada = numForma == 1 ? "Quadrado" : numForma == 2 ? "Retangulo" : "Triangulo";
			EnumForma eForma = EnumForma.toEnum(numForma);
			int[] props = new int[2];
			if(eForma == EnumForma.RETANGULO || eForma == EnumForma.TRIANGULO) {
				System.out.println();
				props[0] = getValorSelecionado(scan, "Digite o valor da base: ");
				System.out.println();
				props[1] = getValorSelecionado(scan, "Digite o valor da altura: ");
			} else {
				System.out.println();
				props[0] = getValorSelecionado(scan, "Digite o valor da base: ");
			}
			Forma forma = factory.criarForma(eForma, props);
			System.out.println();
			System.out.printf("A forma criado foi: %s e a area e de: %s", formaSelecionada, forma.getArea());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int getValorSelecionado(Scanner scan, String mensagem) {
		int numForma = -1;
		do {
			try {
				System.out.print(mensagem);
				numForma = Integer.parseInt(scan.nextLine());
				return numForma;
			} catch (Exception e) {
				System.out.println();
				System.out.println("Valor Inválido! Tente novamente!");
				System.out.println();
			}
		} while(true);
	}
	
	public static void criarMenu() {
		System.out.println("1 - Quadrado");
		System.out.println("2 - Retangulo");
		System.out.println("3 - Triangulo");
		System.out.println();
	}
	
	public static void criarTitulo() {
		System.out.println("Seja Bem-Vindo a Fábrica de Formas");
		System.out.println();
	}
}
