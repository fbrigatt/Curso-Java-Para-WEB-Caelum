package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.Contato;
import br.com.caelum.contato.ContatoDAO;

@SuppressWarnings("serial")
public class AdicionaContatoServlet extends HttpServlet {
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
		ContatoDAO dao = new ContatoDAO();
		dao.adicionarContato(c1);

		out.println("<html>");
		out.println("<body>");
		out.println("Contato: " + c1.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}
