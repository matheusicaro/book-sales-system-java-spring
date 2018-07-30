package matheusicaro.com.github.store.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION) // SCOPE.SESSION: Enables a new instance for each new access, that is,
												  // For each new shopping cart created, we will have a new object. In this case,
												  // is required for a shopping cart in which each user will get yours.
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<CartItem, Integer> items = new LinkedHashMap<>();
	
	public void addItemShoppingCart (CartItem item) {
		if(!items.containsKey(item))
			items.put(item, (items.size() + 1));
		else
			System.out.println("Já Existe este produto no seu Carrinho, adicione mais unidades deste produto nos detalhes do carrinho");
	}
	
	public int getQuantities() {
	    return items.values().stream().reduce(0, (next, cont) -> next + cont);
	}
	
	public Collection<CartItem> getItems(){
		return items.keySet();
	}
	
    public BigDecimal getTotal(CartItem item) {
        return item.getTotal(getQuantities(item));
    }

    public int getQuantities(CartItem item) {
		return items.get(item);
	}

	public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (CartItem item : items.keySet()) {
            total = total.add(getTotal(item));
        }
        return total ;
    }
	
	
}
