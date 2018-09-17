package com.up.clinica.servico;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.clinica.dal.IGenericDAO;

public abstract class AbstractService<T,U> extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected final void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("application/json;charset=UTF-8");
			ServletOutputStream out = response.getOutputStream();
			
			IGenericDAO<T,U> dao = getDao();
			String idStr = request.getParameter("id");
			String output;
			IJSonConverter<T> converter = getConverter();
			
			if(idStr == null) {
				output = converter.convertToJson(dao.listar());
			}else {
				U id = converterId(idStr);
				output = converter.convertToJson(dao.buscar(id));
			}
			out.print(output);
		} catch (Exception e) {
			response.sendError(500);//Internal server error
			e.printStackTrace();//TODO: Logar
		}
	}
	
	protected abstract IGenericDAO<T,U> getDao();
	protected abstract IJSonConverter<T> getConverter();
	protected abstract U converterId(String idStr);
}