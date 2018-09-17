package com.up.clinica.model;

import java.sql.SQLException;
import java.util.Properties;

import org.hsqldb.SessionInterface;
import org.hsqldb.jdbc.JDBCConnection;
import org.hsqldb.jdbc.JDBCConnectionEventListener;
import org.hsqldb.jdbc.JDBCDriver;
import org.hsqldb.persist.HsqlProperties;

// Nome da Classe alterado para Connection, pois agora ela é a conexão e não mais uma fábrica de conexões
// Herdamos da classe JDBCConnection que é responsável por realizar a conexão com o BD
public class Connection extends JDBCConnection {
	
	// Atributo que vai ser utilizado como unica instancia
	private static Connection instance = null;

	// Metodo responsável por carregar o Driver JDBC
	static {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private Connection(JDBCConnection c) throws SQLException {
		super(c.getSession());
	}
	
	// Sobrecarregando o construtor da classe JDBCConnection e o tornando privado
	private Connection(HsqlProperties props) throws SQLException {
		super(props);
	}
	
	// Sobrecarregando o construtor da classe JDBCConnection e o tornando privado
	private Connection(SessionInterface c) throws SQLException {
		super(c);
	}
	
	// Sobrecarregando o construtor da classe JDBCConnection e o tornando privado
	private Connection(JDBCConnection c, JDBCConnectionEventListener eventListener) throws SQLException {
		super(c, eventListener);
	}

	// Método responsável por distribuir apenas uma conexão, padrão singleton
	public static Connection getInstance() {
		if(instance == null) {
			instance = (Connection) createConnection();
		}
		return instance;
	}
	
	// Metodo responsável por criar a conexão com o BD
	private static Connection createConnection() {
		try {
			// Criando as propriedades necessárias para realizar a conexão com o BD
			Properties props = new Properties();
			props.put("user", "SA");
			props.put("passwords", "");
			// Utilizando o construtor privado criamos um instancia da conexão
			return new Connection((JDBCConnection) JDBCDriver.getConnection("jdbc:hsqldb:hsql://localhost/clinicaveterinariadb", props));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}