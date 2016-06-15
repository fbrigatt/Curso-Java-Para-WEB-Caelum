package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.Contato;
import br.com.caelum.jdbc.ContatoDao;

public class TesteAltera {

	public static void main(String[] args) {
		Contato novoContato = new Contato();

		novoContato.setNome("Roberto");
		novoContato.setEmail("roberto@email.com.br");
		novoContato.setEndereco("Rua Marechal Rondon");
		novoContato.setDataNascimento(Calendar.getInstance());
		novoContato.setId(2);

		ContatoDao contatoDao = new ContatoDao();

		contatoDao.alteraContato(novoContato);

		System.out.println("Contato Alterado");
	}

}
