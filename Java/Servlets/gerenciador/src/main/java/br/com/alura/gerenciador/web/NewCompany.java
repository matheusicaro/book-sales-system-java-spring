package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/NewCompany")
public class NewCompany extends HttpServlet {
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        Empresa company = new Empresa(name);
        new EmpresaDAO().adiciona(company);
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>Empresa " + name + " adicionada!</body></html>");

    }
}
