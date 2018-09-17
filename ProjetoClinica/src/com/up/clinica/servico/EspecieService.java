package com.up.clinica.servico;

import javax.servlet.annotation.WebServlet;

import com.up.clinica.dal.EspecieDAO;
import com.up.clinica.dal.IGenericDAO;
import com.up.clinica.model.Especie;

@WebServlet(name = "GetEspecies", urlPatterns = { "/GetEspecies" })
public class EspecieService extends AbstractService<Especie, Long>{

	private static final long serialVersionUID = 1L;

	@Override
	protected IGenericDAO<Especie, Long> getDao() {
		return new EspecieDAO();
	}

	@Override
	protected IJSonConverter<Especie> getConverter() {
		return new EspecieJSonConverter();
	}

	@Override
	protected Long converterId(String idStr) {
		return Long.parseLong(idStr);
	}
}