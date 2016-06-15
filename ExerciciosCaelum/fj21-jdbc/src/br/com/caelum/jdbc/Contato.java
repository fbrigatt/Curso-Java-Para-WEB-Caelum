package br.com.caelum.jdbc;

import java.util.Calendar;

public class Contato {
	private long id;
	private String nome;
	private String endereco;
	private String email;
	private Calendar dataNascimento;

	// GET
	public long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public String getEmail() {
		return this.email;
	}

	public Calendar getDataNascimento() {
		return this.dataNascimento;
	}

	// SET
	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
