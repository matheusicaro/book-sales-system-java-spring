package matheusicaro.com.github.store.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

	private Map<CartItem, Integer> items = new LinkedHashMap<>(); //**** CartItem
	
	public void addItemShoppingCart (CartItem item) {
		if(!items.containsKey(item))
			items.put(item, (items.size() + 1));
		else
			System.out.println("Já Existe este produto no seu Carrinho");
	}
	
	public int getQuantities() {															//${shoppingCart.quantities} return quantities in shopping cart
	    return items.values().stream().reduce(0, (next, cont) -> next + cont);
	}
}
