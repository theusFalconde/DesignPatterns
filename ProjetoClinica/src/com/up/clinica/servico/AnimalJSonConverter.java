package com.up.clinica.servico;

import com.up.clinica.model.Animal;

public class AnimalJSonConverter extends AbstractJsonConverter<Animal>{

	@Override
	public String getNomeObjeto() {
		return "animal";
	}

	@Override
	public String getNomeArray() {
		return "animais";
	}
}
