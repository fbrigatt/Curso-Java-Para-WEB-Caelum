package br.com.caelum.contato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDAO {
	private Connection conn = null;
	private List<Contato> contatos = new ArrayList<Contato>();

	public ContatoDAO(Connection conn) {
		this.conn = conn;
	}

	// ADICIONA NOVO CONTATO
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

	// BUSCA O CONTATO PELO SEU NOME
	public Contato buscarContatoPorNome(String nome) {
		String sql = "SELECT * FROM contatos WHERE nome = ?";
		Contato contatoEncontrado = null;

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, nome);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				contatoEncontrado = new Contato();

				contatoEncontrado.setNome(rs.getString("nome"));
				contatoEncontrado.setEmail(rs.getString("email"));
				contatoEncontrado.setEndereco(rs.getString("endereco"));
			}

			return contatoEncontrado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// ATUALIZA UM CONTATO
	public void atualizaContato(Contato contato) {
		String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataDeNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// DELETA UM CONTATO
	public void deletaContato(Contato contato) {
		String sql = "DELETE FROM contatos WHERE id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setLong(1, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// RETORNAR TODOS OS CONTATOS EM UMA LIST
	public List<Contato> getContatos() {
		String sql = "SELECT * FROM contatos";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contatoNovo = new Contato();

				contatoNovo.setId(rs.getLong("id"));
				contatoNovo.setNome(rs.getString("nome"));
				contatoNovo.setEmail(rs.getString("email"));
				contatoNovo.setEndereco(rs.getString("endereco"));

				if (rs.getDate("dataNascimento") != null) {
					Calendar dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(rs.getDate("dataNascimento"));
					contatoNovo.setDataDeNascimento(dataNascimento);
				}

				this.contatos.add(contatoNovo);
			}

			stmt.close();
			rs.close();

			return this.contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// BUSCA CONTATO POR ID
	public Contato buscaContatoPorID(long id) {
		String sql = "SELECT * FROM contatos WHERE id = ?";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setLong(1, id);

			ResultSet rs = ptmt.executeQuery();

			rs.next();

			Contato contatoEncontrado = new Contato();
			contatoEncontrado.setId(id);
			contatoEncontrado.setNome(rs.getString("nome"));
			contatoEncontrado.setEmail(rs.getString("email"));
			contatoEncontrado.setEndereco(rs.getString("endereco"));

			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(rs.getDate("dataNascimento"));
			contatoEncontrado.setDataDeNascimento(dataNascimento);

			ptmt.close();
			rs.close();
			return contatoEncontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
