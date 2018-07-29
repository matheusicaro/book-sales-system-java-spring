package matheusicaro.com.github.store.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Price {

	private BigDecimal value;
	private EnumTypePrice type;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public EnumTypePrice getType() {
		return type;
	}

	public void setType(EnumTypePrice type) {
		this.type = type;
	}
}
