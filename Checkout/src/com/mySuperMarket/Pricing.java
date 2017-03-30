package com.mySuperMarket;

import java.math.BigDecimal;

public interface Pricing {
	public static final String SKU_D = "D";
	public static final String SKU_C = "C";
	public static final String SKU_B = "B";
	public static final String SKU_A = "A";
	public BigDecimal price(String sku, int quantity);
}
