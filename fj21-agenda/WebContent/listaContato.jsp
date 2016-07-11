<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="br.com.caelum.contato.ContatoDAO, br.com.caelum.contato.Contato, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contato</title>
</head>
<body>
	<%
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getContatos();

		for (Contato contato : contatos) {
			
	%>
	<li>
		<label>Nome:</label> <%=contato.getNome()%><br/>
		<label>Email:</label> <%=contato.getEmail()%><br/>
		<label>Endereco:</label> <%=contato.getEndereco()%><br/>
	</li>
	<br/>
	<%
		}
	%>
</body>
</html>