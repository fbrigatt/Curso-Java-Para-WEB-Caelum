package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.Contato;
import br.com.caelum.contato.ContatoDAO;

public class RemoveContatoLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");

		Contato contatoRemovido = new Contato();
		contatoRemovido.setId(Long.parseLong(id));

		Connection conn = (Connection) request.getAttribute("connection");

		ContatoDAO dao = new ContatoDAO(conn);
		dao.deletaContato(contatoRemovido);

		return "mvc?logica=ListaContatosLogic";
	}
}
