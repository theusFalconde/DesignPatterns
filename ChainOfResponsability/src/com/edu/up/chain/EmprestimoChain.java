package com.edu.up.chain;

import com.edu.up.enumerator.FuncionarioValor;

public abstract class EmprestimoChain {

	protected EmprestimoChain proximo;

	protected FuncionarioValor funcionarioValor;

	public EmprestimoChain(FuncionarioValor funcionarioValor) {
		this.proximo = null;
		this.funcionarioValor = funcionarioValor;
	}

	public void setProximo(EmprestimoChain proximo) {
		if (this.proximo == null) {
			this.proximo = proximo;
		} else {
			this.proximo.setProximo(proximo);
		}
	}
	
	public void efetuarEmprestimo(double valor){
		if(podeEfetuarEmprestimo(valor)) {
			efetuaEmprestimo(valor);
		} else {
			if(proximo == null) {
				System.out.println("Não foi possível realizar o empréstimo para o valor solicitado!");
				return;
			}
			proximo.efetuarEmprestimo(valor);
		}
	}

	private boolean podeEfetuarEmprestimo(double valor) {
		if (funcionarioValor != null && valor != 0d && valor >= funcionarioValor.getMinValor() && valor <= funcionarioValor.getMaxValor()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected abstract void efetuaEmprestimo(double valor);
}
