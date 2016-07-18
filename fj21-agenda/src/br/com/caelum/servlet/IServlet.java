package br.com.caelum.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServlet {
	String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
