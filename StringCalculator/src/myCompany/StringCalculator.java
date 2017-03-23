package myCompany;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private static String DEFAULT_DELIMITER = ",|\n";
	private static String CUSTOM_DELIMITER_START_INDICATOR = "//";
	private static String CUSTOM_DELIMITER_END_INDICATOR = "\n";
	
	public int add(final String numbers) throws IllegalArgumentException{
		int sum = 0;
		if(numbers.length() != 0){
			String[] extractedNumbers;
			if(numbers.startsWith(CUSTOM_DELIMITER_START_INDICATOR)){
				String delimiter = findCustomDelimiter(numbers);
				String numbersWithCustomDelimiter = extractNumbersWithDelimiter(numbers);
				extractedNumbers = extractNumbers(numbersWithCustomDelimiter, delimiter);
			}else{
				extractedNumbers = extractNumbers(numbers, DEFAULT_DELIMITER);
			}
			List<Integer> negativeNumbers = new ArrayList<Integer>();
			for(String number : extractedNumbers){
				int parsedNumber = Integer.parseInt(number);
				if(parsedNumber < 0){
					negativeNumbers.add(parsedNumber);
				}else{
					sum += parsedNumber;
				}
			}
			if(!negativeNumbers.isEmpty()){
				throw new IllegalArgumentException("Negatives not allowed" + negativeNumbers.toString());
			}
		}
		return sum;
	}

	private String findCustomDelimiter(String numbers) {
		int delimiterStartIndex = CUSTOM_DELIMITER_START_INDICATOR.length();
		int delimiterEndIndex = numbers.indexOf(CUSTOM_DELIMITER_END_INDICATOR);
		return numbers.substring(delimiterStartIndex, delimiterEndIndex);
	}

	private String extractNumbersWithDelimiter(final String numbers) {
			int delimiterEndIndex = numbers.indexOf(CUSTOM_DELIMITER_END_INDICATOR);
			return numbers.substring(delimiterEndIndex + 1);
	}

	private String[] extractNumbers(final String numbers, String delimiter) {
		return numbers.split(delimiter);
	}

}
