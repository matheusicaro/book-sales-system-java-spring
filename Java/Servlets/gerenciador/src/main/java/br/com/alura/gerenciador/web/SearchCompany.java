package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/search")
public class SearchCompany extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    PrintWriter writer = resp.getWriter();
	    writer.println("<html><body>");
	    writer.println("Resultado da busca:<br/>");
	    
	    String filter = req.getParameter("filter");
	    Collection<Empresa> companies = new EmpresaDAO()
	            .buscaPorSimilaridade(filter);

	    writer.println("<ul>");
	    for (Empresa company : companies) {
	        writer.println("<li>" + company.getId() + ": " + company.getNome() + "</li>");
	    }
	    writer.println("</ul>");
	    
	    writer.println("</html></body>");
	}
}
