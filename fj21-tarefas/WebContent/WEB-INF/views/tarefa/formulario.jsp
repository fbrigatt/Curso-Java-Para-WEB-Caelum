<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Adicionar Tarefa</h3>
		<form action="adicionaTarefa" method="post">
			Descricao: <br />
			<textarea name="descricao" rows="5" cols="10"></textarea><br /> 
			<form:errors path="tarefa.descricao" cssStyle="color:red"></form:errors>
			<input type="submit" value="Adicionar Tarefa" />
		</form>
	</body>
</html>