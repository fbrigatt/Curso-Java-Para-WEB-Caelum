package br.com.caelum.jdbc;

import java.sql.*;

public class ContatoDao {
	Connection conn = null;

	// Cria a conexao ao instanciar o objeto
	public ContatoDao() {
		conn = new ConnectionFactory().getConnection();
	}

	// Adiciona um novo contato na tabela Contato do Banco de Dados
	public void adicionaContato(Contato contato) {
		String sql = "INSERT INTO contatos VALUES (0,?,?,?,?)";
		try {
			java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
