package matheusicaro.com.github.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.models.CartItem;
import matheusicaro.com.github.store.models.EnumTypePrice;
import matheusicaro.com.github.store.models.Product;
import matheusicaro.com.github.store.models.ShoppingCart;



@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

	@Autowired
	ShoppingCart shoppingCart;
	
    @Autowired
    private ProductDAO productDAO;
	
    
    @RequestMapping("/add")
	public ModelAndView add(Integer productId, EnumTypePrice typePrice) {
		System.out.println("ETROOOOOOOOOU");
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        CartItem cartItem = createCartItem (productId, typePrice);
        
        shoppingCart.addItemShoppingCart(cartItem);
        
		return modelAndView;

	}

	private CartItem createCartItem(Integer idProduct, EnumTypePrice typePrice) {

		Product product = productDAO.find(idProduct); 
		return new CartItem(product, typePrice);
	}

}




