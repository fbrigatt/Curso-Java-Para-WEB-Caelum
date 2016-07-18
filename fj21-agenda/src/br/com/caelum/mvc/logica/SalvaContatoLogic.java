package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.contato.Contato;
import br.com.caelum.contato.ContatoDAO;

public class SalvaContatoLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Contato contatoAlterado = new Contato();

		if (request.getParameter("id") != "") {
			contatoAlterado.setId(Long.parseLong(request.getParameter("id")));
		}

		contatoAlterado.setNome(request.getParameter("nome"));
		contatoAlterado.setEmail(request.getParameter("email"));
		contatoAlterado.setEndereco(request.getParameter("endereco"));

		Calendar dataNascimento = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse(request.getParameter("dataNascimento"));
		dataNascimento.setTime(data);
		contatoAlterado.setDataDeNascimento(dataNascimento);

		Connection conn = (Connection) request.getAttribute("connection");
		ContatoDAO dao = new ContatoDAO(conn);

		if (request.getParameter("id") == "") {
			dao.adicionarContato(contatoAlterado);
		} else {
			dao.atualizaContato(contatoAlterado);
		}
		return "mvc?logica=ListaContatosLogic";
	}
}
