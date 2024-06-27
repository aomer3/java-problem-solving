package udemy.Karimov.DSA.arrays;

import java.util.Arrays;

/*Write a program to check if an array is unique or not.

	Example
	
	int[] intArray = {1,2,3,4,5,6};
	isUnique(intArray) // true
 * 
 */
public class ContainsDuplicates {

	public static void main(String[] args) {
		displayResult();
	}
	
	public static void displayResult() {
		int[] array = {1,2,3,4,5,6};
		boolean isDuplicate = containsDuplicates(array);
		
		System.out.println("Array: " + Arrays.toString(array) + 
				           "\n" + "Contains duplicates: " + isDuplicate);
	}
	
	public static boolean containsDuplicates(int[] array) {
		int[] duplicates = new int[array.length];
		int j=0;
		
		for(int i=0; i < array.length-1; i++) {
			if(array[i] != array[i+1]) {
				duplicates[j++] = array[i];
			}
		}

		duplicates[j++] = array[array.length-1];		
		int last = duplicates[duplicates.length-1];

 		if(last == 0) {
			return true;
		}
 		
 		return false;
	}

}
