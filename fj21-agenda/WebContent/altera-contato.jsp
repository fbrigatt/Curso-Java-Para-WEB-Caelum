<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
			<form action="/fj21-agenda/mvc">
				<input type="hidden" name="logica" value="SalvaContatoLogic"/>
				<input type="hidden" name="id" value="${contato.id }"/>
				Nome: <input type="text" name="nome" value = "${contato.nome }"/> <br/>
				Email: <input type="text" name="email" value="${contato.email }"/> <br/>
				Endereco: <input type="text" name="endereco" value="${contato.endereco }"/> <br/>
				
				<fmt:formatDate value="${contato.dataDeNascimento.time }" pattern="dd/MM/yyyy" var="dataDeNascimento"/>
				Data de Nascimento:<input type="text" name="dataNascimento" value="${dataDeNascimento}"/> <br/>
				
				<input type="submit" value="Salvar"/>
			</form>
		<c:import url="rodape.jsp"></c:import>
	</body>
</html>