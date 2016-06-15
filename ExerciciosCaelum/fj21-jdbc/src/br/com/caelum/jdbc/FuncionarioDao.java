package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
	Connection conn = null;

	public FuncionarioDao() {
		conn = new ConnectionFactory().getConnection();
	}

	public void adicionarFuncionario(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario VALUES (0,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());

			stmt.execute();

			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public List<Funcionario> getListaFuncionarios() {
		String sql = "SELECT * FROM funcionario";
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionarioAdicionado = new Funcionario();
				funcionarioAdicionado.setId(rs.getLong("id"));
				funcionarioAdicionado.setNome(rs.getString("nome"));
				funcionarioAdicionado.setUsuario(rs.getString("usuario"));
				funcionarioAdicionado.setSenha(rs.getString("senha"));

				funcionarios.add(funcionarioAdicionado);
			}

			stmt.close();
			rs.close();

			return funcionarios;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public void alteraFuncionario(Funcionario funcionario) {
		String sql = "UPDATE funcionario SET nome = ?, usuario = ?, senha = ? WHERE id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public void deletaFuncionario(Funcionario funcionario) {
		String sql = "DELETE FROM funcionario WHERE id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setLong(1, funcionario.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
