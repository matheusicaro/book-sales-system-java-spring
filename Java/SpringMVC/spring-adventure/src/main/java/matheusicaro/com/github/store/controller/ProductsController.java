package matheusicaro.com.github.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.models.Product;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("products/form")
	public String form() {
		return "products/form";
	}
	

	@RequestMapping("products")
	public String save(Product product) {
	    System.out.println(product);
	    productDAO.toSave(product);
	    return "products/success";
	}
	
}
