package matheusicaro.com.github.store.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Price {
	
	private BigDecimal value;
	private EnumTypeBook type;
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public EnumTypeBook getType() {
		return type;
	}
	public void setType(EnumTypeBook type) {
		this.type = type;
	}
}
