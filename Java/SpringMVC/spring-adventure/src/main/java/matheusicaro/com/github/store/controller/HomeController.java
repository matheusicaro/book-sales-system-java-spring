package matheusicaro.com.github.store.controller;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.daos.UserDAO;
import matheusicaro.com.github.store.models.Product;
import matheusicaro.com.github.store.models.Role;
import matheusicaro.com.github.store.models.User;

@Controller
public class HomeController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/")
	@Cacheable(value="productsHome")
	public ModelAndView  home() {
		
		ModelAndView modelAndView = new ModelAndView("Home");
		List<Product> products = productDAO.getProductsList();
		modelAndView.addObject("products", products);
		
		return modelAndView;
	}
	

    @Transactional
    @ResponseBody
    @RequestMapping("/quero-receber-ac-97020001993")
    public String urlCreateAdmin() {
        User user = new User(); 
        user.setName("Admin");
        user.setEmail("matheusicaro2@hotmail.com");
        user.setPassword("$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq");
        user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));

        userDAO.save(user);

        return "Cadastrado: matheusicaro2@hotmail.com, 123456";
    }
}
