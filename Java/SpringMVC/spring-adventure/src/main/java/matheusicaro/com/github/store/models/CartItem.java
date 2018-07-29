package matheusicaro.com.github.store.models;

public class CartItem {
	
	private Product product;
	private EnumTypePrice type;
	
	
	public CartItem (Product product, EnumTypePrice type){
		this.product = product;
		this.type = type;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public EnumTypePrice getType() {
		return type;
	}
	public void setType(EnumTypePrice type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type != other.type)
			return false;
		return true;
	}
	
	
	
	
}
