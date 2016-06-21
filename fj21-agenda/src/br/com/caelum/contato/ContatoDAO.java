package br.com.caelum.contato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class ContatoDAO {
	Connection conn = null;

	public ContatoDAO() {
		conn = new ConnectionFactory().getConnection();
	}

	public void adicionarContato(Contato contato) {
		String sql = "INSERT INTO contatos VALUES (0,?,?,?,?)";
		try {
			java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataDeNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
