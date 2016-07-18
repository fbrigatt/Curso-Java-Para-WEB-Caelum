package br.com.caelum.contato;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class TesteCadastro {

	public static void main(String[] args) {
		testBuscaPorID();
	}

	public static void testCadastrar() {
		try {
			Contato contato = new Contato();
			Connection conn = new ConnectionFactory().getConnection();
			ContatoDAO dao = new ContatoDAO(conn);

			contato.setNome("José");
			contato.setEmail("jose@gmail.com");
			contato.setEndereco("25 de marco");
			contato.setDataDeNascimento(Calendar.getInstance());

			dao.adicionarContato(contato);
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void buscarContatoPorNome() {
		try {
			Connection conn = new ConnectionFactory().getConnection();
			ContatoDAO dao = new ContatoDAO(conn);

			Contato contatoEncontrado = dao.buscarContatoPorNome("Daniel");

			System.out.println(contatoEncontrado);
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void testListaDeContatos() {
		List<Contato> contatos;
		try {
			Connection conn = new ConnectionFactory().getConnection();
			ContatoDAO dao = new ContatoDAO(conn);

			contatos = dao.getContatos();

			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		for (Contato contato : contatos) {
			System.out.println(contato + "\n");
		}
	}

	public static void testBuscaPorID() {
		Contato contatoEncontrado;
		try {
			Connection conn = new ConnectionFactory().getConnection();
			ContatoDAO dao = new ContatoDAO(conn);
			contatoEncontrado = new Contato();

			contatoEncontrado = dao.buscaContatoPorID(5);

			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println(contatoEncontrado);
	}

}
