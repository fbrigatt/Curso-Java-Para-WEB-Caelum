package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.ConnectionFactory;
import br.com.caelum.contato.Contato;
import br.com.caelum.contato.ContatoDAO;

@SuppressWarnings("serial")
public class AtualizaContatoServlet extends HttpServlet {

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

		PrintWriter out = response.getWriter();

		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");

		Calendar dataNascimento = null;

		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			out.println("Erro na conversão da Data");
		}

		try {
			Contato contatoAlterado = new Contato();
			Connection conn = (Connection) new ConnectionFactory().getConnection();
			ContatoDAO dao = new ContatoDAO(conn);

			contatoAlterado.setId(id);
			contatoAlterado.setNome(nome);
			contatoAlterado.setEmail(email);
			contatoAlterado.setEndereco(endereco);
			contatoAlterado.setDataDeNascimento(dataNascimento);

			dao.atualizaContato(contatoAlterado);

			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		out.println("<html>");
		out.println("<body>");
		out.println("Contato Alterado com Sucesso!");
		out.println("</body>");
		out.println("</html>");
	}
}
