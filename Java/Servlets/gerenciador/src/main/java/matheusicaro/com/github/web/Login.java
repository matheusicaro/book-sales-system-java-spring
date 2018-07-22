package matheusicaro.com.github.web;

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

import matheusicaro.com.github.dao.UserDAO;
import matheusicaro.com.github.gerenciador.User;

public class Login implements Task {
	

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		String login = req.getParameter("user");
		String password = req.getParameter("password");
		
		Boolean returnAuthentication = authenticationUser(login, password, req);
		String msgStatusLogin;
		
		if (returnAuthentication)
			msgStatusLogin = "Login efetuado com Sucesso!";
		else 
			msgStatusLogin = "Login ou senha invalidos";
		
		
		req.setAttribute("msgStatusLogin", msgStatusLogin);
		return "/WEB-INF/pages/Login.jsp";
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
