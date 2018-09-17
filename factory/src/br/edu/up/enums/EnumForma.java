package br.edu.up.enums;

public enum EnumForma {
	QUADRADO(1), RETANGULO(2), TRIANGULO(3);
	
	private int chave;

	private EnumForma(int chave) {
		this.chave = chave;
	}
	
	public static EnumForma toEnum(int chave) throws Exception {
		for (EnumForma e : values()) {
            if(e.chave == chave) {
            	return e;
            }
        }
		throw new Exception("Forma não encontrada!");
	}
}
