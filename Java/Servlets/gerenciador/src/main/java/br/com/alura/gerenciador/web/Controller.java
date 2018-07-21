package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/Controller")
public class Controller extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String task = (String) req.getParameter("task");
		System.out.println();
		if(task == null) {
			throw new IllegalArgumentException("Tarefa não existe!");
		}
		
		try {
			String nameClass = "br.com.alura.gerenciador.web." + task;
			Class type = Class.forName(nameClass);
			Task instance = (Task) type.newInstance();
			String page = instance.execute(req, resp);
			RequestDispatcher requestDispacher = req.getRequestDispatcher(page);
			requestDispacher.forward(req, resp);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
