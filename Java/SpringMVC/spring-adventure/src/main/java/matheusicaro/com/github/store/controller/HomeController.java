package matheusicaro.com.github.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.models.Product;

@Controller
public class HomeController {
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping("/")
	@Cacheable(value="productsHome")
	public ModelAndView  home() {
		
		ModelAndView modelAndView = new ModelAndView("Home");
		List<Product> products = productDAO.getProductsList();
		modelAndView.addObject("products", products);
		
		return modelAndView;
	}
}

	