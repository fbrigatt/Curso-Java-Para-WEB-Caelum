<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="br.com.caelum.contato.ContatoDAO, br.com.caelum.contato.Contato, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
		<thead>
			<tr>
				<td> Nome </td>
				<td> Email </td>
				<td> Endereco </td>
			</tr>
		</thead>
		
		<tbody>
	<%
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getContatos();

		for (Contato contatoAtual : contatos) {
	%>
		<tr>
			<td> <%=contatoAtual.getNome() %> </td>
			<td> <%=contatoAtual.getEmail() %></td>
			<td> <%=contatoAtual.getEndereco() %><td>
		</tr>
	
	<%
		}
	%>	
		</tbody>
	</table>
</body>
</html>