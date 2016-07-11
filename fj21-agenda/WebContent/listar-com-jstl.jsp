<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>

	<jsp:useBean id="listacontatos"
		class="br.com.caelum.contato.ContatoDAO"></jsp:useBean>

	<table border="0">
		<thead>
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Email</td>
				<td>Endereco</td>
				<td>Data de Nascimento</td>
			</tr>
		</thead>
		</tbody>
		<c:forEach var="contatoindividual" items="${listacontatos.contatos}"
			varStatus="contador">
			<tr bgcolor="#${contador.count%2==0? 'aaee88' : 'ffffff' }">
				<td>${contatoindividual.id}</td>
				<td>${contatoindividual.nome}</td>
				<td><c:choose>
						<c:when test="${not empty contatoindividual.email }">
							<a href="mailto:${contatoindividual.email}">${contatoindividual.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não foi informado!
						</c:otherwise>
					</c:choose></td>
				<td>${contatoindividual.endereco}</td>
				<td>
					<fmt:formatDate value="${contatoindividual.dataDeNascimento.time}" pattern="dd/MM/yyyy"/>
				</td>				
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="rodape.jsp"></c:import>
</body>
</html>