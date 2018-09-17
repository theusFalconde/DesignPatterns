package com.edu.up.chain;

import com.edu.up.enumerator.FuncionarioValor;

public class GerenteGeral extends EmprestimoChain {

	public GerenteGeral() {
		super(FuncionarioValor.GERENTE_GERAL);
	}

	@Override
	protected void efetuaEmprestimo(double valor) {
		System.out.println("\nEmpréstimo de " + valor + " reais aprovado pelo " + funcionarioValor.getFuncao());
	}

}
