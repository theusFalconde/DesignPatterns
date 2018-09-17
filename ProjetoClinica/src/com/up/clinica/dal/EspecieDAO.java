package com.up.clinica.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.up.clinica.model.Connection;
import com.up.clinica.model.Especie;

public class EspecieDAO extends AbstractDAO<Especie, Long>{
	
	public void removerComRelacionamentos(Long idEspecie) throws Exception{
		Connection con = null;
		PreparedStatement statementEspecie = null;
		PreparedStatement statementAnimal = null;
		Exception ultimaExcecao = null;

		try {
			con = Connection.getInstance();
			con.setAutoCommit(false);
			
			statementAnimal = con.prepareStatement("DELETE FROM "
					+ "ANIMAL WHERE especie_id=?");
			statementAnimal.setLong(1, idEspecie);
			statementAnimal.executeUpdate();
			
			statementEspecie = con.prepareStatement("DELETE FROM "
					+ "ESPECIE WHERE id=?");
			statementEspecie.setLong(1, idEspecie);
			statementEspecie.executeUpdate();
			
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
				if (con != null)
					con.close();
			} catch (Exception e) {
				ultimaExcecao = e;
			}
		}
		throw ultimaExcecao;
	}
	
	@Override
	protected void carregarChavesGeradasNoObjeto(ResultSet generatedKeys, Especie objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PreparedStatement criarStatementPersistir(Connection conexao, Especie objeto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement criarStatementListar(Connection conexao) throws Exception {
		return conexao.prepareStatement("select id,nome,descricao from especie");
	}

	@Override
	protected Especie parseObjeto(ResultSet rs) throws Exception {
		Especie e = new Especie();
		e.setId(rs.getLong(1));
		e.setNome(rs.getString(2));
		e.setDescricao(rs.getString(3));
		
		return e;
	}

	@Override
	protected PreparedStatement criarStatementBuscar(Connection conexao, Long id) throws Exception {
		PreparedStatement statement = conexao.prepareStatement("select id,nome,descricao from especie where id = ?");
		statement.setLong(1, id);
		return statement;
	}

	@Override
	protected PreparedStatement criarStatementAtualizar(Connection conexao, Especie objeto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement criarStatementRemover(Connection conexao, Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
