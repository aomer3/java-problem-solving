package udemy.Karimov.DSA.arrays;

import java.util.Arrays;

/*Write a function which takes integer array as a parameter and returns 
 * a new integer array with unique elements. (remove duplicates)

	Example
	
	removeDuplicates({1, 1, 2, 2, 3, 4, 5})
	Output : [1, 2, 3, 4, 5]
 * 
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] numbers = {1, 1, 2, 2,3, 4, 5};
		
		System.out.print("Array: ");
		displayArray(numbers);
		displayDuplicates(numbers);
		displayRemoveDuplicates(numbers);

	}
	
	public static void displayRemoveDuplicates(int[] numbers) {
		int[] result = removeDuplicates(numbers);
		
		System.out.print("Without duplicates: ");
		displayArray(result);
	}
	
	public static int[] removeDuplicates(int[] array) {
		int[] newArray = new int[array.length];
		int j=0;
		
		for (int i = 0; i < array.length-1; i++) {	
			if(array[i] != array[i+1]) {
				newArray[j++] = array[i];
			}
			
		}
		
		newArray[j++] = array[array.length-1];
		
		//Removes zeros and resizes array
		int[] result = removeZeros(newArray);
				
		return result;
	}
	
	public static int[] removeZeros(int[] array) {
		int count=0;
		for(int num: array) {
			if(num == 0) {
				count++;
			}
		}
		
		int result[] = new int[array.length - count];
		int index=0;
		
		for(int i=0; i < array.length; i++) {
			if(array[i] != 0) {
				result[index] = array[i];
				index++;
			}
		}
		
		return result;
	}
	
	public static void displayDuplicates(int[] numbers) {
		int[] newArray = findDuplicates(numbers);
		int[] result = removeZeros(newArray);
		System.out.print("Duplicates: " );
		displayArray(result);
	}
	
	public static int[] findDuplicates(int[] array) {
		int[] newArray = new int[array.length];
		int j=0;
		
		for(int i=0; i < array.length-1; i++) {
			if(array[i] == array[i+1]) {
				newArray[j++] = array[i];
			}
		}
		
		
		
		return newArray;
	}
	
	public static void displayArray(int[] array) {
		for(int num: array) {
			System.out.print(num + " ");
		}
		System.out.println(" ");
	}

}
