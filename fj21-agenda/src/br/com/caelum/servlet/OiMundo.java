package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class OiMundo extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a Servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo a Servlet");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<title>");
		out.println("Primeira Servlet");
		out.println("</title>");
		out.println("<body>");
		out.println("<h1> Ol� mundo Servlet </h1>");
		out.println("</body>");
		out.println("</html>");

	}

}
