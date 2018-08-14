package matheusicaro.com.github.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.models.CartItem;
import matheusicaro.com.github.store.models.EnumTypePrice;
import matheusicaro.com.github.store.models.Product;
import matheusicaro.com.github.store.models.ShoppingCart;



@Controller
@RequestMapping("/shopping-cart")
@Scope(value=WebApplicationContext.SCOPE_REQUEST) // SCOPE.SESSION: Allows a new instance for each new request, that is,
												  // For access to our section, an instance will be created for the requested
												  // user, also a new object of the class. is required for a shopping cart in which
												  // each user will receive yours.
public class ShoppingCartController {

	@Autowired
	ShoppingCart shoppingCart;
	
    @Autowired
    private ProductDAO productDAO;
	
    
    @RequestMapping("/add")
	public ModelAndView add(Integer productId, EnumTypePrice typePrice) {
        ModelAndView modelAndView = new ModelAndView("redirect:/shopping-cart");
        CartItem cartItem = createCartItem (productId, typePrice);
        
        shoppingCart.addItemShoppingCart(cartItem);

        return modelAndView;

	}
    
	@RequestMapping(method=RequestMethod.POST) 
	public ModelAndView remove(Integer productId, EnumTypePrice typePrice) {
		shoppingCart.removeItemShoppingCart(productId, typePrice);
		return new ModelAndView("redirect:/shopping-cart");
	}
    
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView items(){
	    return new ModelAndView("cart/items");
	}

	private CartItem createCartItem(Integer productId, EnumTypePrice typePrice) {
		Product product = productDAO.find(productId); 
		return new CartItem(product, typePrice);
	}
}




