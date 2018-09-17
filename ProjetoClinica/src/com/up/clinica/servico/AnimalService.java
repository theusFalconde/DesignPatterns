package com.up.clinica.servico;

import javax.servlet.annotation.WebServlet;

import com.up.clinica.dal.AnimalDAO;
import com.up.clinica.dal.IGenericDAO;
import com.up.clinica.model.Animal;

@WebServlet(name = "GetAnimais", urlPatterns = { "/GetAnimais" })
public class AnimalService extends AbstractService<Animal, Long> {

	private static final long serialVersionUID = 1L;

	@Override
	protected IGenericDAO<Animal, Long> getDao() {
		return new AnimalDAO();
	}

	@Override
	protected IJSonConverter<Animal> getConverter() {
		return new AnimalJSonConverter();
	}

	@Override
	protected Long converterId(String idStr) {
		return Long.parseLong(idStr);
	}
}