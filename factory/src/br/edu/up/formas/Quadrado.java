package br.edu.up.formas;

import br.edu.up.interfaces.Forma;

public class Quadrado implements Forma {

	private int baseAltura;

	public Quadrado(int baseAltura) {
		this.baseAltura = baseAltura;
	}

	@Override
	public int getArea() {
		int area = baseAltura * baseAltura;
		return area;
	}

	public int getBaseAltura() {
		return baseAltura;
	}

	public void setBaseAltura(int baseAltura) {
		this.baseAltura = baseAltura;
	}

}
