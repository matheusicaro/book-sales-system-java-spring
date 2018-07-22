package matheusicaro.com.github.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matheusicaro.com.github.dao.CompanyDAO;
import matheusicaro.com.github.gerenciador.Company;

public class NewCompany implements Task {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

        String name = req.getParameter("name");
        Company company = new Company(name);
        new CompanyDAO().add(company);

        req.setAttribute("name", name);
        
		return "/WEB-INF/pages/NewCompany.jsp";
	}
}
