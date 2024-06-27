package udemy.Karimov.DSA.arrays;

import java.util.Arrays;

/*Your are given two integer arrays. Write a program to check if they are permutation of each other.

	Example
	
	int[] array1 = {1,2,3,4,5};
	int[] array2 = {5,1,2,3,4};
	permutation(array1, array2)
 * 
 */
public class Permutation {

	public static void main(String[] args) {
		displayResult();
	}
	
	public static void displayResult() {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {5,1,2,3,4};
		boolean isPermutation = checkPermutation(array1, array2);
		
		System.out.println("Array 1: " + Arrays.toString(array1));
		System.out.println("Array 2: " + Arrays.toString(array2));
		System.out.println("Is permutation: " + isPermutation);
	}
	
	public static boolean checkPermutation(int[] array1, int[] array2) {
		boolean isPermutation = true;
		int j=0;
		
		if(array1.length != array2.length || array1.length == 0 || array2.length == 0) {
			return false;
		}
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		for(int i=0; i < array1.length; i++){		
			if(array1[i] != array2[j]) {
				isPermutation = false;
			}
			
			j++;
		}
		
		return isPermutation;
	}

}
