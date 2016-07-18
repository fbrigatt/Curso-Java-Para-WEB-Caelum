package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@SuppressWarnings("serial")
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	@SuppressWarnings("rawtypes")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeDaClasse = "br.com.caelum.mvc.logica." + request.getParameter("logica");

		try {
			Class classe = Class.forName(nomeDaClasse);

			Logica iServlet = (Logica) classe.newInstance();
			String proximaPagina = iServlet.executa(request, response);

			request.getRequestDispatcher(proximaPagina).forward(request, response);

		} catch (Exception e) {
			throw new ServletException("Erro na lógica de negócios", e);
		}

	}
}
