package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

	// Armazena em uma lista todos os contatos salvos no Banco de Dados
	public List<Contato> getLista() {
		String sql = "SELECT * FROM contatos";
		List<Contato> contatos = new ArrayList<Contato>();
		try {
			java.sql.PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato novoContato = new Contato();

				novoContato.setId(rs.getLong("id"));
				novoContato.setNome(rs.getString("nome"));
				novoContato.setEmail(rs.getString("email"));
				novoContato.setEndereco(rs.getString("endereco"));

				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				novoContato.setDataNascimento(dataNascimento);

				contatos.add(novoContato);
			}

			rs.close();
			stmt.close();
			conn.close();

			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public void alteraContato(Contato contato) {
		String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public void removeContato(Contato contato) {
		String sql = "DELETE FROM contatos WHERE id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
