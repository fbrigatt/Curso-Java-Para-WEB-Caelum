<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link href="css/jquery-ui.css" rel="stylesheet">
	<link href="css/jquery-ui.min.css" rel="stylesheet">
	<link href="css/jquery-ui.structure.css" rel="stylesheet">
	<link href="css/jquery-ui.structure.min.css" rel="stylesheet">
	<link href="css/jquery-ui.theme.css" rel="stylesheet">
	<link href="css/jquery-ui.theme.min.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
		<form action="adicionaContato">
			Nome: <input type = "text" name="nome" value = ""/><br/>
			Email: <input type = "text" name="email" value=""/><br/>
			Endereco: <input type = "text" name="endereco" value=""/><br/>
			Data de Nascimento <caelum:campoData id="dataNascimento"/><br/>
			<input type = "submit" value = "Gravar Contato"/>
		</form>
	<c:import url="rodape.jsp"/>
</body>
</html>