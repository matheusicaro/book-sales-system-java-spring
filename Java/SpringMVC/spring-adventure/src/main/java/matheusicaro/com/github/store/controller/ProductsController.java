package matheusicaro.com.github.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.models.EnumTypeBook;
import matheusicaro.com.github.store.models.Product;

@Controller
@RequestMapping("products")
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView pricesOfProducts = new ModelAndView("products/form");
		pricesOfProducts.addObject("typesBook", EnumTypeBook.values());
		return pricesOfProducts;
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public String save(Product product) {
	    System.out.println(product);
	    productDAO.toSave(product);
	    return "products/success";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView productsList (){
		List<Product> products = productDAO.getProductsList();
		ModelAndView productsList = new ModelAndView("products/products-list");
		productsList.addObject("products", products);
		return productsList;
	}

}
