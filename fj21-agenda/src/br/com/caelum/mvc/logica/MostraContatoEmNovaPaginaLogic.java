package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.Contato;
import br.com.caelum.contato.ContatoDAO;

public class MostraContatoEmNovaPaginaLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		if (request.getParameter("id")!=null){
			long id = Long.parseLong(request.getParameter("id"));
			
			Connection conn = (Connection) request.getAttribute("connection");
			Contato contatoEncontrado = new ContatoDAO(conn).buscaContatoPorID(id);
			request.setAttribute("contato", contatoEncontrado);
		}
		
		return "altera-contato.jsp";
	}
}
