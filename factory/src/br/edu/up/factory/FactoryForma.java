package br.edu.up.factory;

import br.edu.up.enums.EnumForma;
import br.edu.up.formas.Quadrado;
import br.edu.up.formas.Retangulo;
import br.edu.up.formas.Triangulo;
import br.edu.up.interfaces.Forma;
import br.edu.up.interfaces.IFactoryForma;

public class FactoryForma implements IFactoryForma {

	@Override
	public Forma criarForma(EnumForma forma, int... props) throws Exception {
		switch (forma) {
			case QUADRADO:
				return new Quadrado(props[0]);
			case RETANGULO:
				return new Retangulo(props[0], props[1]);
			case TRIANGULO:
				return new Triangulo(props[0], props[1]);
			default: 
				throw new Exception("Tipo de documento ou Propriedades da Forma Inválidos");
		}
	}

}
