package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Company;
import br.com.alura.gerenciador.dao.CompanyDAO;

@WebServlet(urlPatterns = "/NewCompany")
public class NewCompany extends HttpServlet {
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        Company company = new Company(name);
        new CompanyDAO().add(company);

        req.setAttribute("name", name);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/logout.jsp");
        dispatcher.forward(req, resp);
    }
}
