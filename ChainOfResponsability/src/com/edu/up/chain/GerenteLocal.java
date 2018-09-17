package com.edu.up.chain;

import com.edu.up.enumerator.FuncionarioValor;

public class GerenteLocal extends EmprestimoChain {

	public GerenteLocal() {
		super(FuncionarioValor.GERENTE_LOCAL);
	}

	@Override
	protected void efetuaEmprestimo(double valor) {
		System.out.println("\nEmpr�stimo de " + valor + " reais aprovado pelo " + funcionarioValor.getFuncao());
	}

}
