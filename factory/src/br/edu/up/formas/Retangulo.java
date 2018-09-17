package br.edu.up.formas;

import br.edu.up.interfaces.Forma;

public class Retangulo implements Forma {

	private int base;

	private int altura;
	
	public Retangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public int getArea() {
		int area = base * altura;
		return area;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
}
