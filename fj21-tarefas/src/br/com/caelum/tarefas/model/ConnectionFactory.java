package br.com.caelum.tarefas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String banco = "jdbc:mysql://localhost/fj21";
			String login = "root";
			String senha = "fatec";
			return DriverManager.getConnection(banco, login, senha);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
