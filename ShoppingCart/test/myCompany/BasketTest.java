package myCompany;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import junit.framework.Assert;

public class BasketTest {
	
	Basket basket;
	
	@Before
	public void setUp() {
		basket = new Basket();
	}
	
	
	@Test
	public void itemsCanBeAddedToTheBasket() throws Exception{ 
		basket.add(product("20.00"));
		basket.add(product("20.00"));
		Assert.assertEquals(2, basket.size());
	}

	public Product product(String price) {
		return new Product(price);
	}
	
	public Book book(String price) {
		return new Book(price);
	}
	
	public Video video(String price) {
		return new Video(price);
	}
	
	@Test
	public void basketCanCalculateTotalPrice() throws Exception{
		basket.add(product("20.00"));
		basket.add(product("10.00"));
		compare(new BigDecimal("30.00"), basket.total());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void basketCanNotAddProductsWithNegativePrice() throws Exception{
		basket.add(product("-20.00"));
	}
	
	@Test
	public void basketCanAddItemsWithZeroPrice() throws Exception{
		basket.add(product("0.00"));
		compare(new BigDecimal("0.00"), basket.total());
	}
	
	@Test
	public void basketCanAddItemsWithSalesTax(){
		basket.add(product("100.00"));
		basket.add(product("200.00"));
		compare(new BigDecimal("330.00"), basket.totalWithSalesTax());
	}

	public void compare(BigDecimal expected, BigDecimal actual) {
		Assert.assertEquals("Expected :"+ expected + " but actual :"+
				actual,0,expected.compareTo(actual));
	}
	
	@Test
	public void basketCanAddItemsWithArbitrarySalesTax(){
		basket.add(product("100.00"));
		basket.add(product("200.00"));
		compare(new BigDecimal("360.00"), basket.totalWithArbitrarySalesTax("1.2"));
	}
	
	@Test
	public void differentTypesOfProductsCanBeAddedToBasket(){
		basket.add(book("9.99"));
		basket.add(video("12.99"));
		compare(new BigDecimal("22.98"), basket.total());
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void basketCanAddItemWithPromotions(){
		basket.add(book("10.00"));
		basket.add(video("20.00"));
		Promotion mockPromotion = mock(Promotion.class);
		when(mockPromotion.applyTo(isA(Video.class))).thenReturn(new BigDecimal("19.00"));
		when(mockPromotion.applyTo(isA(Book.class))).thenReturn(new BigDecimal("10.00"));
		basket.setPromotion(mockPromotion);
		compare(new BigDecimal("29.00"), basket.total());
	}
}
