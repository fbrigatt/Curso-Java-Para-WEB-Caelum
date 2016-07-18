package br.com.caelum.tarefas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TarefaDAO {
	Connection conn = null;

	public TarefaDAO(Connection conn) {
		this.conn = conn;
	}

	public void adcionaTarefa(Tarefa tarefa) {
		String sql = "INSERT INTO tarefas VALUES(0,?,?,?)";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			ptmt.setString(1, tarefa.getDescricao());
			ptmt.setBoolean(2, tarefa.isFinalizado());
			ptmt.setDate(3, null);

			ptmt.execute();
			ptmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
