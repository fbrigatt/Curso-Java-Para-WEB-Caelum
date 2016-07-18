package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.Contato;
import br.com.caelum.contato.ContatoDAO;

public class ListaContatosLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = (Connection) request.getAttribute("connection");
		List<Contato> contatos = new ContatoDAO(conn).getContatos();

		request.setAttribute("contatos", contatos);

		return "lista-contatos.jsp";
	}
}
