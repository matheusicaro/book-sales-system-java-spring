package br.com.alura.gerenciador.web;

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

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.tomcat.util.buf.CharChunk.CharInputChannel;


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
		
		Cookie getLoggedUser = getUserCookie(req);
		String user = "<deslogado>";
		
		if(getLoggedUser != null)
			user =  getLoggedUser.getValue();
	
		System.out.println("Usuario: " + user + " Acessando: " + req.getRequestURI());

		chain.doFilter(request, response);

	}


		private Cookie getUserCookie(HttpServletRequest req) {
			
			Cookie []getLoggedUser = req.getCookies();
			
			if(getLoggedUser == null)
				return null;
			
			for (Cookie cookie : getLoggedUser) {
				if (cookie.getName().equals("userLogged")) {
					return cookie;
				}
			}
			
			return null;
		}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
