package udemy.Karimov.DSA.arrays;

/*Write Java function called findMissingNumberInArray that takes an integer array 
 * containing n-1 unique elements from a range of 1 to n, with one missing number, and returns the missing number.

	Example
	
	myArray = {1,2,3,4,6}
	findMissingNumberInArray(myArray, 6) // 5
 * 
 */
public class MissingNumber {

	public static void main(String[] args) {
		displayMissingNumber();
	}
	
	public static void displayMissingNumber() {
		int[] array = {1,2,3,4,6};
		int result = findMissingNumberInArray(array);
		
		System.out.println(result);
	}
	
	public static int findMissingNumberInArray(int[] array) {
		//Get largest element in array
		int max = array[array.length-1];
		
		int expectedSum = (max * (max + 1)) / 2;
		
		int arraySum=0;
				
		for (int i : array) {
			arraySum += i;
		}
		
	
		return expectedSum - arraySum;
	}

}
