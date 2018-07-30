package matheusicaro.com.github.store.models;

import java.math.BigDecimal;

public class CartItem {
	
	private Product product;
	private EnumTypePrice typePrice;
	
	
	public CartItem (Product product, EnumTypePrice type){
		this.product = product;
		this.typePrice = type;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public EnumTypePrice getTypePrice() {
		return typePrice;
	}
	public void setTypePrice(EnumTypePrice type) {
		this.typePrice = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((typePrice == null) ? 0 : typePrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (typePrice != other.typePrice)
			return false;
		return true;
	}
	
    public BigDecimal getPrice() {
        return product.toPrice(typePrice);
    }

    public BigDecimal getTotal(int quantity) {
        return this.getPrice().multiply(new BigDecimal(quantity));
    }
}
