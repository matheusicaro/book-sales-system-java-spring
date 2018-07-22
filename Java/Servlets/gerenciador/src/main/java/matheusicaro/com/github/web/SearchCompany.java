package matheusicaro.com.github.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matheusicaro.com.github.dao.CompanyDAO;
import matheusicaro.com.github.manager.Company;

public class SearchCompany implements Task {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

	    String filter = req.getParameter("filter");
	    
	    Collection<Company> companies = new CompanyDAO()
	            .buscaPorSimilaridade(filter);
	    
	    req.setAttribute("companies", companies);
        
	    return "/WEB-INF/pages/SearchCompany.jsp";
	}

}
