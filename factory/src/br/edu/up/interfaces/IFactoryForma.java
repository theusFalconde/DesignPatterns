package br.edu.up.interfaces;

import br.edu.up.enums.EnumForma;

public interface IFactoryForma {
	public Forma criarForma(EnumForma forma, int... props) throws Exception;
}
