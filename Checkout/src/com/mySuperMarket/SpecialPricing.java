package com.mySuperMarket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SpecialPricing implements Pricing {

	public static Map<String, BigDecimal> specialSkuPrice = new HashMap<>();
	public static Map<String, Integer> specialSkuPriceThreshold = new HashMap<>();
	static{
		specialSkuPriceThreshold.put(SKU_A, 3);
		specialSkuPriceThreshold.put(SKU_B, 2);
		specialSkuPrice.put(SKU_A, BigDecimal.valueOf(130));
		specialSkuPrice.put(SKU_B, BigDecimal.valueOf(45));
    }
	
	@Override
	public BigDecimal price(String sku , int quantity) {
		int specialPriceEligibleItems = quantity / specialSkuPriceThreshold.get(sku);
		BigDecimal specialPrice = specialSkuPrice.get(sku).multiply(BigDecimal.valueOf(specialPriceEligibleItems));
		return specialPrice;
	}
}
