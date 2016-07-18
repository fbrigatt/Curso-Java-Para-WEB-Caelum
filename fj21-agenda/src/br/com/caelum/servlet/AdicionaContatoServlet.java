package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.ConnectionFactory;
import br.com.caelum.contato.Contato;
import br.com.caelum.contato.ContatoDAO;

@SuppressWarnings("serial")
public class AdicionaContatoServlet extends HttpServlet implements IServlet {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return null;
	}

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

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataDeNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataDeNascimento = Calendar.getInstance();
			dataDeNascimento.setTime(date);
		} catch (java.text.ParseException e) {
			out.println("Erro de conversão de data");
			return;
		}

		// Monta objeto Contato
		Contato c1 = new Contato();
		c1.setNome(nome);
		c1.setEmail(email);
		c1.setEndereco(endereco);
		c1.setDataDeNascimento(dataDeNascimento);

		// Salva o contato
		try {
			Connection conn = new ConnectionFactory().getConnection();
			ContatoDAO dao = new ContatoDAO(conn);
			dao.adicionarContato(c1);
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		RequestDispatcher rd = request.getRequestDispatcher("contato-adicionado.jsp");
		rd.forward(request, response);
	}

}
