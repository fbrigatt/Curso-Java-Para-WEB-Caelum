package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.Contato;
import br.com.caelum.contato.ContatoDAO;

@SuppressWarnings("serial")
public class ConsultaContatoServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a Servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo a Servlet");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Contato contato = null;
		ContatoDAO dao = new ContatoDAO();

		contato = dao.buscarContatoPorNome(request.getParameter("nome"));

		out.println("<html>");
		out.println("<body>");
		out.println("<br>Nome: " + contato.getNome());
		out.println("<br>Email: " + contato.getEmail());
		out.println("<br>Endereco: " + contato.getEndereco());
		out.println("</body>");
		out.println("</html>");
	}

}
