package myCompany;

public class FizzBuzz {

	public String generateFizzBuzz(int number) {
		return (number % 15 == 0)?"fizzbuzz":
			(number % 3 == 0)? "fizz": 
			(number % 5 == 0) ? "buzz": String.valueOf(number);
	}

}
