<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="contato1" class="br.com.caelum.contato.Contato"></jsp:useBean>
	<%-- Primeira página JSP --%>
	<%
		String mensagem = "Bem Vindo!";
		out.println(mensagem);
	%>
	<br />

	<%-- Desenvolvido por --%>
	<%
		String desenvolvido = "Desenvolvido por Daniel Freitas";
	%>
	<%=desenvolvido%>
	<br />

	<%
		System.out.println("Tudo foi executado!");
	%>
</body>
</html>