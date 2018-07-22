package matheusicaro.com.github.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("ENTRANDO NA HOME");
		
		return "Home";
	}
}

	