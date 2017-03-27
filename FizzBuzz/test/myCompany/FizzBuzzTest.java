package myCompany;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class FizzBuzzTest {
	
	private FizzBuzz fizzBuzz;
	
	@Before
	public void setUp() {
		fizzBuzz = new FizzBuzz();
	}
	
	@Test
	public void outputFizzIfDividedBy3(){
		Assert.assertEquals("fizz", fizzBuzz.generatefizzBuzz(9));
	}
	
	@Test
	public void outputBuzzIfDividedBy5(){
		Assert.assertEquals("buzz", fizzBuzz.generatefizzBuzz(25));
	}
	
	@Test
	public void outputFizzBuzzIfDividedBy15(){
		Assert.assertEquals("fizzbuzz", fizzBuzz.generatefizzBuzz(45));
	}
	
	@Test
	public void outputSameNumberIfNoRequirementsFulfilled(){
		Assert.assertEquals(String.valueOf(56), fizzBuzz.generatefizzBuzz(56));
	}
	
	
}
