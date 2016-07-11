package br.com.caelum.contato;

import java.util.Calendar;
import java.util.List;

public class TesteCadastro {

	public static void main(String[] args) {
		testListaDeContatos();
	}

	public static void testCadastrar() {
		Contato contato = new Contato();
		ContatoDAO dao = new ContatoDAO();

		contato.setNome("José");
		contato.setEmail("jose@gmail.com");
		contato.setEndereco("25 de marco");
		contato.setDataDeNascimento(Calendar.getInstance());

		dao.adicionarContato(contato);
	}

	public static void buscarContatoPorNome() {
		ContatoDAO dao = new ContatoDAO();

		Contato contatoEncontrado = dao.buscarContatoPorNome("Daniel");

		System.out.println(contatoEncontrado);
	}

	public static void testListaDeContatos() {
		ContatoDAO dao = new ContatoDAO();

		List<Contato> contatos = dao.getContatos();

		for (Contato contato : contatos) {
			System.out.println(contato + "\n");
		}
	}

}
