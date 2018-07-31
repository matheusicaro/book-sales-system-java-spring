package matheusicaro.com.github.store.models;

import java.math.BigDecimal;

public class PaymantData {

	private BigDecimal value;

    public PaymantData(BigDecimal value) {
        this.value = value;
    }

    public PaymantData() {
    }

    public BigDecimal getValue() {
        return value;
    }

}
