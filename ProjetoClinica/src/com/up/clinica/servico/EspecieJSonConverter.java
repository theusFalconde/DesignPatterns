package com.up.clinica.servico;

import com.up.clinica.model.Especie;

public class EspecieJSonConverter extends AbstractJsonConverter<Especie>{

	@Override
	public String getNomeObjeto() {
		return "especie";
	}

	@Override
	public String getNomeArray() {
		return "especies";
	}
}