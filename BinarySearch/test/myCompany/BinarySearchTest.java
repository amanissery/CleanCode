package myCompany;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BinarySearchTest {
	
	private BinarySearch binarySearch;
	
	@Test(expected = IllegalArgumentException.class)
	public void searchForNumberInEmptyArray(){
		binarySearch.search(5,new int[0]);
	}
	
	@Test
	public void searchForTheOnlyNumber(){
		Assert.assertEquals(0, binarySearch.search(2, new int[]{2}));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void searchForInvalidNumberInASingleEntryArray(){
		binarySearch.search(5,new int[]{2});
	}
	
	@Test
	public void searchForTheFirstNumberInAMultipleEntryAray(){
		Assert.assertEquals(0, binarySearch.search(1, new int[]{1,2,4,8,17}));
	}
	
	@Test
	public void searchForTheLastNumberInAMultipleEntryAray(){
		Assert.assertEquals(4, binarySearch.search(17, new int[]{1,2,4,8,17}));
	}
	
	@Test
	public void searchForANumberInBetweenFirstAndLastNumberInAMultipleEntryAray(){
		Assert.assertEquals(3, binarySearch.search(8, new int[]{1,2,4,8,17}));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void searchForInvalidNumberInAMultipleEntryArray(){
		binarySearch.search(0,new int[]{1,2,3});
	}
	
	@Before
	public void setUp() {
		binarySearch = new BinarySearch();
	}
}
