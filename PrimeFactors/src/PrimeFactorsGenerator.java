import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.MinimalHTMLWriter;

public class PrimeFactorsGenerator {
	private static Integer FIRST_PRIME_NUMBER = 2;
	
	public List<Integer> generate(final int number) {
		List<Integer> primeFactors = new ArrayList<Integer>();
		if(number > FIRST_PRIME_NUMBER){
			int divisor = FIRST_PRIME_NUMBER;
			int dividend = number;
			while(divisor <= Math.sqrt(dividend)){
				if(dividend % divisor == 0){
					primeFactors.add(divisor);
					dividend = dividend/divisor;
				}else{
					divisor++;
				}
			}
			if(number != dividend){
				primeFactors.add(dividend);
			}
		}
		return primeFactors;
	}

}


