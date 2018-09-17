package com.up.clinica.servico;

import com.up.clinica.model.TipoAnimal;

public class TipoAnimalJSonConverter extends AbstractJsonConverter<TipoAnimal>{

	@Override
	public String getNomeObjeto() {
		return "tipoAnimal";
	}

	@Override
	public String getNomeArray() {
		return "tiposAnimal";
	}
}