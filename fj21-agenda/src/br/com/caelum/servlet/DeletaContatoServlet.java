package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.ConnectionFactory;
import br.com.caelum.contato.ContatoDAO;

@SuppressWarnings("serial")
public class DeletaContatoServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a Servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("Desligando a Servlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));

		try {
			Connection conn = new ConnectionFactory().getConnection();
			ContatoDAO dao = new ContatoDAO(conn);
			// dao.deletaContato(id);
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("Contato deletado com Sucesso!");
		out.println("</body>");
		out.println("</html>");

	}
}
