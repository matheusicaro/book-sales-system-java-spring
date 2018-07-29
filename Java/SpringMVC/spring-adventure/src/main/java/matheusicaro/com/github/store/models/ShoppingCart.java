package matheusicaro.com.github.store.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

	private Map<CartItem, Integer> items = new LinkedHashMap<>(); //**** CartItem
	
	public void addItemShoppingCart (CartItem item) {
		items.put(item, getCartQuantities(item));
	}

	private int getCartQuantities(CartItem item) {

		if(!items.containsKey(item))
			return items.put(item, 0); 
		
		return items.get(item);
	}
	
	public int getQuantities() {															//${shoppingCart.quantities} return quantities in shopping cart
	    return items.values().stream().reduce(0, (next, cont) -> next + cont);
	}
}
