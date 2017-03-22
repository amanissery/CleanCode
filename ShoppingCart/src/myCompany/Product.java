package myCompany;

import java.math.BigDecimal;

public class Product {
	private BigDecimal price;

	public Product(String price) {
		this.price = new BigDecimal(price);
	}

	public BigDecimal getPrice() {
		return price;
	}
}
