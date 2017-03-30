package com.mySuperMarket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class RegularPricing implements Pricing {

	public static Map<String, BigDecimal> regularSkuPrice = new HashMap<>();
	
	static{
    	regularSkuPrice.put(SKU_A, BigDecimal.valueOf(50));
		regularSkuPrice.put(SKU_B, BigDecimal.valueOf(30));
		regularSkuPrice.put(SKU_C, BigDecimal.valueOf(20));
		regularSkuPrice.put(SKU_D, BigDecimal.valueOf(15));
	}
	
	@Override
	public BigDecimal price(String sku, int quantity) {
		return regularSkuPrice.get(sku).multiply(BigDecimal.valueOf(quantity));
	}

}
