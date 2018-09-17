package com.edu.up.chain;

import com.edu.up.enumerator.FuncionarioValor;

public class Caixa extends EmprestimoChain {

	public Caixa() {
		super(FuncionarioValor.CAIXA);
	}

	@Override
	protected void efetuaEmprestimo(double valor) {
		System.out.println("\nEmpréstimo de " + valor + " reais aprovado pelo " + funcionarioValor.getFuncao());
	}

}
