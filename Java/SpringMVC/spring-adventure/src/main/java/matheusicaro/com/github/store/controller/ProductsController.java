package matheusicaro.com.github.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.infra.FileSaver;
import matheusicaro.com.github.store.models.EnumTypePrice;
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
		ModelAndView ModelAndViewPricesOfProducts = new ModelAndView("products/form");
		ModelAndViewPricesOfProducts.addObject("typesBook", EnumTypePrice.values());
		return ModelAndViewPricesOfProducts;
	}

	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict(value="productsHome", allEntries=true)
	public ModelAndView save(MultipartFile sumaryFile, @Valid Product product, BindingResult result, RedirectAttributes redirectAttributes) {
		System.out.println();
		List<Product> productsList = productDAO.getProductsList();
		
		if( productsList.size() > 5 ) {
		    redirectAttributes.addFlashAttribute("fail", "Limite de Livros no Banco! Limpe o banco de dados clicando ao lado -->");
		}else {
			if(result.hasErrors())
				return form(product);
			boolean uploadOfFileCancelled = true;
			String pathFolder = fileSaver.write("files", sumaryFile, product.getTitle(), uploadOfFileCancelled);
			product.setSumarioPath(pathFolder);
			productDAO.toSave(product);
		    redirectAttributes.addFlashAttribute("success", "Sucesso ao adicionar o livro!");
		}
		
	    
	    return new ModelAndView("redirect:/products");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView productsList (){
		List<Product> products = productDAO.getProductsList();
		ModelAndView ModelAndViewProductsList = new ModelAndView("products/products-list");
		ModelAndViewProductsList.addObject("products", products);
		return ModelAndViewProductsList;
	}
	
	@RequestMapping("/productsDetails/{id}")
	public ModelAndView productsDetails (@PathVariable("id") Integer id) {
		
		ModelAndView ModelAndViewProductDetails = new ModelAndView("products/products-details");
		Product product = productDAO.find(id);
		ModelAndViewProductDetails.addObject("products", product);
		return ModelAndViewProductDetails;
		
	} 
	
	@RequestMapping("/cleanDataBase")
	public ModelAndView cleanDataBase(RedirectAttributes redirectAttributes) {
		
		productDAO.cleanProducts();
		redirectAttributes.addFlashAttribute("success", "Banco Limpo!");
		return new ModelAndView("redirect:/products");
	}
}
