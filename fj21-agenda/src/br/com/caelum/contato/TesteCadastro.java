package br.com.caelum.contato;

import java.util.Calendar;

public class TesteCadastro {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Ricardo");
		contato.setEmail("ricardo@email.com.br");
		contato.setEndereco("Av Brasil");
		contato.setDataDeNascimento(Calendar.getInstance());

		ContatoDAO dao = new ContatoDAO();
		dao.adicionarContato(contato);

	}

}
