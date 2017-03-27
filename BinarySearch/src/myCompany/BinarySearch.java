package myCompany;

public class BinarySearch {

	public int search(int numberToSearch, int[] sortedArrayOfNumbers) throws IllegalArgumentException{
		int firstIndex = 0;
		int lastIndex = sortedArrayOfNumbers.length - 1;
		int middleIndex;
		while(firstIndex <= lastIndex){
			middleIndex = (firstIndex + lastIndex)/2;
			if(numberToSearch == sortedArrayOfNumbers[middleIndex]){
				return middleIndex;
			}
			else if(numberToSearch > sortedArrayOfNumbers[middleIndex]){
				firstIndex = middleIndex + 1;
				
			}else{
				lastIndex = middleIndex - 1;
			}
		}
		throw new IllegalArgumentException("Searched number not found in the array");
	}

}

