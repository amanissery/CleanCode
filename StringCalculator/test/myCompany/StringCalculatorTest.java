package myCompany;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class StringCalculatorTest {
	
	private StringCalculator stringCalculator;
	
	@Before
	public void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void calculatorAcceptEmptyString() throws Exception{
		Assert.assertEquals(0, stringCalculator .add(""));
	}
	
	@Test
	public void calculatorCanAddOneNumber() throws Exception{
		Assert.assertEquals(20, stringCalculator .add("20"));
	}
	
	@Test
	public void calculatorCanAddTwoNumbers() throws Exception{
		Assert.assertEquals(50, stringCalculator .add("20,30"));
	}
	
	@Test
	public void calculatorCanAddMoreThanTwoNumbers() throws Exception{
		Assert.assertEquals(100, stringCalculator.add("10,20,30,40"));
	}
	
	@Test
	public void calculatorCanTakeNewLineAsDelimiter() throws Exception{
		Assert.assertEquals(20, stringCalculator.add("0,1\n4,5\n10"));
	}
	
	@Test
	public void calculatorCanTakeCustomDelimiter() throws Exception{
		Assert.assertEquals(60, stringCalculator.add("//abcd\n10abcd20abcd30"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculatorCanNotAddNegativeNumbers() throws Exception{
		stringCalculator.add("10,20,-30");
	}
}
