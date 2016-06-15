package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.Contato;
import br.com.caelum.jdbc.ContatoDao;

public class TesteDeleta {

	public static void main(String[] args) {
		Contato contatoDeletado = new Contato();

		contatoDeletado.setNome("Daniel");
		contatoDeletado.setEmail("daniel.exatas@gmail.com");
		contatoDeletado.setEndereco("Maestro Francisco Gaia");
		contatoDeletado.setDataNascimento(Calendar.getInstance());
		contatoDeletado.setId(1);

		ContatoDao contatoDao = new ContatoDao();

		contatoDao.removeContato(contatoDeletado);

		System.out.println("Contato Deletado");

	}

}
