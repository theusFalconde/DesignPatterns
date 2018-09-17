package com.edu.up;

import java.util.Scanner;

import com.edu.up.chain.Caixa;
import com.edu.up.chain.EmprestimoChain;
import com.edu.up.chain.GerenteGeral;
import com.edu.up.chain.GerenteLocal;
import com.edu.up.chain.GerenteRegional;

public class Main {
	public static void main(String[] args) {
		EmprestimoChain emprestimo = new Caixa();
		emprestimo.setProximo(new GerenteLocal());
		emprestimo.setProximo(new GerenteRegional());
		emprestimo.setProximo(new GerenteGeral());
		Scanner scan = new Scanner(System.in);
		System.out.println("Seja Bem-Vindo ao Banco!");
		String sair = "";
		do {
			boolean correto = false;
			double valor = 0d;
			do {
				try {
					System.out.print("\nDigite o valor do emprestimo: ");
					valor = Double.parseDouble(scan.nextLine());
					correto = true;
				} catch (Exception e) {
					System.out.println("\nHouve um erro! Tente novamente!\n");
				}
			} while (!correto);
			emprestimo.efetuarEmprestimo(valor);
			System.out.print("\nDeseja realizar um novo emprestimo? S/N: ");
			sair = scan.nextLine();
			if(sair.equals("n") || sair.equals("N")) {
				break;
			}
		} while (true);
		System.out.println("\nObrigado por utilizar os serviços do Banco!");
	}
}
