package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.Contato;
import br.com.caelum.jdbc.ContatoDao;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao contatoDao = new ContatoDao();

		List<Contato> contatos = contatoDao.getLista();

		for (Contato contatoAtual : contatos) {
			System.out.println("Nome: " + contatoAtual.getNome());
			System.out.println("Email: " + contatoAtual.getEmail());
			System.out.println("Endereco: " + contatoAtual.getEndereco());
			SimpleDateFormat formatoData = new SimpleDateFormat("DD/MM/YYYY");

			System.out.println("Data de Nascimento: " + formatoData.format(contatoAtual.getDataNascimento().getTime()));
		}

	}

}
