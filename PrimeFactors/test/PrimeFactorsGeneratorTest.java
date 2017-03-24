import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class PrimeFactorsGeneratorTest {
	
	private PrimeFactorsGenerator primeFactorsGenerator = new PrimeFactorsGenerator();

	@Test
	public void primeFactorsOf0(){
		Assert.assertTrue(primeFactorsGenerator.generate(0).isEmpty());
	}
	
	@Test
	public void primeFactorsOf1(){
		Assert.assertTrue(primeFactorsGenerator.generate(1).isEmpty());
	}
	
	@Test
	public void primeFactorsOfAPrimeNumber(){
		Assert.assertTrue(primeFactorsGenerator.generate(11).isEmpty());
	}
	
	@Test
	public void primeFactorsOfACompositeNumber(){
		Assert.assertEquals(Arrays.asList(2,3,5,7), primeFactorsGenerator.generate(210));
	}
}
