package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;
	
	public Cookies (Cookie[] cookies) {
		System.out.println();
		this.cookies = cookies;
	}
	
	public Cookie getUserCookie() {
		
		if(cookies == null)
			return null;
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userLogged")) {
				return cookie;
			}
		}
		
		return null;
	}
}
