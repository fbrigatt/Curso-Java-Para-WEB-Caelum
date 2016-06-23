package br.com.caelum.contato;

public class TesteCadastro {

	public static void main(String[] args) {
		Contato contato = new Contato();
		ContatoDAO dao = new ContatoDAO();

		contato = dao.buscarContatoPorNome("natalia");

		System.out.println("ID: " + contato.getId());
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endereco: " + contato.getEndereco());
	}

}
