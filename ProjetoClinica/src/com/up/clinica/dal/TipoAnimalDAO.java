package com.up.clinica.dal;

import java.sql.PreparedStatement;
import java.util.List;

import com.up.clinica.model.Connection;
import com.up.clinica.model.TipoAnimal;

public class TipoAnimalDAO implements IGenericDAO<TipoAnimal, String>{

	@Override
	public List<TipoAnimal> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoAnimal buscar(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String id) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void atualizar(TipoAnimal objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistir(TipoAnimal objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void removerComRelacionamentos(String acronimoTipoAnimal) throws Exception{
		Connection con = null;
		PreparedStatement statementEspecie = null;
		PreparedStatement statementAnimal = null;
		PreparedStatement statementTipo = null;
		Exception ultimaExcecao = null;

		try {
			con = Connection.getInstance();
			con.setAutoCommit(false);
			
			statementAnimal = con.prepareStatement("DELETE FROM ANIMAL WHERE especie_id IN "
					+ " (SELECT id from especie where tipo_animal_acronimo = ?)");
			statementAnimal.setString(1, acronimoTipoAnimal);
			statementAnimal.executeUpdate();
			
			statementEspecie = con.prepareStatement("DELETE FROM "
					+ "ESPECIE WHERE tipo_animal_acronimo = ?");
			statementEspecie.setString(1, acronimoTipoAnimal);
			statementEspecie.executeUpdate();
			
			statementTipo = con.prepareStatement("DELETE FROM tipo_animal WHERE acronimo = ?");
			statementTipo.setString(1, acronimoTipoAnimal);
			statementTipo.executeUpdate();
			
			con.commit();
			return;
		} catch (Exception e) {
			if(con!=null)
				con.rollback();
			ultimaExcecao = e;
		} finally {
			try {
				if (statementAnimal != null)
					statementAnimal.close();
			} catch (Exception e) {
				ultimaExcecao = e;
			}
			try {
				if (statementEspecie != null)
					statementEspecie.close();
			} catch (Exception e) {
				ultimaExcecao = e;
			}
			try {
				if (statementTipo != null)
					statementTipo.close();
			} catch (Exception e) {
				ultimaExcecao = e;
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				ultimaExcecao = e;
			}
		}
		throw ultimaExcecao;
	}
}
