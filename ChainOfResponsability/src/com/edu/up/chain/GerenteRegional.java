package com.edu.up.chain;

import com.edu.up.enumerator.FuncionarioValor;

public class GerenteRegional extends EmprestimoChain {

	public GerenteRegional() {
		super(FuncionarioValor.GERENTE_REGIONAL);
	}

	@Override
	protected void efetuaEmprestimo(double valor) {
		System.out.println("\nEmpr�stimo de " + valor + " reais aprovado pelo " + funcionarioValor.getFuncao());
	}

}
