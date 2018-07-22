package matheusicaro.com.github.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.tomcat.util.buf.CharChunk.CharInputChannel;

import matheusicaro.com.github.gerenciador.User;


@WebFilter(urlPatterns = "/*")
public class AuditFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User userLogged =  (User) session.getAttribute("userLogged");
		String user = "<deslogado>";
		
		if(userLogged != null)
			user =  userLogged.getEmail();
	
		System.out.println("Usuario: " + user + " Acessando: " + req.getRequestURI());

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
