package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.User;
import br.com.alura.gerenciador.dao.UserDAO;

@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("user");
		String password = req.getParameter("password");
		PrintWriter writer = resp.getWriter();
		
		Boolean returnAuthentication = authenticationUser(login, password, req);
		
		if(returnAuthentication) {
			writer.println("Login efetuado com Sucesso!");
		}else {
			writer.println("Login ou senha invalidos");
		}

	}

	private Boolean authenticationUser(String email, String password, HttpServletRequest req) {

		User user = new UserDAO().searchForEmailPassword(email, password);
		
		if(user == null) {
			return false;
		}else {
			
			HttpSession session = req.getSession();
			session.setAttribute("userLogged", user);
			return true;
		}
	}
}
