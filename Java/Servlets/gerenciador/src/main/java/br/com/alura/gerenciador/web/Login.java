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

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("user");
		String password = req.getParameter("password");
		PrintWriter writer = resp.getWriter();

		Boolean returnAuthentication = authenticationUser(login, password, writer);
		if(returnAuthentication) {
			Cookie cookieLoggedUser = new Cookie("userLogged", login);
			resp.addCookie(cookieLoggedUser);
		}

	}

	private Boolean authenticationUser(String login, String password, PrintWriter writer) {

		Usuario user = new UsuarioDAO().buscaPorEmailESenha(login, password);

		if(user == null) {
			writer.println("Login ou senha invalidos");
			return false;
		}else {
			writer.println("Sucesso!\n" 
				+ "Login :" + user.getEmail() + "\t"  
				+ "Senha :" + user.getSenha());
			return true;
		}
	}
}
