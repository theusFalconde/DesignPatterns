package com.up.clinica.servico;

import java.util.List;

public interface IJSonConverter<T> {
	
	public String convertToJson(List<T> lista);
	
	public String convertToJson(T objeto);
}
