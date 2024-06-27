package udemy.Karimov.DSA.arrays;

import java.util.Arrays;

/*Write a program to to check if an array contains a number in Java.

	int[] intArray = {1,2,3,4,5,6};
	searchInArray(intArray, 6); // 5
 * 
 */
public class FindNumber {

	public static void main(String[] args) {
		displaySearchResult();
	}
	
	public static void displaySearchResult() {
		int[] array = {1,2,3,4,5,6};
		int search = 6;
		int result = searchNumber(array, search);
		
		System.out.println("Array: " + Arrays.toString(array));
		System.out.println("Search for: " + search);
		
		if(result == -1) {
			System.out.println("Number is not in array");
		}
		else {
			System.out.println("Found at index: " + result);
		}
	}
	
	public static int searchNumber(int[] array, int search) {
		int foundIndex=0;
		boolean isFound = false;
		
		for(int i=0; i < array.length; i++) {
			if(array[i] == search) {
				foundIndex = i;
				isFound = true;
				break;
			}
		}
		
		if(!isFound) {
			return -1;
		}
		
		return foundIndex;
	}

}
