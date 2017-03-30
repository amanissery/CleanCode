package com.mySuperMarket;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BasketTest {
	private Basket basket;
	
	@Before
	public void prepareCheckout(){
		basket = new Basket();
	}
	
	@Test
	public void checkoutNothingForZeroPrice(){
		Assert.assertEquals(BigDecimal.ZERO, basket.checkout(""));
	}
	
	@Test
	public void checkoutSingleSkuForRegularPrice(){
		Assert.assertEquals(new BigDecimal(50), basket.checkout("A"));
	}

	@Test
	public void checkoutDoubleSkuForRegularPrice(){
		Assert.assertEquals(new BigDecimal(80), basket.checkout("AB"));
	}
	
	@Test
	public void checkoutMultipleSkuForRegularPrice(){
		Assert.assertEquals(new BigDecimal(115), basket.checkout("CDBA"));
	}
	
	@Test
	public void checkoutSameSkuWithMultipleQuantity(){
		Assert.assertEquals(new BigDecimal(100), basket.checkout("AA"));
	}
	
	@Test
	public void checkoutSameSkuWithSpecialPrice(){
		Assert.assertEquals(new BigDecimal(130), basket.checkout("AAA"));
	}
	
	@Test
	public void checkoutSameSkuWithOneSpecialPriceAndOneRegularPrice(){
		Assert.assertEquals(new BigDecimal(180), basket.checkout("AAAA"));
	}
	
	@Test
	public void checkoutSameSkuWithOneSpecialPriceAndTwoRegularPrice(){
		Assert.assertEquals(new BigDecimal(230), basket.checkout("AAAAA"));
	}
	
	@Test
	public void checkoutSameSkuWithTwoSpecialPrice(){
		Assert.assertEquals(new BigDecimal(260), basket.checkout("AAAAAA"));
	}
	
	@Test
	public void checkoutTwoDifferentSkusWithOneSpecialPriceAndOneRegularPrice(){
		Assert.assertEquals(new BigDecimal(160), basket.checkout("AAAB"));
	}
	
	@Test
	public void checkoutTwoDifferentSkusWithTwoSpecialPrices(){
		Assert.assertEquals(new BigDecimal(175), basket.checkout("AAABB"));
	}
	
	@Test
	public void checkoutThreeDifferentSkusWithTwoSpecialPricesAndOneRegularPrice(){
		Assert.assertEquals(new BigDecimal(190), basket.checkout("AAABBD"));
	}
	
	@Test
	public void checkoutTwoDifferentSkusWithMixedOrder(){
		Assert.assertEquals(new BigDecimal(190), basket.checkout("DABABA"));
	}
}
