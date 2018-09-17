package br.edu.up.formas;

import br.edu.up.interfaces.Forma;

public class Triangulo implements Forma {
	
	private int base;
	
	private int altura;

	public Triangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public int getArea() {
		int area = (base * altura) / 2;
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
