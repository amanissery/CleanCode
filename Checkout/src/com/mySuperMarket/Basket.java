package com.mySuperMarket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Basket {
	
	private static final String NOTHING = "";
	private static final String REGEX_SPLIT_SKUS_INDIVIDUALLY = "(?!^)";
	private Map<String, Integer> itemsQuantity;
	
	public BigDecimal checkout(String skus){
		if(skus.equals(NOTHING)){
			return BigDecimal.ZERO;
		}
		String[] skuItems = skus.split(REGEX_SPLIT_SKUS_INDIVIDUALLY);
		for(String sku : skuItems){
			scan(sku);
		}
		return calculateBasketTotal(itemsQuantity);
	}

	private void scan(String sku) {
		if(itemsQuantity == null){
			itemsQuantity = new HashMap<String, Integer>();
			itemsQuantity.put(sku, 1);
		}else{
			Integer skuQuantityInBasket = (itemsQuantity.get(sku) == null) ? 1 : itemsQuantity.get(sku) + 1;
			itemsQuantity.put(sku, skuQuantityInBasket);
		}
	}
	
	private BigDecimal calculateBasketTotal(Map<String, Integer> itemsCount) {
		BigDecimal basketTotal = BigDecimal.ZERO;
		for(String sku : itemsCount.keySet()){
			BigDecimal itemTotal = calculateItemTotal(sku, itemsCount.get(sku));
			basketTotal = basketTotal.add(itemTotal);
		}
		return basketTotal;
	}
	
	private BigDecimal calculateItemTotal(String sku, Integer itemQuantity) {
		BigDecimal itemPrice = BigDecimal.ZERO;
		Integer specialPriceThreshold = SpecialPricing.specialSkuPriceThreshold.get(sku);
		if(specialPriceThreshold != null && itemQuantity >= specialPriceThreshold){
			itemPrice = new SpecialPricing().price(sku, itemQuantity);
			itemQuantity = itemQuantity % specialPriceThreshold;
		}
		return itemPrice.add(new RegularPricing().price(sku, itemQuantity));
	}
}
