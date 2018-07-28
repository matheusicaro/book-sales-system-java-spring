package matheusicaro.com.github.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.infra.FileSaver;
import matheusicaro.com.github.store.models.EnumTypeBook;
import matheusicaro.com.github.store.models.Product;
import matheusicaro.com.github.store.validation.ProductsValidation;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.addValidators(new ProductsValidation());
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView pricesOfProducts = new ModelAndView("products/form");
		pricesOfProducts.addObject("typesBook", EnumTypeBook.values());
		return pricesOfProducts;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(MultipartFile sumaryFile, @Valid Product product, BindingResult result, RedirectAttributes redirectAttributes) {
		
		
		if(result.hasErrors())
			return form(product);

		String pathFolder = fileSaver.write("files", sumaryFile, product.getTitle());
		product.setSumarioPath(pathFolder);
		productDAO.toSave(product);
	    redirectAttributes.addFlashAttribute("success", "Sucesso ao adicionar o livro!");
	    
	    return new ModelAndView("redirect:products");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView productsList (){
		List<Product> products = productDAO.getProductsList();
		ModelAndView productsList = new ModelAndView("products/products-list");
		productsList.addObject("products", products);
		return productsList;
	}

}
