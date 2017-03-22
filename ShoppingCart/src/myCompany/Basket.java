package myCompany;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {
	
	private static final String DEFAULT_SALES_TAX = "1.1";
	private Promotion promotion;
	private List<Product> items = new ArrayList<Product>();

	public void add(Product product) {
		if(product.getPrice().compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("Can't add product with negative price");
		}
		items.add(product);
	}

	public int size() {
		return items.size();
	}

	public BigDecimal total(){
		BigDecimal total = new BigDecimal("0.00");
		for(Product product : items){
			if(promotion != null){
				total = total.add(promotion.applyTo(product));
			}else{
				total = total.add(product.getPrice());
			}
		}
		return total;
	}

	public BigDecimal totalWithSalesTax() {
		return totalWithArbitrarySalesTax(DEFAULT_SALES_TAX);
	}

	public BigDecimal totalWithArbitrarySalesTax(String salesTaxFactor) {
		
		return total().multiply(new BigDecimal(salesTaxFactor));
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
}
