package br.com.caelum.jdbc;

public class Funcionario {
	private long id;
	private String nome;
	private String usuario;
	private String senha;

	// GET
	public long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public String getSenha() {
		return this.senha;
	}

	// SET
	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
