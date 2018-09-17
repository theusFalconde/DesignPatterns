package com.edu.up.enumerator;

public enum FuncionarioValor {
	CAIXA(1d, 500d, "Caixa do Banco"), GERENTE_LOCAL(500d, 10000d, "Gerente Local do Banco"), GERENTE_REGIONAL(10000d, 50000d, "Gerente Regional do Banco"), GERENTE_GERAL(50000d, 100000d, "Gerente Geral do Banco");
	
	private double minValor;
	
	private double maxValor;
	
	private String funcao;
	
	private FuncionarioValor(double minValor, double maxValor, String funcao) {
		this.minValor = minValor;
		this.maxValor = maxValor;
		this.funcao = funcao;
	}

	public double getMinValor() {
		return minValor;
	}

	public double getMaxValor() {
		return maxValor;
	}

	public String getFuncao() {
		return funcao;
	}
}
