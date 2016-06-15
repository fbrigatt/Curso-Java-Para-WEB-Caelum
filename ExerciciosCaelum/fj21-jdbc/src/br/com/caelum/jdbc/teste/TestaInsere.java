package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.Contato;
import br.com.caelum.jdbc.ContatoDao;

public class TestaInsere {

	public static void main(String[] args) {
		
		// Cria um novo objeto contato e insere seus atributos
		Contato c1 = new Contato();

		c1.setNome("Daniel");
		c1.setEmail("daniel.exatas@gmail.com");
		c1.setEndereco("Maestro Francisco Gaia");
		c1.setDataNascimento(Calendar.getInstance());
		
		// Cria um objeto da classe ContatoDao e cadastra no banco o contato criado anteriormente
		ContatoDao contatoDao = new ContatoDao();		
		contatoDao.adicionaContato(c1);
		
		System.out.println("Contato Cadastrado!");

	}

}
